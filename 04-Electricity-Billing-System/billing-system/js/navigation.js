/* ===================================
   التنقل - Navigation Module
   =================================== */

function showPage(pageId) {
    // Update nav items
    document.querySelectorAll('.nav-item').forEach(item => {
        item.classList.remove('active');
    });

    // Find and activate the clicked nav item
    const navItems = document.querySelectorAll('.nav-item');
    navItems.forEach(item => {
        if (item.getAttribute('onclick')?.includes(pageId)) {
            item.classList.add('active');
        }
    });

    // Update pages
    document.querySelectorAll('.page').forEach(page => {
        page.classList.remove('active');
    });

    const targetPage = document.getElementById(`page-${pageId}`);
    if (targetPage) {
        targetPage.classList.add('active');
    }

    // Close mobile menu
    closeMobileMenu();

    // Refresh page data
    switch (pageId) {
        case 'dashboard':
            refreshDashboard();
            break;
        case 'subscribers':
            refreshSubscribersTable();
            break;
        case 'billing':
            refreshBillingForm();
            break;
        case 'archive':
            refreshArchiveTable();
            break;
        case 'reports':
            refreshReports();
            break;
        case 'settings':
            loadSettings();
            break;
    }
}

function toggleSidebar() {
    const sidebar = document.getElementById('sidebar');
    const overlay = document.getElementById('sidebar-overlay');

    sidebar.classList.toggle('active');
    overlay.classList.toggle('active');

    // Toggle hamburger icon
    const menuBtn = document.getElementById('mobile-menu-btn');
    if (menuBtn) {
        menuBtn.classList.toggle('active');
    }
}

function closeMobileMenu() {
    const sidebar = document.getElementById('sidebar');
    const overlay = document.getElementById('sidebar-overlay');
    const menuBtn = document.getElementById('mobile-menu-btn');

    if (window.innerWidth <= 992) {
        sidebar.classList.remove('active');
        if (overlay) overlay.classList.remove('active');
        if (menuBtn) menuBtn.classList.remove('active');
    }
}

// Initialize navigation
function initNavigation() {
    // Create overlay if not exists
    if (!document.getElementById('sidebar-overlay')) {
        const overlay = document.createElement('div');
        overlay.id = 'sidebar-overlay';
        overlay.className = 'sidebar-overlay';
        overlay.onclick = toggleSidebar;
        document.body.appendChild(overlay);
    }

    // Handle window resize
    window.addEventListener('resize', function () {
        if (window.innerWidth > 992) {
            const sidebar = document.getElementById('sidebar');
            const overlay = document.getElementById('sidebar-overlay');
            sidebar.classList.remove('active');
            if (overlay) overlay.classList.remove('active');
        }
    });
}
