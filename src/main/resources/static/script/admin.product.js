async function openModal(foodId = null) {
    let modal = document.getElementById('productModal');
    modal.style.display = 'block';
    if (foodId) {
        console.log(foodId);
        const response = await fetch(`/admin/products/${foodId}`).catch((err) =>
            console.error(err)
        );
        const foodItem = await response.json();
        console.log(foodItem);
        updateFields(foodItem);
    }
}

function updateFields(product) {
    document.getElementById('foodItemId').value = product.foodId;
    document.getElementById('foodItemImage').value = product.foodItemImageUrl;
    document.getElementById('categoryName').value = product.category.categoryId;
    document.getElementById('productName').value = product.foodName;
    document.getElementById('productDescription').value = product.foodDescription;
    document.getElementById('productPrice').value = product.price;
    document.getElementById('productStatus').value = product.foodItemStatus;
    // document.getElementById('foodId').value = product.foodId;


}

function closeModal() {
    document.getElementById('productModal').style.display = 'none';
}






