let imageCache = [];

// if item exists in localstorage fetch it
if (localStorage.getItem('imageCache')) {
    imageCache = JSON.parse(localStorage.getItem('imageCache'));
}

function httpRequest() {
    const apiKey = "7nQ9HYoAbyT-q5_NATX7MiRYH2-oYnJSCXAmLL9Ibq4";
    const category = "house,home exterior,property,estate";
    const apiURL = `https://api.unsplash.com/photos/random?query=${encodeURIComponent(category)}&client_id=${apiKey}`;

    if (imageCache.length > 0) {
        const cachedImage = imageCache[Math.floor(Math.random() * imageCache.length)];
        displayImage(cachedImage);
    } else {
        fetch(apiURL).then(response => {
            if (!response.ok) {
                throw new Error("Network or API Call was not ok");
            }
            return response.json();
        }).then(data => {
            // Push image to cache (array)
            imageCache.push(data);

            // store item in localstorage
            localStorage.setItem('imageCache', JSON.stringify(imageCache));

            displayImage(data);
        }).catch(error => {
            console.error("Error: ", error);
        });
    }
}

function displayImage(data) {
    // Sets the size of the picture
    const width = 507;
    const height = 325;
    const imageUrl = `${data.urls.raw}&w=${width}&h=${height}&fit=crop`;

    // Using innerHTML to output picture as HTML
    document.getElementById("apiTest").innerHTML = ` 
        <img class="img-fluid rounded-start" src="${imageUrl}" alt="${data.alt_description}" />
    `;
}

httpRequest();
