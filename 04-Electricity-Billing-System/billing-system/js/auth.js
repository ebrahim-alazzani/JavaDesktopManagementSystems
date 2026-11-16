/* ===================================
   المصادقة - Authentication Module
   =================================== */

// Check if user is logged in
function checkAuth() {
    const session = localStorage.getItem('billing_session');
    if (!session) {
        console.log('No session found, redirecting to login...');
        window.location.href = 'index.html';
        return null;
    }

    try {
        const user = JSON.parse(session);
        console.log('User authenticated:', user.name);
        return user;
    } catch (e) {
        console.error('Invalid session, clearing...');
        localStorage.removeItem('billing_session');
        window.location.href = 'index.html';
        return null;
    }
}

// Display user info
function displayUserInfo() {
    try {
        const session = localStorage.getItem('billing_session');
        if (session) {
            const user = JSON.parse(session);
            const nameEl = document.getElementById('user-display-name');
            const roleEl = document.getElementById('user-display-role');

            if (nameEl) nameEl.textContent = user.name || 'المستخدم';
            if (roleEl) roleEl.textContent = user.role || 'مستخدم';
        }
    } catch (e) {
        console.error('Error displaying user info:', e);
    }
}

// Logout function
function logout() {
    if (confirm('هل أنت متأكد من تسجيل الخروج؟')) {
        localStorage.removeItem('billing_session');
        window.location.href = 'index.html';
    }
}

// Change password
function changePassword() {
    const currentPassword = document.getElementById('current-password').value;
    const newPassword = document.getElementById('new-password').value;
    const confirmPassword = document.getElementById('confirm-password').value;

    if (!currentPassword || !newPassword || !confirmPassword) {
        showToast('يرجى ملء جميع الحقول', true);
        return;
    }

    if (newPassword !== confirmPassword) {
        showToast('كلمة المرور الجديدة غير متطابقة', true);
        return;
    }

    if (newPassword.length < 4) {
        showToast('كلمة المرور يجب أن تكون 4 أحرف على الأقل', true);
        return;
    }

    const session = getCurrentUser();
    if (!session) return;

    const users = JSON.parse(localStorage.getItem('billing_users') || '[]');
    const userIndex = users.findIndex(u => u.username === session.username);

    if (userIndex === -1) {
        showToast('لم يتم العثور على المستخدم', true);
        return;
    }

    if (users[userIndex].password !== currentPassword) {
        showToast('كلمة المرور الحالية غير صحيحة', true);
        return;
    }

    users[userIndex].password = newPassword;
    localStorage.setItem('billing_users', JSON.stringify(users));

    // Clear form
    document.getElementById('current-password').value = '';
    document.getElementById('new-password').value = '';
    document.getElementById('confirm-password').value = '';

    showToast('تم تغيير كلمة المرور بنجاح');
}

// Get current user
function getCurrentUser() {
    const session = localStorage.getItem('billing_session');
    if (session) {
        try {
            return JSON.parse(session);
        } catch (e) {
            return null;
        }
    }
    return null;
}

// Initialize users if missing (for first time use)
function initializeDefaultUsers() {
    const existingUsers = localStorage.getItem('billing_users');
    if (!existingUsers || existingUsers === '[]') {
        const defaultUsers = [
            { username: 'admin', password: 'admin123', name: 'المدير', role: 'مسؤول النظام' },
            { username: 'user', password: 'user123', name: 'المستخدم', role: 'مستخدم' }
        ];
        localStorage.setItem('billing_users', JSON.stringify(defaultUsers));
        console.log('Default users initialized');
    }
}
