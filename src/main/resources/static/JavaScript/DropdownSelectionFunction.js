document.addEventListener('DOMContentLoaded', function() {
    // Check if jsonProperties from Spring Boot is defined
    if (typeof jsonProperties === 'undefined') {
        console.error('jsonProperties is not defined');
        return;
    }

    const properties = JSON.parse(jsonPropertiesDS);

    // Pass the unique values to the array
    const uniqueCities = getUniqueValues(properties, 'city');
    const uniquePropertyTypes = getUniqueValues(properties, 'propertyType');
    const uniqueStatus = getUniqueValues(properties, 'listingStatus');
    const uniqueRooms = getUniqueValues(properties, 'rooms').sort(numericSort).map(formatRooms);
    const uniqueBudgets = getUniqueValues(properties, 'rentalPrice').map(formatBudget).sort(numericSortByBudget);

    // Set the Values as options for the select2 dropdown option by the id identifier
    setOptions('location', uniqueCities, 'Select a Location');
    setOptions('propertyType', uniquePropertyTypes, 'Select a Property Type');
    setOptions('status', uniqueStatus, 'Select Status');
    setOptions('rooms', uniqueRooms, 'Select Rooms');
    setOptions('budget', uniqueBudgets, 'Budget');

    // Extract all unique values from the array to avoid redundancy in the output
    function getUniqueValues(array, key) {
        return [...new Set(array.map(item => item[key]))];
    }

    // sorting within the dropdown of options
    function numericSort(a, b) {
        return a - b;
    }

    // Format rooms output
    function formatRooms(rooms) {
        return `${rooms} Rooms`;
    }

    // Format budget output
    function formatBudget(price) {
        return `$${price}`;
    }

    // sort budget by slicing the dollar and sort then by number
    function numericSortByBudget(a, b) {
        const budgetA = parseFloat(a.slice(1));
        const budgetB = parseFloat(b.slice(1));
        return budgetA - budgetB;
    }

    // passing id for the required dropdown then the option and also default option
    // Insert it as innerHTML to embed HTML in js to output the values in dropdown option
    function setOptions(Id, options, defaultOption) {
        const select = document.getElementById(Id);
        select.innerHTML = `<option disabled selected value="">${defaultOption}</option>` +
            options.map(option => `<option value="${option}">${option}</option>`).join('');
    }
});
