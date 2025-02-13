function submitFeedback() {
    const feedbackText = document.getElementById("feedback-text").value;
    if (feedbackText.trim() !== "") {
        document.getElementById("feedback-message").innerText = "Thank you for your feedback!";
        document.getElementById("feedback-text").value = "";
    }
}


window.addEventListener('scroll', function () {
    var navbar = document.getElementById('navbar');
    if (window.scrollY > 50) {
        navbar.classList.remove('transparent');
        navbar.classList.add('scrolled');
    } else {
        navbar.classList.remove('scrolled');
        navbar.classList.add('transparent');
    }
});

function openLoginPage() {
    window.location.href = 'login.html';
}
