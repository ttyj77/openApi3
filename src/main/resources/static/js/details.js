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
    let resource = "resource";
    let tag = "tag";
    let select = document.getElementById('show');
    selectNowName = select.options[select.selectedIndex].text;
    let selectNowValue = select.options[select.selectedIndex].value;
    let resourceBtn = $(document.createElement("button")).addClass("btn btn-secondary").attr({
        "id":"resourceBtn",
        "data-bs-toggle": "modal",
        "data-bs-target": "#resourceModal"
    }).text(plusIcon + selectNowName + addContext);
    let tagBtn = $(document.createElement("button")).addClass("btn btn-secondary").attr({
        "id":"tagBtn",
        "data-bs-toggle": "modal",
        "data-bs-target": "#tagModal"
    }).text(plusIcon + selectNowName + addContext);

    var pickBtn = document.getElementById('pick');

    if (selectNowValue == resource) {
        $('#target').append(resourceBtn);
        $('#resourceBtn').click();
    } else if (selectNowValue == tag) {
        $('#target').append(tagBtn);
        $('#tagBtn').click();
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
