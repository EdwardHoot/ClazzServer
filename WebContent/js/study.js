$(function () {
    $('#user').html(sessionStorage.getItem("username"));
    var path = window.location.pathname;
    if(path.indexOf("study")>0){
       $("#study").addClass("active");
       $("#scholar").removeClass('active');
    }
    else{
       $("#scholar").addClass("active");
       $("#study").removeClass('active');
    }
})
function allFile(){
        var xhr=new XMLHttpRequest();
        xhr.onload=function () {
            if(xhr.status>=200&&xhr.status<300||xhr.status==304){
                var json=JSON.parse(xhr.responseText);
                var length=json.array.length;
                for(var i=0;i<length;i++){
                	str=$("<tr><td>"+json.array[i].name+"</td><td>"+json.array[i].type+
                		"</td><td>"+json.array[i].dateTime+"</td></tr>");
                	$("#file").prepend(str);
                }
                //var str=$("<p>标题："+json.title+"</p><P>内容："+json.content+"</p>")
            }else{
                alert("失败");
            }
        }
        xhr.open("post","fileAction",false);
        xhr.send();
}
function upLoad() {
    $('#upload').click(function (event) {
    	//event.preventDefault();
        var xhr=new XMLHttpRequest();
        xhr.onload=function () {
            if(xhr.status>=200&&xhr.status<300||xhr.status==304){
               // alert(xhr.responseText);
                var json=JSON.parse(xhr.responseText);
                if (json.flag=="success") {
                    alert("上传成功！");
                }
                else{
                    alert("上传失败！");
                }
            }else{
                alert("失败");
            }
        }
        xhr.open("post","uploadAction",false);
        var form = document.getElementById("f1");
        var formdata = new FormData(form);
        xhr.send(formdata);
    });
}
$(document).ready(allFile);
$(document).ready(upLoad);
