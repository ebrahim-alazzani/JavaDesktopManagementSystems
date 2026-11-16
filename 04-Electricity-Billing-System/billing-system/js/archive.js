/* ===================================
   الأرشيف - Archive Module
   =================================== */

function refreshArchiveTable() {
    const archive = DataStore.get('archive') || [];
    const tbody = document.getElementById('archive-tbody');

    if (!tbody) return;

    tbody.innerHTML = archive.slice().reverse().map(inv => `
        <tr>
            <td>${formatDate(inv.date)}</td>
            <td>${inv.subscriberName}</td>
            <td>${formatNumber(inv.prevReading)}</td>
            <td>${formatNumber(inv.currReading)}</td>
            <td>${formatNumber(inv.consumption)}</td>
            <td>${formatNumber(inv.totalBill)}</td>
            <td>${formatNumber(inv.paid)}</td>
            <td class="${inv.remaining > 0 ? 'text-danger' : ''}">${formatNumber(inv.remaining)}</td>
            <td>
                <button class="btn btn-icon btn-sm" onclick='showInvoiceById("${inv.id}")' title="عرض">
                    <i class="fas fa-eye"></i>
                </button>
                <button class="btn btn-icon btn-sm" onclick="deleteInvoice('${inv.id}')" title="حذف">
                    <i class="fas fa-trash"></i>
                </button>
            </td>
        </tr>
    `).join('') || '<tr><td colspan="9" style="text-align: center; color: var(--text-muted);">لا توجد فواتير في الأرشيف</td></tr>';
}

function showInvoiceById(id) {
    const archive = DataStore.get('archive') || [];
    const invoice = archive.find(a => a.id === id);
    if (invoice) {
        showInvoice(invoice);
    }
}

function filterArchive() {
    const search = document.getElementById('search-archive').value.toLowerCase();
    const rows = document.querySelectorAll('#archive-tbody tr');

    rows.forEach(row => {
        const name = row.cells[1]?.textContent.toLowerCase() || '';
        let show = name.includes(search);
        row.style.display = show ? '' : 'none';
    });
}

function deleteInvoice(id) {
    if (!confirm('هل أنت متأكد من حذف هذه الفاتورة؟')) return;

    let archive = DataStore.get('archive') || [];
    archive = archive.filter(a => a.id !== id);
    DataStore.set('archive', archive);

    refreshArchiveTable();
    refreshDashboard();
    showToast('تم حذف الفاتورة');
}

// Export to Real Excel (.xlsx) - matching BillingSystem.xlsx format
function exportToExcel() {
    const subscribers = DataStore.get('subscribers') || [];
    const archive = DataStore.get('archive') || [];

    if (subscribers.length === 0 && archive.length === 0) {
        showToast('لا توجد بيانات للتصدير', true);
        return;
    }

    // Check if SheetJS is loaded
    if (typeof XLSX === 'undefined') {
        showToast('مكتبة التصدير غير متوفرة، جاري استخدام CSV...', true);
        exportToCSV();
        return;
    }

    // Create workbook
    const wb = XLSX.utils.book_new();

    // Sheet 1: Subscribers (المشتركين)
    const subscribersData = [
        ['رقم المشترك', 'الاسم', 'الرصيد الافتتاحي']
    ];
    subscribers.forEach((sub, index) => {
        subscribersData.push([
            index + 1,
            sub.name,
            sub.openingBalance || ''
        ]);
    });
    const ws1 = XLSX.utils.aoa_to_sheet(subscribersData);
    XLSX.utils.book_append_sheet(wb, ws1, 'Subscribers');

    // Sheet 2: Archive (الأرشيف)
    const archiveData = [
        ['التاريخ', 'الاسم', 'قراءة سابقة', 'قراءة حالية', 'استهلاك', 'المبلغ', 'المدفوع', 'المتبقي']
    ];
    archive.forEach(inv => {
        archiveData.push([
            new Date(inv.date).toLocaleDateString('ar-EG'),
            inv.subscriberName,
            inv.prevReading,
            inv.currReading,
            inv.consumption,
            inv.totalBill,
            inv.paid,
            inv.remaining
        ]);
    });
    const ws2 = XLSX.utils.aoa_to_sheet(archiveData);
    XLSX.utils.book_append_sheet(wb, ws2, 'Archive');

    // Download
    XLSX.writeFile(wb, `نظام_الفواتير_${new Date().toISOString().split('T')[0]}.xlsx`);

    showToast('تم تصدير البيانات إلى Excel');
}

// Fallback CSV export
function exportToCSV() {
    const archive = DataStore.get('archive') || [];

    let csv = '\ufeff';
    csv += 'التاريخ,الاسم,قراءة سابقة,قراءة حالية,استهلاك,المبلغ,المدفوع,المتبقي\n';

    archive.forEach(inv => {
        const date = new Date(inv.date).toLocaleDateString('ar-EG');
        csv += `"${date}","${inv.subscriberName}",${inv.prevReading},${inv.currReading},${inv.consumption},${inv.totalBill},${inv.paid},${inv.remaining}\n`;
    });

    const blob = new Blob([csv], { type: 'text/csv;charset=utf-8' });
    const link = document.createElement('a');
    link.href = URL.createObjectURL(blob);
    link.download = `أرشيف_الفواتير_${new Date().toISOString().split('T')[0]}.csv`;
    link.click();
}

// Export Subscribers to Excel
function exportSubscribersToExcel() {
    const subscribers = DataStore.get('subscribers') || [];

    if (subscribers.length === 0) {
        showToast('لا توجد بيانات للتصدير', true);
        return;
    }

    if (typeof XLSX === 'undefined') {
        showToast('مكتبة التصدير غير متوفرة', true);
        return;
    }

    const wb = XLSX.utils.book_new();

    const data = [
        ['رقم المشترك', 'الاسم', 'الرصيد الافتتاحي']
    ];
    subscribers.forEach((sub, index) => {
        data.push([
            index + 1,
            sub.name,
            sub.openingBalance || ''
        ]);
    });

    const ws = XLSX.utils.aoa_to_sheet(data);
    XLSX.utils.book_append_sheet(wb, ws, 'Subscribers');

    XLSX.writeFile(wb, `قائمة_المشتركين_${new Date().toISOString().split('T')[0]}.xlsx`);

    showToast('تم تصدير المشتركين إلى Excel');
}

function printArchive() {
    window.print();
}
