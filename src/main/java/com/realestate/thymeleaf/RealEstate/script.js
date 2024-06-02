const cardsPerPage = 5; // Number of cards to show per page
const dataContainer = document.getElementById('data-container');
const pagination = document.getElementById('pagination');
let currentPage = 1;

$(document).ready(function() {
    var clickedCardId = $(this).attr('id');
     $("#hcard1").on("click", function() {
        console.log("clicking here")
        $("#vcard1").removeClass("card-hidden");
     });

    function displayPage(page) {
        const startIndex = (page - 1) * cardsPerPage;
        const endIndex = startIndex + cardsPerPage;

        cards.forEach((card, index) => {
            if (index >= startIndex && index < endIndex) {
                card.style.display = 'block';
            } else {
                card.style.display = 'none';
            }
        });

    }
    // Pagination
    function updatePagination(currentPage = 1) {
        const pagination = document.getElementById('pagination');

        // Clear existing pagination links
        pagination.innerHTML = '';
        const ul = document.createElement('ul');
        ul.setAttribute('class', 'pagination container d-flex');

        // Generate new pagination links
        let hasNextPage = false;
        let hasPreviousPage = false;

        // Loop through pages
        for (let i = 1; i <= totalPages; i++) {
            const link = document.createElement('a');
            link.className = 'page-link';
            link.id = i;
            link.href = '#';
            link.textContent = i;
            link.onclick = function() { updatePagination(i); };
            const item = document.createElement('li');
            item.className = 'page-item';
            item.appendChild(link);
            ul.appendChild(item);
        }

        pagination.appendChild(ul);

        // Display appropriate cards
        displayPage(currentPage);
    }

    // Initial page load
    const cards = Array.from(dataContainer.getElementsByClassName('card'));
    const totalPages = Math.ceil(cards.length / cardsPerPage);
    updatePagination(currentPage);

    // Event listener for pagination
    document.addEventListener('click', function(event) {
        if (event.target.matches('.page-link')){
            let currentPage = parseInt(event.target.textContent);
            updatePagination(currentPage);
        }
    });

});
/*
$(document).ready(function() {
    // Assuming you have a way to determine the total number of cards
    var totalCards = 2; // Example: You have 10 cards
    for (var i = 1; i <= totalCards; i++) {
        $("#hcard" + i).on("click", function() {
            console.log("clickng here on the card " + i);
            $("#vcard" + i).removeClass("card-hidden");
        });
    }
});*/


