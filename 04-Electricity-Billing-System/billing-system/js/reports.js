/* ===================================
   التقارير - Reports Module
   =================================== */

function refreshReports() {
    const archive = DataStore.get('archive') || [];
    const now = new Date();
    const thisMonth = archive.filter(inv => {
        const d = new Date(inv.date);
        return d.getMonth() === now.getMonth() && d.getFullYear() === now.getFullYear();
    });

    const monthlyInvoices = document.getElementById('report-monthly-invoices');
    const monthlyRevenue = document.getElementById('report-monthly-revenue');
    const monthlyCollected = document.getElementById('report-monthly-collected');
    const monthlyRemaining = document.getElementById('report-monthly-remaining');

    if (monthlyInvoices) monthlyInvoices.textContent = formatNumber(thisMonth.length);
    if (monthlyRevenue) monthlyRevenue.textContent = formatNumber(thisMonth.reduce((sum, inv) => sum + inv.totalBill, 0));
    if (monthlyCollected) monthlyCollected.textContent = formatNumber(thisMonth.reduce((sum, inv) => sum + inv.paid, 0));
    if (monthlyRemaining) monthlyRemaining.textContent = formatNumber(thisMonth.reduce((sum, inv) => sum + inv.remaining, 0));

    // Debt report
    const debtors = getDebtors();
    const debtorsCount = document.getElementById('report-debtors-count');
    const totalDebt = document.getElementById('report-total-debt');

    if (debtorsCount) debtorsCount.textContent = formatNumber(debtors.length);
    if (totalDebt) totalDebt.textContent = formatNumber(debtors.reduce((sum, d) => sum + d.debt, 0));

    // Refresh subscriber select
    const subscribers = DataStore.get('subscribers') || [];
    const select = document.getElementById('report-subscriber');
    if (select) {
        select.innerHTML = '<option value="">-- اختر المشترك --</option>' +
            subscribers.map(s => `<option value="${s.id}">${s.name}</option>`).join('');
    }
}

function generateMonthlyReport() {
    const archive = DataStore.get('archive') || [];
    const now = new Date();
    const thisMonth = archive.filter(inv => {
        const d = new Date(inv.date);
        return d.getMonth() === now.getMonth() && d.getFullYear() === now.getFullYear();
    });

    const content = document.getElementById('invoice-content');
    content.innerHTML = `
        <div class="invoice-header">
            <h1>التقرير الشهري</h1>
            <p>${now.toLocaleDateString('ar-EG', { month: 'long', year: 'numeric' })}</p>
        </div>
        
        <table class="invoice-table">
            <thead>
                <tr>
                    <th>التاريخ</th>
                    <th>المشترك</th>
                    <th>الاستهلاك</th>
                    <th>المبلغ</th>
                    <th>المدفوع</th>
                    <th>المتبقي</th>
                </tr>
            </thead>
            <tbody>
                ${thisMonth.map(inv => `
                    <tr>
                        <td>${formatDate(inv.date)}</td>
                        <td>${inv.subscriberName}</td>
                        <td>${formatNumber(inv.consumption)}</td>
                        <td>${formatNumber(inv.totalBill)}</td>
                        <td>${formatNumber(inv.paid)}</td>
                        <td>${formatNumber(inv.remaining)}</td>
                    </tr>
                `).join('') || '<tr><td colspan="6" style="text-align: center;">لا توجد فواتير هذا الشهر</td></tr>'}
            </tbody>
            <tfoot>
                <tr style="font-weight: bold; background: #f1f5f9;">
                    <td colspan="3">الإجمالي</td>
                    <td>${formatNumber(thisMonth.reduce((s, i) => s + i.totalBill, 0))}</td>
                    <td>${formatNumber(thisMonth.reduce((s, i) => s + i.paid, 0))}</td>
                    <td style="color: #dc2626;">${formatNumber(thisMonth.reduce((s, i) => s + i.remaining, 0))}</td>
                </tr>
            </tfoot>
        </table>
    `;

    openModal('invoice-modal');
}

function generateDebtReport() {
    const debtors = getDebtors();

    const content = document.getElementById('invoice-content');
    content.innerHTML = `
        <div class="invoice-header">
            <h1>تقرير المديونيات</h1>
            <p>${formatDate(new Date())}</p>
        </div>
        
        <table class="invoice-table">
            <thead>
                <tr>
                    <th>#</th>
                    <th>المشترك</th>
                    <th>المبلغ المستحق</th>
                </tr>
            </thead>
            <tbody>
                ${debtors.map((d, i) => `
                    <tr>
                        <td>${i + 1}</td>
                        <td>${d.name}</td>
                        <td style="color: #dc2626;">${formatNumber(d.debt)}</td>
                    </tr>
                `).join('') || '<tr><td colspan="3" style="text-align: center;">لا توجد مديونيات</td></tr>'}
            </tbody>
            <tfoot>
                <tr style="font-weight: bold; background: #f1f5f9;">
                    <td colspan="2">إجمالي المديونيات</td>
                    <td style="color: #dc2626;">${formatNumber(debtors.reduce((s, d) => s + d.debt, 0))}</td>
                </tr>
            </tfoot>
        </table>
    `;

    openModal('invoice-modal');
}

function generateSubscriberReport() {
    const subscriberId = document.getElementById('report-subscriber').value;
    if (!subscriberId) {
        showToast('يرجى اختيار المشترك', true);
        return;
    }

    const subscribers = DataStore.get('subscribers') || [];
    const archive = DataStore.get('archive') || [];

    const subscriber = subscribers.find(s => s.id === subscriberId);
    const invoices = archive.filter(a => a.subscriberId === subscriberId);

    const content = document.getElementById('invoice-content');
    content.innerHTML = `
        <div class="invoice-header">
            <h1>تقرير المشترك</h1>
            <p>${subscriber.name}</p>
        </div>
        
        <div class="invoice-info">
            <p><strong>تاريخ الاشتراك:</strong> ${formatDate(subscriber.createdAt)}</p>
            <p><strong>عدد الفواتير:</strong> ${invoices.length}</p>
            <p><strong>القراءة الافتتاحية:</strong> ${formatNumber(subscriber.openingReading || 0)}</p>
            <p><strong>الرصيد الافتتاحي:</strong> ${formatNumber(subscriber.openingBalance || 0)}</p>
        </div>
        
        <table class="invoice-table">
            <thead>
                <tr>
                    <th>التاريخ</th>
                    <th>قراءة سابقة</th>
                    <th>قراءة حالية</th>
                    <th>استهلاك</th>
                    <th>المبلغ</th>
                    <th>المدفوع</th>
                    <th>المتبقي</th>
                </tr>
            </thead>
            <tbody>
                ${invoices.map(inv => `
                    <tr>
                        <td>${formatDate(inv.date)}</td>
                        <td>${formatNumber(inv.prevReading)}</td>
                        <td>${formatNumber(inv.currReading)}</td>
                        <td>${formatNumber(inv.consumption)}</td>
                        <td>${formatNumber(inv.totalBill)}</td>
                        <td>${formatNumber(inv.paid)}</td>
                        <td>${formatNumber(inv.remaining)}</td>
                    </tr>
                `).join('') || '<tr><td colspan="7" style="text-align: center;">لا توجد فواتير</td></tr>'}
            </tbody>
            <tfoot>
                <tr style="font-weight: bold; background: #f1f5f9;">
                    <td colspan="4">الإجمالي</td>
                    <td>${formatNumber(invoices.reduce((s, i) => s + i.totalBill, 0))}</td>
                    <td>${formatNumber(invoices.reduce((s, i) => s + i.paid, 0))}</td>
                    <td style="color: #dc2626;">${formatNumber(invoices.length > 0 ? invoices[invoices.length - 1].remaining : subscriber.openingBalance || 0)}</td>
                </tr>
            </tfoot>
        </table>
    `;

    openModal('invoice-modal');
}
