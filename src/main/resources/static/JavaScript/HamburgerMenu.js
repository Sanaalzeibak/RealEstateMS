document.addEventListener('DOMContentLoaded', function () {
    const menuBtn = document.getElementById('menuBtn');
    const sideMenu = document.getElementById('sideMenu');
    const overlay = document.getElementById('overlay');
    const logIn = document.getElementById('logIn');
    const menuBtnFilter = document.getElementById('menuBtnFilter');
    const filteringBox = document.getElementById('filtering-box')

    menuBtn.addEventListener('click', function () {
        sideMenu.classList.toggle('open');
        overlay.classList.toggle('show');
        document.body.classList.toggle('no-scroll');
        logIn.classList.add('nav-link');
    });

    overlay.addEventListener('click', function () {
        sideMenu.classList.remove('open');
        overlay.classList.remove('show');
        document.body.classList.remove('no-scroll');
        logIn.classList.add('nav-link');
    });
    menuBtnFilter.addEventListener('click', function () {
        filteringBox.classList.toggle('open-filters');
    });
});


