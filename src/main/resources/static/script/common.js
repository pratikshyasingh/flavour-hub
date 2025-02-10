function submitFeedback() {
    const feedbackText = document.getElementById("feedback-text").value;
    if (feedbackText.trim() !== "") {
        document.getElementById("feedback-message").innerText = "Thank you for your feedback!";
        document.getElementById("feedback-text").value = "";
    }
}


