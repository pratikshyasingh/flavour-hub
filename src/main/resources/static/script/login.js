function validateLogin() {
    const email = document.getElementById('loginEmail').value;
    const password = document.getElementById('loginPassword').value;

    if (!email || !password) {
        alert('Please fill in both email and password.');
        return false;
    }

    window.location.href = 'dashboard.html'; // Redirect to Dashboard
    return false;
}

function validateSignUp() {
    const name = document.getElementById('signupName').value;
    const email = document.getElementById('signupEmail').value;
    const password = document.getElementById('signupPassword').value;

    if (!name || !email || !password) {
        alert('Please fill in all fields.');
        return false;
    }

    window.location.href = 'index.html'; // Redirect to Login Page after Signup
    return false;
}

function toggleForms() {
    document.getElementById('loginForm').classList.toggle('hidden');
    document.getElementById('signupForm').classList.toggle('hidden');
}
