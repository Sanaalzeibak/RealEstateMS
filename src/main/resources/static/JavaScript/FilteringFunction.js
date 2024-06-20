document.addEventListener('DOMContentLoaded', function() {
    // Initialize Select2 for the html select tag
    $('.select2').select2();
    let pagination = document.getElementById('pagination');

    // Function to filter cards
    function filterCards() {
        // Extract the Values of the id
        const selectLocation = $('#location').val();
        const selectPropertyType = $('#propertyType').val();
        const selectStatus = $('#status').val();
        const selectRooms = $('#rooms').val();
        const selectBudget = $('#budget').val();

        // Setting up a regex
        const regexLocation = createRegex(selectLocation);
        const regexPropertyType = createRegex(selectPropertyType);
        const regexStatus = createRegex(selectStatus);
        const regexRooms = createRegex(selectRooms);
        const regexBudget = createRegex(selectBudget);

        // Now we look for all cards available in the HTML
        $('.card').each(function() {
            const card = $(this);

            // skip filtering for the vertical card to contact
            if (card.attr('id') === 'vcard1') {
                return;
            }

            // Finding the card by the class and extract the text content of it
            const cardFindLocation = card.find('.card-subtitle').text();
            const cardFindPropertyType = card.find('.card-subtitle').text();
            const cardFindStatus = card.find('.card-info').text();
            const cardFindRooms = card.find('.card-text').text();
            const cardFindBudget = card.find('.card-text').text();

            // Essentially checks if the options inside the dropdown are set and check if it matches with the regex
            const locationMatch = !selectLocation || regexLocation.test(cardFindLocation);
            const propertyTypeMatch = !selectPropertyType || regexPropertyType.test(cardFindPropertyType);
            const statusMatch = !selectStatus || regexStatus.test(cardFindStatus);
            const roomsMatch = !selectRooms || regexRooms.test(cardFindRooms);
            const budgetMatch = !selectBudget || regexBudget.test(cardFindBudget);

            // Decides if the card is either shown or hidden
            if (locationMatch && propertyTypeMatch && statusMatch && roomsMatch && budgetMatch) {
                card.show();
            } else {
                pagination.style.visibility = "hidden";
                card.hide();
            }
        });
    }

    // Creating the Regex
    function createRegex(value) {
        return new RegExp(value, 'gi');
    }

    // Event listeners for the dropdowns
    $('#location, #propertyType, #status, #rooms, #budget').on('change', function() {
        filterCards();
    });

    // Reset button click event
    $('#resetButton').on('click', function() {
        pagination.style.visibility = "visible";
        $('.card').show();
        $('.select2').val(null).trigger('change');
    });
});
