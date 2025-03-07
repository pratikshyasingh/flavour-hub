document.addEventListener('DOMContentLoaded', () => {
    const orderHistory = [
        {
            orderId: '12345',
            date: '2025-02-25',
            total: '$45.99',
            status: 'Delivered',
            items: [
                { name: 'Paneer Tikka', quantity: 2, price: '$12.99' },
                { name: 'Naan', quantity: 3, price: '$2.50' }
            ]
        },
        {
            orderId: '12346',
            date: '2025-02-20',
            total: '$39.50',
            status: 'Delivered',
            items: [
                { name: 'Butter Chicken', quantity: 1, price: '$18.00' },
                { name: 'Basmati Rice', quantity: 1, price: '$3.50' }
            ]
        }
    ];

    const orderList = document.getElementById('order-history');

    orderHistory.forEach(order => {
        const orderItem = document.createElement('li');
        orderItem.classList.add('order-item');

        const orderDetails = `
            <h3>Order #${order.orderId} - ${order.date}</h3>
            <div class="order-details">
                <p><strong>Total:</strong> ${order.total}</p>
                <p><strong>Status:</strong> ${order.status}</p>
            </div>
            <button onclick="viewOrderDetails('${order.orderId}')">View Details</button>
        `;

        orderItem.innerHTML = orderDetails;
        orderList.appendChild(orderItem);
    });
});

function viewOrderDetails(orderId) {
    alert(`Viewing details for Order #${orderId}`);
}
