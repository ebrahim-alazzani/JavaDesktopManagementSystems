/* ===================================
   لوحة التحكم - Dashboard Module
   =================================== */

function refreshDashboard() {
    const subscribers = DataStore.get('subscribers') || [];
    const archive = DataStore.get('archive') || [];

    // Update stats
    const totalSubscribers = document.getElementById('total-subscribers');
    const totalInvoices = document.getElementById('total-invoices');
    const totalRevenue = document.getElementById('total-revenue');
    const totalDebts = document.getElementById('total-debts');

    if (totalSubscribers) totalSubscribers.textContent = formatNumber(subscribers.length);
    if (totalInvoices) totalInvoices.textContent = formatNumber(archive.length);

    const revenue = archive.reduce((sum, inv) => sum + (inv.totalBill || 0), 0);
    if (totalRevenue) totalRevenue.textContent = formatNumber(revenue);

    const debts = archive.reduce((sum, inv) => sum + (inv.remaining || 0), 0);
    if (totalDebts) totalDebts.textContent = formatNumber(debts);

    // Recent invoices
    const recentInvoices = archive.slice(-5).reverse();
    const tbody = document.querySelector('#recent-invoices-table tbody');
    if (tbody) {
        tbody.innerHTML = recentInvoices.map(inv => `
            <tr>
                <td>${formatDate(inv.date)}</td>
                <td>${inv.subscriberName}</td>
                <td>${formatNumber(inv.totalBill)}</td>
                <td>
                    <span class="badge-status ${inv.remaining === 0 ? 'badge-paid' : inv.paid > 0 ? 'badge-partial' : 'badge-unpaid'}">
                        ${inv.remaining === 0 ? 'مدفوع' : inv.paid > 0 ? 'جزئي' : 'غير مدفوع'}
                    </span>
                </td>
            </tr>
        `).join('') || '<tr><td colspan="4" style="text-align: center; color: var(--text-muted);">لا توجد فواتير</td></tr>';
    }

    // Debt list
    const debtList = document.getElementById('debt-list');
    if (debtList) {
        const debtors = getDebtors();
        debtList.innerHTML = debtors.slice(0, 5).map(d => `
            <li>
                <span class="name">${d.name}</span>
                <span class="amount">${formatNumber(d.debt)}</span>
            </li>
        `).join('') || '<li style="text-align: center; color: var(--text-muted);">لا توجد مديونيات</li>';
    }
}
