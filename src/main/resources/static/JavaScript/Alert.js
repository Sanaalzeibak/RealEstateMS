document.addEventListener('DOMContentLoaded', function() {
    const button = document.getElementById('reload');
    button.addEventListener('click', reloadWebsite);
    function reloadWebsite() {
        console.log('reloaded1');
        location.reload();
        console.log('reloaded2');
    }

});