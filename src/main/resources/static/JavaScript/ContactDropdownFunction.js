/*<![CDATA[*/
$(document).ready(function() {
    $('.select').select2();

    const cardDropdown = JSON.parse(jsonContactProperties);

    function populateCardDropdown() {
        const dropdown = $('#contactDropdown');
        cardDropdown.forEach(function(card) {
            const optionText = "Real-Estate Nr.: " + card.id;
            const option = new Option(optionText, card.id);
            dropdown.append(option);
        });
    }
    populateCardDropdown();

    $('#contactDropdown').on('change', function() {
        const selectedOption = $(this).find('option:selected');
        const selectedValue = selectedOption.val();
        const selectedText = selectedOption.text();
        document.getElementById('selectedOptionOutput').innerHTML = "Selected: " + selectedText;
    });
});
/*]]>*/
