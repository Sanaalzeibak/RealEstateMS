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

        console.log(firstName, lastName, apartmentType, addressName, apartmentNumber, rooms, city, price, squareFootage, message);
    });
});