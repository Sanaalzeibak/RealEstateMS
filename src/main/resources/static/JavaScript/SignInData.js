document.addEventListener('DOMContentLoaded', function() {
    const emailInput = document.getElementById('emailInput');
    const passwordInput = document.getElementById('passwordInput');
    const submitButton = document.getElementById('submitButton');

    submitButton.addEventListener('click', function() {
        const emailValue = emailInput.value;
        const passwordValue = passwordInput.value;

        console.log(emailValue);
        console.log(passwordValue);


        // (Howard) hier kannst du deinen Code setzen
        // Output siehst du mit F12 im Browser (Development Tool für HTML)
    });
});