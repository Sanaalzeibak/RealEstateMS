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
                                <button class="contact-btn btn btn-outline-secondary" data-bs-target="#contact" data-bs-toggle="modal" type="button">Rent</button>
                            </div>
                        </div>
                    </div>
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

(function() {
    syncLocalStorageWithProperties();
    renderCardsFromLocalStorage();
})();
/*]]>*/

