document.addEventListener("DOMContentLoaded", function () {
    const modal = document.getElementById("categoryDialog");
    const addCategoryBtn = document.getElementById("addCategoryBtn");
    const closeModalBtn = document.querySelector(".close");
    const overlay = document.querySelector(".modal-overlay");

    // Show modal when Add Category button is clicked
    addCategoryBtn.addEventListener("click", function () {
        modal.style.display = "flex";
    });

    // Close modal when clicking the close button
    closeModalBtn.addEventListener("click", function () {
        modal.style.display = "none";
    });

    // Close modal when clicking outside (on the overlay)
    overlay.addEventListener("click", function () {
        modal.style.display = "none";
    });

    // Form submission logic
    document.getElementById("categoryForm").addEventListener("submit", function (event) {
        event.preventDefault();

        let name = document.getElementById("categoryName").value;
        let status = document.getElementById("categoryStatus").value;
        let tableBody = document.getElementById("categoryTableBody");

        let newRow = `<tr>
            <td>${tableBody.rows.length + 1}</td>
            <td>${name}</td>
            <td>${status}</td>
            <td>${new Date().toISOString().split('T')[0]}</td>
            <td>
                <button class="edit-btn">Edit</button>
                <button class="delete-btn">Delete</button>
            </td>
        </tr>`;

        tableBody.innerHTML += newRow;

        // Hide the modal after submission
        modal.style.display = "none";

        // Clear the input fields
        document.getElementById("categoryName").value = "";
        document.getElementById("categoryStatus").value = "Active";
    });
});
