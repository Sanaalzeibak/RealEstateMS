document.getElementById('signIn').addEventListener('click', function() {
    const sellerRadio = document.getElementById('seller');
    const buyerRadio = document.getElementById('buyer');
    if(sellerRadio.checked) {
        window.location.href = '../Website/SellerPage.html';
    } else if(buyerRadio.checked) {
        window.location.href = '../Website/BuyerPage.html';
    }
});
