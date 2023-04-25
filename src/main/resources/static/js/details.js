window.onload = function () {
    $('.accordion-button').hover(function () {
        $(this).css("background-color", "#e0f9ff");
    }, function () {
        $(this).css("background-color", "white");
    })
}

$('.renew').tooltip();