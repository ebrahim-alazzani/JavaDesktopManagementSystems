/* ===================================
   الفواتير - Billing Module
   =================================== */

function refreshBillingForm() {
    const subscribers = DataStore.get('subscribers') || [];
    const select = document.getElementById('billing-subscriber');
    const reportSelect = document.getElementById('report-subscriber');

    const options = '<option value="">-- اختر المشترك --</option>' +
        subscribers.map(s => `<option value="${s.id}">${s.name}</option>`).join('');

    if (select) select.innerHTML = options;
    if (reportSelect) reportSelect.innerHTML = options;

    // Load default price
    const settings = DataStore.get('settings');
    const priceInput = document.getElementById('billing-price');
    if (priceInput) priceInput.value = settings?.defaultPrice || 0.5;

    // Clear form
    clearBillingForm();
}

function clearBillingForm() {
    const fields = ['billing-prev-reading', 'billing-prev-debt', 'billing-curr-reading', 'billing-paid'];
    fields.forEach(id => {
        const el = document.getElementById(id);
        if (el) el.value = '';
    });

    // Clear preview
    const previewFields = {
        'preview-name': '-',
        'preview-consumption': '0 كيلو واط',
        'preview-bill': '0',
        'preview-old-debt': '0',
        'preview-total': '0',
        'preview-paid': '0',
        'preview-remaining': '0'
    };

    Object.entries(previewFields).forEach(([id, value]) => {
        const el = document.getElementById(id);
        if (el) el.textContent = value;
    });
}

function loadSubscriberData() {
    const subscriberId = document.getElementById('billing-subscriber').value;

    if (!subscriberId) {
        document.getElementById('billing-prev-reading').value = '';
        document.getElementById('billing-prev-debt').value = '';
        document.getElementById('preview-name').textContent = '-';
        return;
    }

    const subscribers = DataStore.get('subscribers') || [];
    const archive = DataStore.get('archive') || [];

    const subscriber = subscribers.find(s => s.id === subscriberId);
    if (!subscriber) return;

    // Find last record for this subscriber
    const lastRecord = archive.filter(a => a.subscriberId === subscriberId).pop();

    if (lastRecord) {
        document.getElementById('billing-prev-reading').value = lastRecord.currReading;
        document.getElementById('billing-prev-debt').value = lastRecord.remaining;
    } else {
        document.getElementById('billing-prev-reading').value = subscriber.openingReading || 0;
        document.getElementById('billing-prev-debt').value = subscriber.openingBalance || 0;
    }

    document.getElementById('preview-name').textContent = subscriber.name;
    calculateBill();
}

function calculateBill() {
    const prevReading = parseFloat(document.getElementById('billing-prev-reading').value) || 0;
    const currReading = parseFloat(document.getElementById('billing-curr-reading').value) || 0;
    const price = parseFloat(document.getElementById('billing-price').value) || 0;
    const paid = parseFloat(document.getElementById('billing-paid').value) || 0;
    const oldDebt = parseFloat(document.getElementById('billing-prev-debt').value) || 0;

    const consumption = Math.max(0, currReading - prevReading);
    const billAmount = consumption * price;
    const total = billAmount + oldDebt;
    const remaining = Math.max(0, total - paid);

    document.getElementById('preview-consumption').textContent = formatNumber(consumption) + ' كيلو واط';
    document.getElementById('preview-bill').textContent = formatNumber(billAmount);
    document.getElementById('preview-old-debt').textContent = formatNumber(oldDebt);
    document.getElementById('preview-total').textContent = formatNumber(total);
    document.getElementById('preview-paid').textContent = formatNumber(paid);
    document.getElementById('preview-remaining').textContent = formatNumber(remaining);
}

function saveBill() {
    const subscriberId = document.getElementById('billing-subscriber').value;
    const currReading = parseFloat(document.getElementById('billing-curr-reading').value);
    const prevReading = parseFloat(document.getElementById('billing-prev-reading').value) || 0;

    if (!subscriberId) {
        showToast('يرجى اختيار المشترك', true);
        return;
    }

    if (isNaN(currReading)) {
        showToast('يرجى إدخال القراءة الحالية', true);
        return;
    }

    if (currReading < prevReading) {
        showToast('القراءة الحالية يجب أن تكون أكبر من السابقة', true);
        return;
    }

    const subscribers = DataStore.get('subscribers') || [];
    const subscriber = subscribers.find(s => s.id === subscriberId);

    const price = parseFloat(document.getElementById('billing-price').value) || 0;
    const paid = parseFloat(document.getElementById('billing-paid').value) || 0;
    const oldDebt = parseFloat(document.getElementById('billing-prev-debt').value) || 0;

    const consumption = currReading - prevReading;
    const totalBill = consumption * price;
    const total = totalBill + oldDebt;
    const remaining = Math.max(0, total - paid);

    const invoice = {
        id: generateId(),
        date: new Date().toISOString(),
        subscriberId,
        subscriberName: subscriber.name,
        prevReading,
        currReading,
        consumption,
        price,
        totalBill,
        oldDebt,
        paid,
        remaining
    };

    const archive = DataStore.get('archive') || [];
    archive.push(invoice);
    DataStore.set('archive', archive);

    // Show invoice
    showInvoice(invoice);

    showToast('تم حفظ الفاتورة بنجاح');
    refreshBillingForm();
}

function showInvoice(invoice) {
    const settings = DataStore.get('settings') || {};
    const content = document.getElementById('invoice-content');

    content.innerHTML = `
        <div class="invoice-header">
            <h1>${settings.orgName || 'فاتورة استهلاك الكهرباء'}</h1>
            ${settings.orgAddress ? `<p>${settings.orgAddress}</p>` : ''}
            ${settings.orgPhone ? `<p>هاتف: ${settings.orgPhone}</p>` : ''}
        </div>
        
        <div class="invoice-info">
            <div>
                <p><strong>رقم الفاتورة:</strong> ${invoice.id.slice(-8).toUpperCase()}</p>
                <p><strong>التاريخ:</strong> ${formatDate(invoice.date)}</p>
            </div>
            <div>
                <p><strong>اسم المشترك:</strong> ${invoice.subscriberName}</p>
            </div>
        </div>
        
        <table class="invoice-table">
            <thead>
                <tr>
                    <th>البيان</th>
                    <th>القيمة</th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td>القراءة السابقة</td>
                    <td>${formatNumber(invoice.prevReading)}</td>
                </tr>
                <tr>
                    <td>القراءة الحالية</td>
                    <td>${formatNumber(invoice.currReading)}</td>
                </tr>
                <tr>
                    <td>الاستهلاك (كيلو واط)</td>
                    <td>${formatNumber(invoice.consumption)}</td>
                </tr>
                <tr>
                    <td>سعر الكيلو واط</td>
                    <td>${formatNumber(invoice.price)}</td>
                </tr>
                <tr>
                    <td>قيمة الاستهلاك</td>
                    <td>${formatNumber(invoice.totalBill)}</td>
                </tr>
                <tr>
                    <td>ديون سابقة</td>
                    <td>${formatNumber(invoice.oldDebt)}</td>
                </tr>
                <tr>
                    <td><strong>الإجمالي</strong></td>
                    <td><strong>${formatNumber(invoice.totalBill + invoice.oldDebt)}</strong></td>
                </tr>
                <tr>
                    <td>المبلغ المدفوع</td>
                    <td>${formatNumber(invoice.paid)}</td>
                </tr>
                <tr>
                    <td><strong>المتبقي</strong></td>
                    <td><strong style="color: #dc2626;">${formatNumber(invoice.remaining)}</strong></td>
                </tr>
            </tbody>
        </table>
        
        <div class="invoice-total">
            <p>المبلغ المتبقي: <strong>${formatNumber(invoice.remaining)}</strong></p>
        </div>
        
        <div style="text-align: center; margin-top: 40px; color: #64748b;">
            <p>شكراً لتعاملكم معنا</p>
        </div>
    `;

    openModal('invoice-modal');
}

function printInvoice() {
    window.print();
}
