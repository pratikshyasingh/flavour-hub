console.log("Js Loaded Successfully");
let products = [];
let editIndex = -1;

function openModal(index = -1) {
    // editIndex = index;
    // if (index >= 0) {
    //     document.getElementById('productName').value = products[index].name;
    //     document.getElementById('productCategory').value = products[index].category;
    //     document.getElementById('productPrice').value = products[index].price;
    //     document.getElementById('productStock').value = products[index].stock;
    // } else {
    //     document.getElementById('productName').value = '';
    //     document.getElementById('productCategory').value = '';
    //     document.getElementById('productPrice').value = '';
    //     document.getElementById('productStock').value = '';
    // }
    // document.getElementById('productModal').style.display = 'block';
    console.log("Open modal clicked"); // Debugging
    editIndex = index;
    let modal = document.getElementById('productModal');

    if (index >= 0) {
        document.getElementById('productName').value = products[index].name;
        document.getElementById('productCategory').value = products[index].category;
        document.getElementById('productPrice').value = products[index].price;
        document.getElementById('productStock').value = products[index].stock;
    } else {
        document.getElementById('productName').value = '';
        document.getElementById('productCategory').value = '';
        document.getElementById('productPrice').value = '';
        document.getElementById('productStock').value = '';
    }

    modal.style.display = 'block';
}

function closeModal() {
    // document.getElementById('productModal').style.display = 'none';
    console.log("Close modal clicked"); // Debugging
    document.getElementById('productModal').style.display = 'none';
}

function saveProduct() {
    let name = document.getElementById('productName').value;
    let category = document.getElementById('productCategory').value;
    let price = document.getElementById('productPrice').value;
    let stock = document.getElementById('productStock').value;

    if (editIndex >= 0) {
        products[editIndex] = { id: editIndex + 1, name, category, price, stock };
    } else {
        products.push({ id: products.length + 1, name, category, price, stock });
    }
    closeModal();
    renderTable();
}

function deleteProduct(index) {
    products.splice(index, 1);
    renderTable();
}

function renderTable() {
    let table = document.getElementById('productTable');
    table.innerHTML = '';
    products.forEach((product, index) => {
        table.innerHTML += `
            <tr>
                <td>${product.id}</td>
                <td>${product.name}</td>
                <td>${product.category}</td>
                <td>${product.price}</td>
                <td>${product.stock}</td>
                <td>
                    <button class="btn btn-edit" onclick="openModal(${index})">Edit</button>
                    <button class="btn btn-delete" onclick="deleteProduct(${index})">Delete</button>
                </td>
            </tr>`;
    });
}

function searchProduct() {
    let searchText = document.getElementById('search').value.toLowerCase();
    let filteredProducts = products.filter(p => p.name.toLowerCase().includes(searchText));
    let table = document.getElementById('productTable');
    table.innerHTML = '';
    filteredProducts.forEach((product, index) => {
        table.innerHTML += `
            <tr>
                <td>${product.id}</td>
                <td>${product.name}</td>
                <td>${product.category}</td>
                <td>${product.price}</td>
                <td>${product.stock}</td>
                <td>
                    <button class="btn btn-edit" onclick="openModal(${index})">Edit</button>
                    <button class="btn btn-delete" onclick="deleteProduct(${index})">Delete</button>
                </td>
            </tr>`;
    });
}
