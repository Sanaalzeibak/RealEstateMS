document.addEventListener('DOMContentLoaded', function() {
    //var firstname = document.getElementById('firstNameApartment').value();
    //var lastname = document.getElementById('lastNameApartment').value();
    var apartmentType = document.getElementById('apartmentType').value();
    var address = document.getElementById('addressNameApartment').value();
    var apartmentNumber = document.getElementById('apartmentNumber').value();
    var rooms = document.getElementById('roomsApartment').value();
    var city = document.getElementById('cityApartment').value();
    var price = document.getElementById('priceApartment').value();
    var squareFootage = document.getElementById('squareFootage').value();
    var message = document.getElementById('messageApartment').value();

    var imageURL = "";
    var id = 20
    var property = {
        id: id + 1,
        apartmentType: apartmentType,
        city: city,
        address: address + " " + apartmentNumber,
        status: "Active",
        rooms: rooms,
        square: squareFootage,
        price: price,
        message: message,
    }

    var cardsContainer = document.getElementById('cardsContainer');
    var cardHTML = `
            <div class="card mb-3">
                <div class="row g-0">
                    <div class="col-md-6">
                        <img src="/Images/add_apartment.png" class="img-fluid rounded-start" alt="Property Image">
                    </div>
                    <div class="col-md-6">
                        <div class="card-body">
                            <h5 class="card-title pb-2">Real-Estate Nr.: ${property.id}</h5>
                            <div class="location-container d-flex align-items-center pb-2">
                                <img src="/Images/location_icon.png" class="img-fluid rounded-start" alt="Location Icon">
                                <h6 class="card-subtitle text-body-secondary">${property.city} (${property.apartmentType})</h6>
                            </div>
                            <p class="card-info">Country: ${property.city}</p>
                            <p class="card-info">Address: ${property.address}</p>
                            <p class="card-info status">Status: ${property.status}</p>
                            <div class="row-card-properties d-flex justify-content-between align-items-center">
                                <div class="col-md-3">
                                    <p class="card-text">$${property.price}</p>
                                </div>
                                <div class="col-md-3">
                                    <p class="card-text">${property.square}m²</p>
                                </div>
                                <div class="col-md-3">
                                    <p class="card-text">${property.rooms} Rooms</p>
                                </div>
                                <div class="col-md-3">
                                    <button class="contact-btn btn btn-outline-secondary" data-bs-target="#contact" data-bs-toggle="modal" type="submit">Contact</button>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>`;

    cardsContainer.innerHTML += cardHTML;
});

