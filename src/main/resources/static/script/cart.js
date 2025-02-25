// Example cart items
const cart = [
    { id: 1, name: "Pizza Margherita", price: 12.99, quantity: 2, img: "/images/burger.jpg" },
    { id: 2, name: "Pasta Alfredo", price: 8.99, quantity: 1, img: "/images/burger.jpg" },
    { id: 3, name: "Caesar Salad", price: 6.49, quantity: 3, img: "/images/burger.jpg" }
];

// Coupon code
const validCouponCode = "DISCOUNT10";
let discount = 0;

function updateCart() {
    const cartItemsContainer = document.getElementById("cart-items");
    const cartCount = document.getElementById("cart-count");
    const totalPriceElement = document.getElementById("total-price");

    // Clear the cart items container
    cartItemsContainer.innerHTML = "";

    let totalPrice = 0;

    cart.forEach(item => {
        const itemTotal = item.price * item.quantity;
        totalPrice += itemTotal;

        const itemElement = document.createElement("div");
        itemElement.classList.add("cart-item");
        itemElement.innerHTML = `
        <img src="${item.img}" alt="${item.name}">
        <div class="cart-item-details">
            <div class="cart-item-name">${item.name}</div>
            <div class="cart-item-price">$${item.price.toFixed(2)} x ${item.quantity}</div>
        </div>
        <div class="cart-item-actions">
            <span class="quantity">Qty: ${item.quantity}</span>
            <button class="btn-remove" onclick="removeItem(${item.id})">Remove</button>
        </div>
    `;
        cartItemsContainer.appendChild(itemElement);
    });

    cartCount.textContent = `${cart.length} items`;
    totalPriceElement.textContent = (totalPrice - discount).toFixed(2);
}

function removeItem(itemId) {
    const index = cart.findIndex(item => item.id === itemId);
    if (index !== -1) {
        cart.splice(index, 1);
        updateCart();
    }
}

function applyCoupon() {
    const couponCode = document.getElementById("coupon-code").value.trim();
    const couponMessage = document.getElementById("coupon-message");

    if (couponCode === validCouponCode) {
        discount = 2.00; // Example: $2 discount
        couponMessage.textContent = "Coupon applied! You saved $2.";
    } else {
        discount = 0;
        couponMessage.textContent = "Invalid coupon code.";
    }

    updateCart();
}

function checkout() {
    const deliveryLocation = document.getElementById("delivery-location").value;
    const paymentOption = document.getElementById("payment-option").value;

    if (!deliveryLocation) {
        alert("Please enter your delivery address.");
        return;
    }

    alert(`Proceeding to checkout with payment option: ${paymentOption} and delivery to: ${deliveryLocation}`);
}

// Initial update of the cart
updateCart();