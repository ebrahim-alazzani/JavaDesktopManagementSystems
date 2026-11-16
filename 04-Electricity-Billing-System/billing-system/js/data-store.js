/* ===================================
   مخزن البيانات - Data Store Module
   =================================== */

const DataStore = {
    // Get data from localStorage
    get(key) {
        const data = localStorage.getItem(key);
        return data ? JSON.parse(data) : null;
    },

    // Set data to localStorage
    set(key, value) {
        localStorage.setItem(key, JSON.stringify(value));
    },

    // Initialize default data
    init() {
        if (!this.get('subscribers')) {
            this.set('subscribers', []);
        }
        if (!this.get('archive')) {
            this.set('archive', []);
        }
        if (!this.get('settings')) {
            this.set('settings', {
                defaultPrice: 0.5,
                orgName: 'شركة الكهرباء',
                orgAddress: '',
                orgPhone: ''
            });
        }
    }
};

// Initialize on load
DataStore.init();
