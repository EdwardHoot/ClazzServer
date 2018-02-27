function addSuperNotice() {
    var path = window.location.pathname;
    if(path.indexOf("history")>0){
       $("#historyMes").addClass("active");
       $("#userInfo").removeClass("active");
       $("#publishMes").removeClass("active");
    }
    else if(path.indexOf("userInfo")>0){
        $("#userInfo").addClass("active");
       $("#publishMes").removeClass("active");
       $("#historyMes").removeClass("active");
    }else{
       $("#publishMes").addClass("active");
       $("#userInfo").removeClass("active");
       $("#historyMes").removeClass("active");
    }
	$('#publish').click(function () {
        var xhr=new XMLHttpRequest();
        xhr.onload=function () {
            if(xhr.status>=200&&xhr.status<300||xhr.status==304){
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
        xhr.open("post","addSystem",false);
        var form = document.getElementById("addMes");
        var formData = new FormData(form);
        xhr.send(formData);
    });
}
$(document).ready(addSuperNotice);