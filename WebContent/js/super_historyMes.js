$(function () {
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
})
function getMesInfo() {
    $(function () {
        var xhr=new XMLHttpRequest();
        xhr.onload=function () {
            if(xhr.status>=200&&xhr.status<300||xhr.status==304){
                var json=JSON.parse(xhr.responseText);
                var length=json.array.length;
                for(var i=0;i<length;i++){
                	str=$("<div><p>标题:"+json.array[i].title+"</p><i>发布时间："+json.array[i].dateTime+
                		"</i><p>内容："+json.array[i].content+"</p></div>");
                    $("#info-body").prepend(str);
                }
                //var str=$("<p>标题："+json.title+"</p><P>内容："+json.content+"</p>")

            }else{
                alert("失败");
            }
        }
        xhr.open("post","system",false);
       // form.append("username","hupeng");
      //  form.append("password","123456");
        xhr.send();
    })
}
$(document).ready(getMesInfo);