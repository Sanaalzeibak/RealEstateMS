$(document).ready(function() {
    // select 2 activation
    $('.select2').select2();

    // hide the cards when filter active
    $('#searchButton').on('click', function() {
        // Get selected values from the dropdowns
        let selectLocation = $('#location').val();
        let selectPropertyType = $('#propertyType').val();
        let selectBuyRent = $('#tenureType').val();
        let selectRooms = $('#rooms').val();
        let selectBudget = $('#budget').val();

        // create ReGeX pattern
        let regexLocation = new RegExp(selectLocation, 'gi');
        let regexPropertyType = new RegExp(selectPropertyType, 'gi');
        let regexBuyRent = new RegExp(selectBuyRent, 'gi');
        let regexRooms = new RegExp(selectRooms, 'gi');

        // Iterate over each card
        $('.card').each(function() {
            let card = $(this);
            let cardFindLocation = card.find('.card-subtitle').text();
            let cardFindPropertyType = card.find('.card-subtitle').text();
            let cardFindBuyRent = card.find('.card-subtitle').text();
            let cardFindRooms = card.find('.card-text').text();
            let cardFindBudget = parseInt(card.find('.card-text').text().replace('$', ''));

            // Check if card matches all selected criteria
            let locationMatch = !selectLocation || regexLocation.test(cardFindLocation);
            let propertyTypeMatch = !selectPropertyType || regexPropertyType.test(cardFindPropertyType);
            let buyRentMatch = !selectBuyRent || regexBuyRent.test(cardFindBuyRent);
            let roomsMatch = !selectRooms || regexRooms.test(cardFindRooms);
            let budgetMatch = true; // Always true if budget is not selected

            if (selectBudget) {
                let budgetVal = selectBudget.split(' - ');
                let minBudget = parseInt(budgetVal[0].replace('$', ''));
                let maxBudget = parseInt(budgetVal[1].replace('$', ''));
                budgetMatch = !isNaN(cardFindBudget) && cardFindBudget >= minBudget && cardFindBudget <= maxBudget;
            }

            // Show or hide the card based on filter matches
            if (locationMatch && propertyTypeMatch && buyRentMatch && roomsMatch && budgetMatch) {
                card.show();
            } else {
                card.hide();
            }
        });

        // Reset all Select2 dropdowns
        $('.select2').val(null).trigger('change');
    });

    // Reset button click event
    $('#resetButton').on('click', function() {
        $('.card').show();
        $('.select2').val(null).trigger('change');
    });
    
});
