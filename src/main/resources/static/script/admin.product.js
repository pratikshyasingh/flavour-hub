// console.log("Js Loaded Successfully");
// let products = [];
// let editIndex = -1;

// function openModal(index = -1) {
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
//     console.log("Open modal clicked"); // Debugging
//     editIndex = index;
//     let modal = document.getElementById('productModal');

//     if (index >= 0) {
//         document.getElementById('productName').value = products[index].name;
//         document.getElementById('productCategory').value = products[index].category;
//         document.getElementById('productPrice').value = products[index].price;
//         document.getElementById('productStock').value = products[index].stock;
//     } else {
//         document.getElementById('productName').value = '';
//         document.getElementById('productCategory').value = '';
//         document.getElementById('productPrice').value = '';
//         document.getElementById('productStock').value = '';
//     }

//     modal.style.display = 'block';
// }

// function closeModal() {
// document.getElementById('productModal').style.display = 'none';
//    console.log("JS Loaded Successfully");

// let products = [];
// let editIndex = -1;

// function openModal(index = -1) {
//     console.log("Open modal clicked");
//     editIndex = index;
//     let modal = document.getElementById('productModal');

//     if (index >= 0) {
//         document.getElementById('foodId').value = products[index].id;  // Added Food ID field
//         document.getElementById('categoryId').value = products[index].categoryId; // Added Category ID field
//         document.getElementById('productName').value = products[index].name;
//         document.getElementById('productDescription').value = products[index].description; // Added Food Description
//         document.getElementById('productPrice').value = products[index].price;
//         document.getElementById('productStatus').value = products[index].status; // Added Status Field
//     } else {
//         document.getElementById('productForm').reset(); // Reset form when adding a new product
//     }

//     modal.style.display = 'block';
// }

// function closeModal() {
//     console.log("Close modal clicked");
//     document.getElementById('productModal').style.display = 'none';
// }

// Event listener for form submission
// document.getElementById('productForm').addEventListener('submit', function (event) {
//     event.preventDefault();

//     let newProduct = {
//         id: document.getElementById('foodId').value,  // Changed field
//         categoryId: document.getElementById('categoryId').value, // Changed field
//         name: document.getElementById('productName').value,
//         description: document.getElementById('productDescription').value, // Changed field
//         price: document.getElementById('productPrice').value,
//         status: document.getElementById('productStatus').value, // Changed field
//     };

//     if (editIndex >= 0) {
//         products[editIndex] = newProduct;
//     } else {
//         products.push(newProduct);
//     }

//     closeModal();
//     renderTable();
// });

// function deleteProduct(index) {
//     console.log("Delete product at index:", index);
//     products.splice(index, 1);
//     renderTable();
// }

// function renderTable() {
//     let table = document.getElementById('productTable');
//     table.innerHTML = '';
//     products.forEach((product, index) => {
//         table.innerHTML += `
//             <tr>
//                 <td>${product.id}</td> <!-- Removed createdBy, updatedBy, createdDate, updatedDate -->
//                 <td>${product.categoryId}</td> <!-- Modified field -->
//                 <td>${product.name}</td>
//                 <td>${product.description}</td> <!-- Modified field -->
//                 <td>${product.price}</td>
//                 <td>${product.status}</td> <!-- Modified field -->
//                 <td>
//                     <button class="btn btn-edit" onclick="openModal(${index})">Edit</button>
//                     <button class="btn btn-delete" onclick="deleteProduct(${index})">Delete</button>
//                 </td>
//             </tr>`;
//     });
// }
console.log("JS Loaded Successfully");

let products = [];
let editIndex = -1;

function openModal(index = -1) {
    console.log("Open modal clicked");
    editIndex = index;
    let modal = document.getElementById('productModal');

    if (index >= 0) {
        document.getElementById('foodId').value = products[index].id;
        document.getElementById('categoryId').value = products[index].categoryId;
        document.getElementById('productName').value = products[index].name;
        document.getElementById('productDescription').value = products[index].description;
        document.getElementById('productPrice').value = products[index].price;

        // 🔽 Modified: Set dropdown value - Line 16
        document.getElementById('productStatus').value = products[index].status;
    } else {
        document.getElementById('productForm').reset();
    }

    modal.style.display = 'block';
}

function closeModal() {
    console.log("Close modal clicked");
    document.getElementById('productModal').style.display = 'none';
}

// 🔽 Modified: Status dropdown included in the object - Line 31
document.getElementById('productForm').addEventListener('submit', function (event) {
    event.preventDefault();

    let newProduct = {
        id: document.getElementById('foodId').value,
        categoryId: document.getElementById('categoryId').value,
        name: document.getElementById('productName').value,
        description: document.getElementById('productDescription').value,
        price: document.getElementById('productPrice').value,
        status: document.getElementById('productStatus').value,  // 🔽 Modified: Dropdown value stored
    };

    if (editIndex >= 0) {
        products[editIndex] = newProduct;
    } else {
        products.push(newProduct);
    }

    closeModal();
    renderTable();
});

function deleteProduct(index) {
    console.log("Delete product at index:", index);
    products.splice(index, 1);
    renderTable();
}

// 🔽 Modified: Status added in table rendering - Line 58
function renderTable() {
    let table = document.getElementById('productTable');
    table.innerHTML = '';
    products.forEach((product, index) => {
        table.innerHTML += `
            <tr>
                <td>${product.id}</td>
                <td>${product.categoryId}</td>
                <td>${product.name}</td>
                <td>${product.description}</td>
                <td>${product.price}</td>
                <td>${product.status}</td> <!-- 🔽 Modified: Dropdown value displayed -->
                <td>
                    <button class="btn btn-edit" onclick="openModal(${index})">Edit</button>
                    <button class="btn btn-delete" onclick="deleteProduct(${index})">Delete</button>
                </td>
            </tr>`;
    });
}

