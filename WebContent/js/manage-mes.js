$(function () {
	   $('#user').html(sessionStorage.getItem("username"));
	   var path = window.location.pathname;
       if(path.indexOf("manage-history-mes")>0){
       $("#manage-history-mes").addClass("active");
       $("#manage-mes").removeClass('active');
    }
    else{
       $("#manage-mes").addClass("active");
       $("#manage-history-mes").removeClass('active');
    }
})
function addNotice() {
	$('#publish').click(function () {
        var xhr=new XMLHttpRequest();
        xhr.onload=function () {
            if(xhr.status>=200&&xhr.status<300||xhr.status==304){
                alert(xhr.responseText);
                var json=JSON.parse(xhr.responseText);
                if (json.flag=="success") {
                    alert("发布成功");
                }
                else{
                    alert("修改失败，请重新输入");
                }
            }else{
                alert("失败");
            }
        }
        xhr.open("post","addClzNotice",false);
        var form = document.getElementById("addMes");
        var formData = new FormData(form);
        xhr.send(formData);
    });
}
$(document).ready(addNotice);