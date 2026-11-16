/* ===================================
   تسجيل الدخول - Login Module
   =================================== */

// Default credentials
const DEFAULT_USERS = [
    { username: 'admin', password: 'admin123', name: 'المدير', role: 'مسؤول النظام' },
    { username: 'user', password: 'user123', name: 'المستخدم', role: 'مستخدم عادي' }
];

// Initialize users if not exist
function initUsers() {
    const existingUsers = localStorage.getItem('billing_users');
    if (!existingUsers || existingUsers === '[]') {
        localStorage.setItem('billing_users', JSON.stringify(DEFAULT_USERS));
        console.log('Users initialized:', DEFAULT_USERS);
    } else {
        console.log('Existing users found:', JSON.parse(existingUsers));
    }
}

// Check if already logged in
function checkSession() {
    const session = localStorage.getItem('billing_session');
    if (session) {
        try {
            const user = JSON.parse(session);
            if (user && user.username) {
                window.location.href = 'app.html';
            }
        } catch (e) {
            localStorage.removeItem('billing_session');
        }
    }
}

// Handle login
function handleLogin(event) {
    event.preventDefault();

    const username = document.getElementById('username').value.trim();
    const password = document.getElementById('password').value;
    const rememberMe = document.getElementById('remember-me').checked;
    const loginBtn = document.getElementById('login-btn');
    const errorDiv = document.getElementById('error-message');

    // Show loading
    loginBtn.classList.add('loading');
    loginBtn.innerHTML = '<i class="fas fa-spinner fa-spin"></i> جاري تسجيل الدخول...';

    // Simulate API call
    setTimeout(() => {
        const users = JSON.parse(localStorage.getItem('billing_users') || '[]');
        const user = users.find(u => u.username === username && u.password === password);

        if (user) {
            // Success - save session
            const session = {
                username: user.username,
                name: user.name,
                role: user.role,
                loginTime: new Date().toISOString()
            };

            localStorage.setItem('billing_session', JSON.stringify(session));

            if (rememberMe) {
                localStorage.setItem('billing_remember', username);
            } else {
                localStorage.removeItem('billing_remember');
            }

            // Redirect to app
            window.location.href = 'app.html';
        } else {
            // Error
            errorDiv.classList.add('show');
            loginBtn.classList.remove('loading');
            loginBtn.innerHTML = '<i class="fas fa-sign-in-alt"></i> تسجيل الدخول';
        }
    }, 1000);
}

// Initialize on page load
document.addEventListener('DOMContentLoaded', function () {
    initUsers();
    checkSession();

    // Auto-fill remembered username
    const remembered = localStorage.getItem('billing_remember');
    if (remembered) {
        document.getElementById('username').value = remembered;
        document.getElementById('remember-me').checked = true;
    }

    // Hide error on input
    document.querySelectorAll('#login-form input').forEach(input => {
        input.addEventListener('input', () => {
            document.getElementById('error-message').classList.remove('show');
        });
    });
});
