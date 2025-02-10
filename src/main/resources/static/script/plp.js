// Add interactive features for card elements

document.querySelectorAll('.dish-card').forEach(card => {
    card.addEventListener('mouseover', function () {
        const price = this.querySelector('.price');
        const stars = this.querySelectorAll('.rating i');

        // Animate price to make it stand out
        price.style.transform = 'scale(1.1)';

        // Animate star ratings on hover
        stars.forEach(star => {
            star.style.transform = 'scale(1.1)';
        });
    });

    card.addEventListener('mouseout', function () {
        const price = this.querySelector('.price');
        const stars = this.querySelectorAll('.rating i');

        // Reset price scale back to normal
        price.style.transform = 'scale(1)';

        // Reset star scale back to normal
        stars.forEach(star => {
            star.style.transform = 'scale(1)';
        });
    });
});

// Zoom effect on the dish image
document.querySelectorAll('.dish-image').forEach(image => {
    image.addEventListener('mouseover', () => {
        image.style.transform = 'scale(1.1)';
    });

    image.addEventListener('mouseout', () => {
        image.style.transform = 'scale(1)';
    });
});
