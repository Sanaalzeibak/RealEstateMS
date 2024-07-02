document.addEventListener('DOMContentLoaded', function() {
    const submit = document.getElementById('addApartmentCard');

    submit.addEventListener('click', function() {
        const firstName = document.getElementById('addFirstName').value;
        const lastName = document.getElementById('addLastName').value;
        const apartmentType = document.getElementById('addApartmentType').value;
        const addressName = document.getElementById('addAddressName').value;
        const apartmentNumber = document.getElementById('addApartmentNumber').value;
        const rooms = document.getElementById('addRooms').value;
        const city = document.getElementById('addCity').value;
        const price = document.getElementById('addPrice').value;
        const squareFootage = document.getElementById('addSquareFootage').value;
        const message = document.getElementById('addMessage').value;

        /*
        const validApartmentTypes = ["House", "Apartment", "Condominium", "Single Family House", "Multi Family House", "Penthouse"];
        if(!apartmentType.includes(validApartmentTypes)) {
            alert("Invalid apartment type. Please select a valid type!");
        }

        if(isNaN(apartmentNumber) || apartmentNumber.trim() === "") {
            alert("Apartment number should be a number!");
        }

        if(isNaN(rooms) || rooms.trim() === "") {
            alert("Rooms should be a valid number");
        }

        if(isNaN(price) || price.trim() === "") {
            alert("Price should be a number");
        }

        if(isNaN(squareFootage) || squareFootage.trim() === "") {
            alert("Square footage should be a valid number!");
        }
        */

        console.log(firstName, lastName, apartmentType, addressName, apartmentNumber, rooms, city, price, squareFootage, message);
    });
});