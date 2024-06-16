document.addEventListener('DOMContentLoaded', function() {
    // Initialize Select2
    $('.select2').select2();

    // Function to filter cards
    function filterCards() {
        let selectLocation = $('#location').val();
        let selectPropertyType = $('#propertyType').val();
        let selectStatus = $('#status').val();
        let selectRooms = $('#rooms').val();
        let selectBudget = $('#budget').val();

        let regexLocation = new RegExp(selectLocation, 'gi');
        let regexPropertyType = new RegExp(selectPropertyType, 'gi');
        let regexStatus = new RegExp(selectStatus, 'gi');
        let regexRooms = new RegExp(selectRooms, 'gi');

        $('.card').each(function() {
            let card = $(this);
            let cardFindLocation = card.find('.card-subtitle').text();
            let cardFindPropertyType = card.find('.card-subtitle').text();
            let cardFindStatus = card.find('.card-subtitle').text();
            let cardFindRooms = card.find('.card-text').text();
            let cardFindBudget = parseInt(card.find('.card-text').text().replace('$', ''));

            let locationMatch = !selectLocation || regexLocation.test(cardFindLocation);
            let propertyTypeMatch = !selectPropertyType || regexPropertyType.test(cardFindPropertyType);
            let statusMatch = !selectStatus || regexStatus.test(cardFindStatus);
            let roomsMatch = !selectRooms || regexRooms.test(cardFindRooms);
            let budgetMatch = true;

            if (selectBudget) {
                let budgetVal = selectBudget.split(' - ');
                let minBudget = parseInt(budgetVal[0].replace('$', ''));
                let maxBudget = parseInt(budgetVal[1].replace('$', ''));
                budgetMatch = !isNaN(cardFindBudget) && cardFindBudget >= minBudget && cardFindBudget <= maxBudget;
            }

            if (locationMatch && propertyTypeMatch && statusMatch && roomsMatch && budgetMatch){
                card.show();
            }else {
                card.hide();
            }
        });
    }

    // Event listeners for the dropdowns
    $('#location, #propertyType, #status, #rooms, #budget').on('change', function() {
        filterCards();
    });

    // Reset button click event
    $('#resetButton').on('click', function() {
        $('.card').show();
        $('.select2').val(null).trigger('change');
    });

    // Access the JSON data from the model
    var jsonProperties = document.getElementById('jsonProperties').textContent;
    var properties = JSON.parse(jsonProperties);

    var uniqueCities = [...new Set(properties.map(p => p.city))];
    var uniquePropertyTypes = [...new Set(properties.map(p => p.type))];
    var uniqueStatus = [...new Set(properties.map(p => p.listingstatus))];
    var uniqueRooms = [...new Set(properties.map(p => p.room))].sort((a, b) => a - b).map(room => `${room} Rooms`);
    var uniqueBudgets = [...new Set(properties.map(p => p.rPrice))].map(price => `$${price}`);

    function setOptions(selectId, options, defaultOption) {
        var select = document.getElementById(selectId);
        select.innerHTML = `<option disabled selected value="">${defaultOption}</option>` +
            options.map(option => `<option value="${option}">${option}</option>`).join('');
    }

    setOptions('location', uniqueCities, 'Select a Location');
    setOptions('propertyType', uniquePropertyTypes, 'Select a Property Type');
    setOptions('status', uniqueStatus, 'Status');
    setOptions('rooms', uniqueRooms, 'Select Rooms');
    setOptions('budget', uniqueBudgets, 'Budget');
});
