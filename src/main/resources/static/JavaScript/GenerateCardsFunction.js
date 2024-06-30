/*<![CDATA[*/
// Function to randomly get images from the Unsplash API
async function fetchRandomImage() {
    // Set the Key and properties that
    const apiKey = "7nQ9HYoAbyT-q5_NATX7MiRYH2-oYnJSCXAmLL9Ibq4";
    const category = "house,home exterior,property,estate";
    const width = 540;
    const height = 350;
    const apiURL = `https://api.unsplash.com/photos/random?query=${encodeURIComponent(category)}&client_id=${apiKey}`;

    try {
        const response = await fetch(apiURL);
        if (!response.ok) {
            throw new Error(`HTTP error! Status: ${response.status}`);
        }
        const data = await response.json();

        // Constructing the image URL with specific dimensions
        return `${data.urls.raw}&w=${width}&h=${height}&fit=crop`;
    } catch (error) {
        console.error('Error fetching image:', error);
        // Default image URL in case of error
        return '/Images/default_image.jpg';
    }
}

// Access the JSON data from the model
const properties = JSON.parse(jsonProperties);

// Get the container element where cards will be added
const container = document.getElementById('properties-container');

// Function to generate a single card HTML
async function generateCardHTML(property) {
    // Fetch a random image URL with specific dimensions
    const imageUrl = await fetchRandomImage();

    // Building dynamic card for the property
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
                                <button class="contact-btn btn btn-outline-secondary" data-bs-target="#contact" data-bs-toggle="modal" type="submit">Rent</button>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>`;
}

// Save individual card to local storage
async function saveCardToLocalStorage(property) {
    try {
        const cardHTML = await generateCardHTML(property);
        localStorage.setItem(`propertyCard-${property.id}`, cardHTML);
        console.log(`Property card ${property.id} saved to localStorage.`);
    } catch (error) {
        console.error(`Error generating or saving property card ${property.id}:`, error);
    }
}

// Synchronize local storage with the current properties
async function syncLocalStorageWithProperties() {
    const propertyIds = properties.map(property => property.id);
    const savedKeys = Object.keys(localStorage).filter(key => key.startsWith('propertyCard-'));

    // Remove cards from local storage that are not in the current properties
    savedKeys.forEach(key => {
        const propertyId = parseInt(key.replace('propertyCard-', ''), 10);
        if (!propertyIds.includes(propertyId)) {
            localStorage.removeItem(key);
            console.log(`Property card ${propertyId} removed from localStorage.`);
        }
    });

    // Add or update cards in local storage based on the current properties
    for (const property of properties) {
        if (!localStorage.getItem(`propertyCard-${property.id}`)) {
            await saveCardToLocalStorage(property);
        }
    }
}

// Render cards from the local storage
function renderCardsFromLocalStorage() {
    const savedKeys = Object.keys(localStorage).filter(key => key.startsWith('propertyCard-'));
    if (savedKeys.length > 0) {
        savedKeys.forEach(key => {
            container.innerHTML += localStorage.getItem(key);
        });
    } else {
        // If no saved cards found, generate and save new ones
        properties.forEach(property => saveCardToLocalStorage(property));
    }
}

// Synchronize local storage with the current properties and render cards
(async function() {
    await syncLocalStorageWithProperties();
    renderCardsFromLocalStorage();
})();
/*]]>*/
