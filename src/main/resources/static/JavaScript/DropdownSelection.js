document.addEventListener('DOMContentLoaded', function() {
    if (typeof jsonProperties === 'undefined') {
        console.error('jsonProperties is not defined');
        return;
    }

    var properties = JSON.parse(jsonProperties);

    var uniqueCities = [...new Set(properties.map(p => p.city))];
    var uniquePropertyTypes = [...new Set(properties.map(p => p.propertyType))];
    var uniqueStatus = [...new Set(properties.map(p => p.listingStatus))];
    var uniqueRooms = [...new Set(properties.map(p => p.rooms))].sort((a, b) => a - b).map(rooms => `${rooms} Rooms`);
    var uniqueBudgets = [...new Set(properties.map(p => p.rentalPrice))].map(price => `$${price}`);

    uniqueBudgets.sort((a, b) => {
        let budgetA = parseFloat(a.slice(1));
        let budgetB = parseFloat(b.slice(1));

        return budgetA - budgetB;
    })

    function setOptions(selectId, options, defaultOption) {
        var select = document.getElementById(selectId);
        select.innerHTML = `<option disabled selected value="">${defaultOption}</option>` +
            options.map(option => `<option value="${option}">${option}</option>`).join('');
    }

    setOptions('location', uniqueCities, 'Select a Location');
    setOptions('propertyType', uniquePropertyTypes, 'Select a Property Type');
    setOptions('status', uniqueStatus, 'Select Status');
    setOptions('rooms', uniqueRooms, 'Select Rooms');
    setOptions('budget', uniqueBudgets, 'Budget');
});

