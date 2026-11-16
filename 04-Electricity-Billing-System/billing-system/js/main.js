/* ===================================
   التهيئة - Main Application Entry
   =================================== */

document.addEventListener('DOMContentLoaded', function () {
    console.log('=== Billing System Initializing ===');

    // Initialize default users first
    initializeDefaultUsers();

    // Check authentication
    const session = localStorage.getItem('billing_session');
    if (!session) {
        console.log('No session, redirecting to login...');
        window.location.href = 'index.html';
        return;
    }

    let user;
    try {
        user = JSON.parse(session);
        console.log('Logged in as:', user.name);
    } catch (e) {
        console.error('Invalid session');
        localStorage.removeItem('billing_session');
        window.location.href = 'index.html';
        return;
    }

    // Display user info
    displayUserInfo();

    // Set current date
    const dateDisplay = document.getElementById('current-date');
    if (dateDisplay) {
        dateDisplay.textContent = new Date().toLocaleDateString('ar-EG', {
            weekday: 'long',
            year: 'numeric',
            month: 'long',
            day: 'numeric'
        });
    }

    // Initialize modal events
    console.log('Initializing modals...');
    initModalEvents();

    // Initialize navigation
    console.log('Initializing navigation...');
    initNavigation();

    // Initialize sample data if empty
    initSampleData();

    // Load dashboard
    console.log('Loading dashboard...');
    refreshDashboard();

    console.log('=== Billing System Ready! ===');
});

// Initialize sample subscribers if none exist
function initSampleData() {
    const subscribers = DataStore.get('subscribers');
    if (!subscribers || subscribers.length === 0) {
        console.log('Adding sample subscribers...');
        DataStore.set('subscribers', [
            {
                id: generateId(),
                name: 'أحمد محمد علي',
                meterNumber: 'M-001',
                phone: '773123456',
                address: 'شارع الملك، حي النور',
                subscriptionDate: '2024-01-15',
                openingBalance: 0,
                openingReading: 1000,
                createdAt: new Date().toISOString()
            },
            {
                id: generateId(),
                name: 'محمد سعيد حسن',
                meterNumber: 'M-002',
                phone: '773234567',
                address: 'شارع الجمهورية',
                subscriptionDate: '2024-02-20',
                openingBalance: 50,
                openingReading: 2000,
                createdAt: new Date().toISOString()
            },
            {
                id: generateId(),
                name: 'خالد إبراهيم عبدالله',
                meterNumber: 'M-003',
                phone: '773345678',
                address: 'حي السلام، بجانب المسجد',
                subscriptionDate: '2024-03-10',
                openingBalance: 100,
                openingReading: 1500,
                createdAt: new Date().toISOString()
            },
            {
                id: generateId(),
                name: 'سعيد عمر حسن',
                meterNumber: 'M-004',
                phone: '773456789',
                address: 'شارع فلسطين',
                subscriptionDate: '2024-04-05',
                openingBalance: 0,
                openingReading: 3000,
                createdAt: new Date().toISOString()
            },
            {
                id: generateId(),
                name: 'عبدالله عمر أحمد',
                meterNumber: 'M-005',
                phone: '773567890',
                address: 'حي الزهراء',
                subscriptionDate: '2024-05-01',
                openingBalance: 75,
                openingReading: 2500,
                createdAt: new Date().toISOString()
            }
        ]);
    }
}
