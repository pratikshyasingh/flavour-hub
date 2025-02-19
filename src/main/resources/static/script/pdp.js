let quantity = 1;

function changeQuantity(amount) {
    quantity += amount;
    if (quantity < 1) quantity = 1;
    document.getElementById('quantity').innerText = quantity;
}

function addToCart() {
    alert(`Added ${quantity} item(s) to cart.`);
}