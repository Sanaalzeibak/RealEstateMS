document.addEventListener('DOMContentLoaded', function() {
    const usernameInput = document.getElementById('usernameInput');
    const passwordInput = document.getElementById('passwordInput');
    const submitButton = document.getElementById('submitButton');

    submitButton.addEventListener('click', function() {
        const usernameValue = usernameInput.value;
        const passwordValue = passwordInput.value;

        console.log(usernameValue);
        console.log(passwordValue);


    });
});