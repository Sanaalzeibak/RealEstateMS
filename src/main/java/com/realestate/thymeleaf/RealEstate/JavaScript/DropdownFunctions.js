$(document).ready(function() {
    // Dropdown Location
    function createLocationDropdown() {
        let cities = [
            "Berlin", "Frankfurt am Main", "Bonn", "Munich", "Stuttgart", "Bremen", "Dresden", "Hanover", "Nuremberg", "Duisberg", "Bochum",
            "Cologne", "Düsseldorf", "Leipzig", "Essen", "Bochum", "Wiesbaden", "Aachen", "Kiel", "Braunschweig", "Augsburg", "Münster", "Halle",
            "Erfurt", "Oberhausen", "Rostock", "Lübeck", "Magdeburg", "Chemnitz", "Hamm", "Kassel", "Hagen", "Oldenburg", "Osnabrück",
            "Eschborn", "Aschaffenburg", "Bad Homburg" // add more...
        ];

        cities.forEach(function(city) {
            $('#location').append($('<option>', {
                value: city,
                text: city
            }));
        });
    }
    createLocationDropdown();


    // Dropdown for the Property Types
    function createPropertyTypeDropdown() {
        let propertyTypes = [
            "Apartment", "House", "Condominium", "Single Family House", "Multi Family House", "Penthouse",
            "Student Dormitory" // add more ...
        ];

        propertyTypes.forEach(function(propertyType) {
            $('#propertyType').append($('<option>', {
                value: propertyType,
                text: propertyType
            }));
        });
    }
    createPropertyTypeDropdown();


    // Dropdown for the Tenure Type
    function createTenureTypeDropdown() {
        let tenureType = [
            "Own Freehold", "Leasehold", "Joint Ownership", "Commonhold Ownership", "Share of Freehold" // add more...
        ];

        tenureType.forEach(function(tenureType) {
            $('#tenureType').append($('<option>', {
                value: tenureType,
                text: tenureType
            }));
        });
    }
    createTenureTypeDropdown();


    // Dropdown for Rooms
    function createRoomsDropdown() {
        let rooms = [
            "1 Room", "2 Rooms", "3 Rooms", "4 Rooms", "5 Rooms", "6 Rooms", "7 Rooms", "8 Rooms", "9 Rooms", "10 Rooms",
            "11 Rooms", "12 Rooms", "13 Rooms", "14 Rooms", "15 Rooms", "16 Rooms", "17 Rooms", "18 Rooms", "19 Rooms",
            "20 Rooms" // add more...
        ];

        rooms.forEach(function(rooms) {
            $('#rooms').append($('<option>', {
                value: rooms,
                text: rooms
            }));
        });
    }
    createRoomsDropdown();


    // Dropdown for Budget
    function createBudgetDropdown() {
        let budget = [];

        for(let i = 0; i <= 10000; i += 200) {
            budget.push(`$${i} - $${i+199}`);
        }
        budget.pop();

        budget.forEach(function(budget) {
            $('#budget').append($('<option>', {
                value: budget,
                text: budget
            }));
        });
    }
    createBudgetDropdown();
});