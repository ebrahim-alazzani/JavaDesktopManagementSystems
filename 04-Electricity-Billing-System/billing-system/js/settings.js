/* ===================================
   الإعدادات - Settings Module
   =================================== */

function loadSettings() {
    const settings = DataStore.get('settings') || {};

    const defaultPrice = document.getElementById('default-price');
    const orgName = document.getElementById('org-name');
    const orgAddress = document.getElementById('org-address');
    const orgPhone = document.getElementById('org-phone');

    if (defaultPrice) defaultPrice.value = settings.defaultPrice || 0.5;
    if (orgName) orgName.value = settings.orgName || '';
    if (orgAddress) orgAddress.value = settings.orgAddress || '';
    if (orgPhone) orgPhone.value = settings.orgPhone || '';
}

function saveSettings() {
    const settings = DataStore.get('settings') || {};
    settings.defaultPrice = parseFloat(document.getElementById('default-price').value) || 0.5;
    DataStore.set('settings', settings);
    showToast('تم حفظ الإعدادات');
}

function saveOrgSettings() {
    const settings = DataStore.get('settings') || {};
    settings.orgName = document.getElementById('org-name').value;
    settings.orgAddress = document.getElementById('org-address').value;
    settings.orgPhone = document.getElementById('org-phone').value;
    DataStore.set('settings', settings);
    showToast('تم حفظ معلومات الجهة');
}

function exportAllData() {
    const data = {
        subscribers: DataStore.get('subscribers'),
        archive: DataStore.get('archive'),
        settings: DataStore.get('settings'),
        exportDate: new Date().toISOString()
    };

    const blob = new Blob([JSON.stringify(data, null, 2)], { type: 'application/json' });
    const link = document.createElement('a');
    link.href = URL.createObjectURL(blob);
    link.download = `billing_backup_${new Date().toISOString().split('T')[0]}.json`;
    link.click();

    showToast('تم تصدير البيانات');
}

function importData(event) {
    const file = event.target.files[0];
    if (!file) return;

    const reader = new FileReader();
    reader.onload = function (e) {
        try {
            const data = JSON.parse(e.target.result);

            if (data.subscribers) DataStore.set('subscribers', data.subscribers);
            if (data.archive) DataStore.set('archive', data.archive);
            if (data.settings) DataStore.set('settings', data.settings);

            showToast('تم استيراد البيانات بنجاح');
            refreshDashboard();
        } catch (err) {
            showToast('خطأ في قراءة الملف', true);
        }
    };
    reader.readAsText(file);
}

function confirmClearData() {
    if (!confirm('هل أنت متأكد من مسح جميع البيانات؟ هذا الإجراء لا يمكن التراجع عنه!')) return;
    if (!confirm('تأكيد أخير: سيتم حذف جميع المشتركين والفواتير!')) return;

    localStorage.clear();
    DataStore.init();

    showToast('تم مسح جميع البيانات');
    refreshDashboard();
}
