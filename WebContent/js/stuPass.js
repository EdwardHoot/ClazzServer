$(function () {
    var path = window.location.pathname;
    if(path.indexOf("stuPass")>0){
       $("#stuPass").addClass("active");
       $("#infomation").removeClass('active');
    }
    else{
       $("#infomation").addClass("active");
       $("#stuPass").removeClass('active');
    }
    $('#user').html(sessionStorage.getItem("username"));
})
function setPassword() {
    $('#modified').click(function (event) {
        event.preventDefault();
        var xhr=new XMLHttpRequest();
        xhr.onload=function () {
            if(xhr.status>=200&&xhr.status<300||xhr.status==304){
                alert(xhr.responseText);
                var json=JSON.parse(xhr.responseText);
                if (json.flag=="success") {
                    alert("修改成功");
                }
                else if(json.flag=="fail_1"){
                    alert("原密码错误");
                }else if(json.flag=="fail_2"){
                    alert("两次输入的新密码不一致");
                }
                
            }else{
                alert("失败");
            }
        }
        var form = document.getElementById("setPass");
        var formData = new FormData(form);
        xhr.open("post","stuPass",false);
        xhr.send(formData);
    });
}
$(document).ready(setPassword);