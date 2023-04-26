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


}
// 보기 selectBox select 될 때마다 버튼 change
// **** 외부 function 호출 zone ****
function selectChange(value) {

    let choose = value.options[value.selectedIndex].value
    console.log(choose)
    if (choose == 'tag') {
        selectNowName = "태크"
        $('#pick').text(plusIcon + selectNowName + addContext)
        $('#pick').attr('data-target', '#tagModal');

    } else if (choose = 'resource') {
        selectNowName = "리소스"
        $('#pick').text(plusIcon + selectNowName + addContext)
        $('#pick').attr('data-target', '#resourceModal');
    }

}

function addTag() {
    // 태그 추가 코드~~

    Swal.fire({
        title: '등록 성공',
        icon: 'success'
    }).then(() => {
        $('#tagModal').modal('hide');
    })
}
