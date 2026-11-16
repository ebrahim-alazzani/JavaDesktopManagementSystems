/* ===================================
   الدوال المساعدة - Utility Functions
   =================================== */

function formatDate(date) {
    const d = new Date(date);
    return d.toLocaleDateString('ar-EG', {
        year: 'numeric',
        month: 'short',
        day: 'numeric'
    });
}

function formatNumber(num) {
    return new Intl.NumberFormat('ar-EG').format(num);
}

function generateId() {
    return Date.now().toString(36) + Math.random().toString(36).substr(2);
}

function showToast(message, isError = false) {
    const toast = document.getElementById('toast');
    const toastMessage = document.getElementById('toast-message');

    toastMessage.textContent = message;
    toast.classList.toggle('error', isError);
    toast.classList.add('show');

    setTimeout(() => {
        toast.classList.remove('show');
    }, 3000);
}
