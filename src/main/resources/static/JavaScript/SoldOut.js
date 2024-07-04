document.addEventListener('DOMContentLoaded', function() {
    // Select all cards
    var cards = document.querySelectorAll('.card');

    // Iterate over each card
    cards.forEach(function(card) {
        // Get the status element
        var statusElement = card.querySelector('.status');

        // Check if the status is 'sold'
        if (statusElement && statusElement.textContent.trim().toLowerCase() === 'status: rented') {
            // Add 'sold' class to the card
            card.classList.add('sold');

            // Disable all buttons within the card
            var buttons = card.querySelectorAll('.btn');
            buttons.forEach(function(button) {
                button.disabled = true;
            });
        }
    });
});