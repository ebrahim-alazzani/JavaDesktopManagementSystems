/* ===================================
   إدارة المشتركين - Subscribers Module
   =================================== */

function refreshSubscribersTable() {
    const subscribers = DataStore.get('subscribers') || [];
    const archive = DataStore.get('archive') || [];
    const tbody = document.getElementById('subscribers-tbody');

    if (!tbody) return;

    tbody.innerHTML = subscribers.map((sub, index) => {
        const lastInvoice = archive.filter(a => a.subscriberId === sub.id).pop();
        const currentBalance = lastInvoice ? lastInvoice.remaining : (sub.openingBalance || 0);
        const lastReading = lastInvoice ? lastInvoice.currReading : (sub.openingReading || 0);

        return `
            <tr data-id="${sub.id}">
                <td>${index + 1}</td>
                <td>${sub.name}</td>
                <td>${sub.meterNumber || '-'}</td>
                <td>${sub.phone || '-'}</td>
                <td class="${currentBalance > 0 ? 'text-danger' : ''}">${formatNumber(currentBalance)}</td>
                <td>${formatNumber(lastReading)}</td>
                <td>
                    <button class="btn btn-icon" onclick="viewSubscriberDetails('${sub.id}')" title="التفاصيل">
                        <i class="fas fa-eye"></i>
                    </button>
                    <button class="btn btn-icon" onclick="editSubscriber('${sub.id}')" title="تعديل">
                        <i class="fas fa-edit"></i>
                    </button>
                    <button class="btn btn-icon" onclick="deleteSubscriber('${sub.id}')" title="حذف">
                        <i class="fas fa-trash"></i>
                    </button>
                </td>
            </tr>
        `;
    }).join('') || '<tr><td colspan="7" style="text-align: center; color: var(--text-muted);">لا يوجد مشتركين. قم بإضافة مشترك جديد.</td></tr>';
}

function addSubscriber() {
    const nameInput = document.getElementById('new-subscriber-name');
    const meterInput = document.getElementById('new-subscriber-meter');
    const phoneInput = document.getElementById('new-subscriber-phone');
    const addressInput = document.getElementById('new-subscriber-address');
    const subscriptionDateInput = document.getElementById('new-subscriber-date');
    const balanceInput = document.getElementById('new-subscriber-balance');
    const readingInput = document.getElementById('new-subscriber-reading');

    const name = nameInput.value.trim();
    const meterNumber = meterInput.value.trim();
    const phone = phoneInput.value.trim();
    const address = addressInput.value.trim();
    const subscriptionDate = subscriptionDateInput.value || new Date().toISOString().split('T')[0];
    const balance = parseFloat(balanceInput.value) || 0;
    const reading = parseFloat(readingInput.value) || 0;

    if (!name) {
        showToast('يرجى إدخال اسم المشترك', true);
        return;
    }

    const subscribers = DataStore.get('subscribers') || [];

    // Check for duplicate
    if (subscribers.some(s => s.name.toLowerCase() === name.toLowerCase())) {
        showToast('هذا الاسم موجود مسبقاً', true);
        return;
    }

    const newSubscriber = {
        id: generateId(),
        name: name,
        meterNumber: meterNumber,
        phone: phone,
        address: address,
        subscriptionDate: subscriptionDate,
        openingBalance: balance,
        openingReading: reading,
        createdAt: new Date().toISOString()
    };

    subscribers.push(newSubscriber);
    DataStore.set('subscribers', subscribers);

    closeModal('add-subscriber-modal');
    refreshSubscribersTable();
    refreshDashboard();
    showToast('تم إضافة المشترك بنجاح');

    // Clear form
    nameInput.value = '';
    meterInput.value = '';
    phoneInput.value = '';
    addressInput.value = '';
    subscriptionDateInput.value = '';
    balanceInput.value = '0';
    readingInput.value = '0';
}

function editSubscriber(id) {
    const subscribers = DataStore.get('subscribers') || [];
    const subscriber = subscribers.find(s => s.id === id);

    if (!subscriber) {
        showToast('لم يتم العثور على المشترك', true);
        return;
    }

    // Fill edit form
    document.getElementById('edit-subscriber-id').value = id;
    document.getElementById('edit-subscriber-name').value = subscriber.name;
    document.getElementById('edit-subscriber-meter').value = subscriber.meterNumber || '';
    document.getElementById('edit-subscriber-phone').value = subscriber.phone || '';
    document.getElementById('edit-subscriber-address').value = subscriber.address || '';
    document.getElementById('edit-subscriber-date').value = subscriber.subscriptionDate || '';
    document.getElementById('edit-subscriber-opening-balance').value = subscriber.openingBalance || 0;
    document.getElementById('edit-subscriber-opening-reading').value = subscriber.openingReading || 0;

    // Get current balance from last invoice
    const archive = DataStore.get('archive') || [];
    const lastInvoice = archive.filter(a => a.subscriberId === id).pop();
    const currentBalance = lastInvoice ? lastInvoice.remaining : (subscriber.openingBalance || 0);
    document.getElementById('edit-subscriber-current-balance').value = currentBalance;

    openModal('edit-subscriber-modal');
}

function updateSubscriber() {
    const id = document.getElementById('edit-subscriber-id').value;
    const name = document.getElementById('edit-subscriber-name').value.trim();
    const meterNumber = document.getElementById('edit-subscriber-meter').value.trim();
    const phone = document.getElementById('edit-subscriber-phone').value.trim();
    const address = document.getElementById('edit-subscriber-address').value.trim();
    const subscriptionDate = document.getElementById('edit-subscriber-date').value;
    const openingBalance = parseFloat(document.getElementById('edit-subscriber-opening-balance').value) || 0;
    const openingReading = parseFloat(document.getElementById('edit-subscriber-opening-reading').value) || 0;

    if (!name) {
        showToast('يرجى إدخال اسم المشترك', true);
        return;
    }

    const subscribers = DataStore.get('subscribers') || [];
    const index = subscribers.findIndex(s => s.id === id);

    if (index === -1) {
        showToast('لم يتم العثور على المشترك', true);
        return;
    }

    // Check for duplicate name (excluding current subscriber)
    if (subscribers.some(s => s.id !== id && s.name.toLowerCase() === name.toLowerCase())) {
        showToast('هذا الاسم موجود مسبقاً', true);
        return;
    }

    subscribers[index] = {
        ...subscribers[index],
        name: name,
        meterNumber: meterNumber,
        phone: phone,
        address: address,
        subscriptionDate: subscriptionDate,
        openingBalance: openingBalance,
        openingReading: openingReading,
        updatedAt: new Date().toISOString()
    };

    DataStore.set('subscribers', subscribers);

    closeModal('edit-subscriber-modal');
    refreshSubscribersTable();
    refreshDashboard();
    showToast('تم تحديث بيانات المشترك');
}

function viewSubscriberDetails(id) {
    const subscribers = DataStore.get('subscribers') || [];
    const archive = DataStore.get('archive') || [];
    const subscriber = subscribers.find(s => s.id === id);

    if (!subscriber) return;

    const lastInvoice = archive.filter(a => a.subscriberId === id).pop();
    const currentBalance = lastInvoice ? lastInvoice.remaining : (subscriber.openingBalance || 0);
    const invoiceCount = archive.filter(a => a.subscriberId === id).length;

    const content = document.getElementById('invoice-content');
    content.innerHTML = `
        <div class="invoice-header">
            <h1><i class="fas fa-user" style="color: #3b82f6;"></i> بيانات المشترك</h1>
        </div>
        
        <table class="invoice-table">
            <tbody>
                <tr>
                    <td style="font-weight: 600; background: #f1f5f9;">الاسم</td>
                    <td>${subscriber.name}</td>
                </tr>
                <tr>
                    <td style="font-weight: 600; background: #f1f5f9;">رقم العداد</td>
                    <td>${subscriber.meterNumber || '-'}</td>
                </tr>
                <tr>
                    <td style="font-weight: 600; background: #f1f5f9;">رقم الهاتف</td>
                    <td>${subscriber.phone || '-'}</td>
                </tr>
                <tr>
                    <td style="font-weight: 600; background: #f1f5f9;">العنوان</td>
                    <td>${subscriber.address || '-'}</td>
                </tr>
                <tr>
                    <td style="font-weight: 600; background: #f1f5f9;">تاريخ الاشتراك</td>
                    <td>${subscriber.subscriptionDate ? formatDate(subscriber.subscriptionDate) : formatDate(subscriber.createdAt)}</td>
                </tr>
                <tr>
                    <td style="font-weight: 600; background: #f1f5f9;">القراءة الافتتاحية</td>
                    <td>${formatNumber(subscriber.openingReading || 0)}</td>
                </tr>
                <tr>
                    <td style="font-weight: 600; background: #f1f5f9;">الرصيد الافتتاحي</td>
                    <td>${formatNumber(subscriber.openingBalance || 0)}</td>
                </tr>
                <tr>
                    <td style="font-weight: 600; background: #f1f5f9;">الرصيد الحالي</td>
                    <td style="color: ${currentBalance > 0 ? '#dc2626' : '#22c55e'}; font-weight: 700;">
                        ${formatNumber(currentBalance)}
                    </td>
                </tr>
                <tr>
                    <td style="font-weight: 600; background: #f1f5f9;">عدد الفواتير</td>
                    <td>${invoiceCount}</td>
                </tr>
            </tbody>
        </table>
        
        <div style="text-align: center; margin-top: 20px;">
            <button class="btn btn-primary" onclick="closeModal('invoice-modal'); viewSubscriberHistory('${id}')">
                <i class="fas fa-history"></i> عرض سجل الفواتير
            </button>
        </div>
    `;

    openModal('invoice-modal');
}

function deleteSubscriber(id) {
    if (!confirm('هل أنت متأكد من حذف هذا المشترك؟')) return;

    let subscribers = DataStore.get('subscribers') || [];
    subscribers = subscribers.filter(s => s.id !== id);
    DataStore.set('subscribers', subscribers);

    refreshSubscribersTable();
    refreshDashboard();
    showToast('تم حذف المشترك');
}

function viewSubscriberHistory(id) {
    const subscribers = DataStore.get('subscribers') || [];
    const subscriber = subscribers.find(s => s.id === id);

    if (subscriber) {
        showPage('archive');
        setTimeout(() => {
            document.getElementById('search-archive').value = subscriber.name;
            filterArchive();
        }, 100);
    }
}

function filterSubscribers() {
    const search = document.getElementById('search-subscribers').value.toLowerCase();
    const rows = document.querySelectorAll('#subscribers-tbody tr');

    rows.forEach(row => {
        const name = row.cells[1]?.textContent.toLowerCase() || '';
        const meter = row.cells[2]?.textContent.toLowerCase() || '';
        const phone = row.cells[3]?.textContent.toLowerCase() || '';
        row.style.display = (name.includes(search) || meter.includes(search) || phone.includes(search)) ? '' : 'none';
    });
}

function getDebtors() {
    const subscribers = DataStore.get('subscribers') || [];
    const archive = DataStore.get('archive') || [];

    return subscribers.map(sub => {
        const lastInvoice = archive.filter(a => a.subscriberId === sub.id).pop();
        const debt = lastInvoice ? lastInvoice.remaining : (sub.openingBalance || 0);
        return { name: sub.name, debt };
    }).filter(d => d.debt > 0).sort((a, b) => b.debt - a.debt);
}
