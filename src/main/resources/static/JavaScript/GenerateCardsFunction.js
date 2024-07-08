/*<![CDATA[*/
function fetchRandomImage() {
    const apiKey = "7nQ9HYoAbyT-q5_NATX7MiRYH2-oYnJSCXAmLL9Ibq4";
    const category = "house,home exterior,property,estate";
    const width = 540;
    const height = 350;
    const apiURL = `https://api.unsplash.com/photos/random?query=${encodeURIComponent(category)}&client_id=${apiKey}`;

    const xhr = new XMLHttpRequest();
    xhr.open('GET', apiURL, false); // synchronous request
    xhr.send(null);

    if (xhr.status === 200) {
        const data = JSON.parse(xhr.responseText);
        return `${data.urls.raw}&w=${width}&h=${height}&fit=crop`;
    } else {
        console.error('Error fetching image:', xhr.statusText);
        return '/Images/default_image.jpg';
    }
}

const properties = JSON.parse(jsonPropertiesGC);
const container = document.getElementById('properties-container');

function generateCardHTML(property) {
    const imageUrl = fetchRandomImage();
    return `
        <div class="card mb-3" id="property-${property.id}">
            <div class="row g-0">
                <div class="col-md-6">
                    <img src="${imageUrl}" class="img-fluid rounded-start" alt="Property Image">
                </div>
                <div class="col-md-6">
                    <div class="card-body">
                        <h5 class="card-title pb-2">Real-Estate Nr.: ${property.id}</h5>
                        <div class="location-container d-flex align-items-center pb-2">
                            <img src="/Images/location_icon.png" class="img-fluid rounded-start" alt="Location Icon">
                            <h6 class="card-subtitle text-body-secondary">${property.city} (${property.propertyType})</h6>
                        </div>
                        <p class="card-info">Country: ${property.country}</p>
                        <p class="card-info">Address: ${property.address}</p>
                        <p class="card-info status">Status: ${property.listingStatus}</p>
                        <div class="row-card-properties d-flex justify-content-between align-items-center">
                            <div class="col-md-3">
                                <p class="card-text">$${property.rentalPrice}</p>
                            </div>
                            <div class="col-md-3">
                                <p class="card-text">${property.squareFootage}m²</p>
                            </div>
                            <div class="col-md-3">
                                <p class="card-text">${property.rooms} Rooms</p>
                            </div>
                            <div class="col-md-3">
                                <button class="contact-btn btn btn-outline-secondary rent-btn" data-bs-toggle="modal" data-bs-target="#contact-${property.id}" data-property-id="${property.id}" type="button">Rent</button>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div aria-hidden="true" aria-labelledby="exampleModalLabel" class="modal fade" id="contact-${property.id}" tabindex="-1">
            <div class="modal-dialog modal-dialog-centered contact-apartment">
                <div class="modal-content text-center d-flex align-items-center justify-content-center">
                    <form action="@{/sellerPage}" method="post">
                        <div class="mb-3 modal-header container d-flex justify-content-between">
                            <h5 class="modal-title contact-title col-11" id="log-in">Rent property</h5>
                            <!-- Close button -->
                            <button type="button" class="btn-close col-1" data-bs-dismiss="modal" aria-label="Close"></button>
                        </div>
                        <div class="modal-body">
                            <div class="row">
                                <div class="form-group col-md-6">
                                    <label class="p-2 required" for="firstName" data-toggle="tooltip" title="First name is required">First name</label>
                                    <input class="form-control" id="firstName-${property.id}" placeholder="First name" type="text">
                                </div>
                                <div class="form-group col-md-6">
                                    <label class="p-2 required" for="lastName" data-toggle="tooltip" title="Last name is required">Last name</label>
                                    <input class="form-control" id="lastName-${property.id}" placeholder="Last name" type="text">
                                </div>
                            </div>
                            <div class="row">
                                <div class="form-group col-md-8">
                                    <label class="p-2 required" for="Email" data-toggle="tooltip" title="Email is required">Email</label>
                                    <input class="form-control" id="email-${property.id}" placeholder="email@example.com" type="email" name="buyerEmail" required>
                                </div>
                                <div class="form-group col-md-4">
                                    <label class="p-2 required" for="Message" data-toggle="tooltip" title="Property ID is required">Property ID</label>
                                    <input class="form-control" id="ID-${property.id}" placeholder="Property ID" type="text" name="propertyId" value="${property.id}" readonly required>
                                </div>
                            </div>
                            <div class="row pb-4">
                                <div class="form-group col-md-12">
                                    <label class="p-2" for="Message">Your Message (Optional)</label>
                                    <input class="form-control contact-message" id="message-${property.id}" placeholder="Your Message" type="text">
                                </div>
                            </div>
                        </div>
                        <div class="modal-footer container d-flex justify-content-center p-0">
                            <button class="log-in btn btn-outline-secondary px-5 mb-3 rent-btn" type="submit">Rent</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>`;
}




function saveCardToLocalStorage(property) {
    try {
        const cardHTML = generateCardHTML(property);
        localStorage.setItem(`propertyCard-${property.id}`, cardHTML);
        console.log(`Property card ${property.id} saved to localStorage.`);
    } catch (error) {
        console.error(`Error generating or saving property card ${property.id}:`, error);
    }
}

function syncLocalStorageWithProperties() {
    const propertyIds = properties.map(property => property.id);
    const savedKeys = Object.keys(localStorage).filter(k => k.startsWith('propertyCard-'));

    savedKeys.forEach(k => {
        const propertyId = parseInt(k.replace('propertyCard-', ''), 10);
        if (!propertyIds.includes(propertyId)) {
            localStorage.removeItem(k);
            console.log(`Property card ${propertyId} removed from localStorage.`);
        }
    });

    properties.forEach(property => {
        if (!localStorage.getItem(`propertyCard-${property.id}`)) {
            saveCardToLocalStorage(property);
        }
    });
}

function renderCardsFromLocalStorage() {
    const savedKeys = Object.keys(localStorage).filter(k => k.startsWith('propertyCard-'));
    if (savedKeys.length > 0) {
        savedKeys.forEach(k => {
            container.innerHTML += localStorage.getItem(k);
        });
    } else {
        properties.forEach(property => saveCardToLocalStorage(property));
    }
}

function updateCardStatusToRented(propertyId) {
    const propertyKey = `propertyCard-${propertyId}`;
    let cardHTML = localStorage.getItem(propertyKey);
    if (cardHTML) {
        // Update the Status from Active to Rented
        cardHTML = cardHTML.replace(/<p class="card-info status">Status: .+<\/p>/, '<p class="card-info status">Status: Rented</p>');

        // Save the updated card HTML back to localStorage
        localStorage.setItem(propertyKey, cardHTML);
        console.log(`Property card ${propertyId} updated to rented in localStorage.`);

        // Re-render the updated card in the DOM
        document.getElementById(`property-${propertyId}`).outerHTML = cardHTML;
    } else {
        console.error(`Property card ${propertyId} not found in localStorage.`);
    }
}

document.addEventListener('click', function (event) {
    if (event.target.matches('.rent-btn')) {
        const propertyId = event.target.getAttribute('data-property-id');
        const firstName = document.getElementById(`firstName-${propertyId}`).value;
        const lastName = document.getElementById(`lastName-${propertyId}`).value;
        const email = document.getElementById(`email-${propertyId}`).value;
        const message = document.getElementById(`message-${propertyId}`).value;

        console.log(`Property ID: ${propertyId}`);
        console.log(`First Name: ${firstName}`);
        console.log(`Last Name: ${lastName}`);
        console.log(`Email: ${email}`);
        console.log(`Message: ${message}`);

        // Optionally, update the card status to "Rented" or any other action
        updateCardStatusToRented(propertyId);
    }
});


function clearLocalStorage() {
    localStorage.clear();
    console.log('All local storage cleared.');
}

(function() {
    clearLocalStorage(); // Clear local storage once
    syncLocalStorageWithProperties();
    renderCardsFromLocalStorage();
})();
/*]]>*/
