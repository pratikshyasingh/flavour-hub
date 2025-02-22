document.addEventListener("DOMContentLoaded", function () {
    const modal = document.getElementById("categoryDialog");
    const addCategoryBtn = document.getElementById("addCategoryBtn");
    const closeModalBtn = document.querySelector(".close");
    const overlay = document.querySelector(".modal-overlay");
    const categoryForm = document.getElementById("categoryForm");
    const tableBody = document.getElementById("categoryTableBody");

    // Show modal when Add Category button is clicked
    addCategoryBtn.addEventListener("click", function () {
        modal.style.display = "flex";
        categoryForm.reset(); // Clear form fields when opening
    });

    // Close modal when clicking the close button
    closeModalBtn.addEventListener("click", function () {
        modal.style.display = "none";
    });

    // Close modal when clicking outside content
    overlay.addEventListener("click", function () {
        modal.style.display = "none";
    });
})


