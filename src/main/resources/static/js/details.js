// **** global 변수 zone ****

let plusIcon = '+ ';
let selectNowName = '리소스';
let addContext = ' 추가';

// **** window.onload zone ****
window.onload = function () {
    // 아코디언 hover
    $('.accordion-button').hover(function () {
        $(this).css("background-color", "#e0f9ff");
    }, function () {
        $(this).css("background-color", "white");
    })


// 보기 selectBox select 될 때마다 버튼 change
// default selected 값
    var pickBtn = document.getElementById('pick');
    pickBtn.innerHTML = plusIcon + selectNowName + addContext;


}

// **** 외부 function 호출 zone ****
function selectChange() {
    let select = document.getElementById('show');
    selectNowName = select.options[select.selectedIndex].text;
    var pickBtn = document.getElementById('pick');
    pickBtn.innerHTML = plusIcon + selectNowName + addContext;
}