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
function getUserInfo(){
  $('#user').html(sessionStorage.getItem("username"));
        var xhr=new XMLHttpRequest();
        xhr.onload=function () {
            if(xhr.status>=200&&xhr.status<300||xhr.status==304){
                var json=JSON.parse(xhr.responseText);
                var length=json.array.length;
                for(var i=0;i<length;i++){
                  str=$("<tr><td>"+json.array[i].number+"</td><td>"+json.array[i].name+
                    "</td><td>"+json.array[i].major+"</td><td>"+json.array[i].sex+"</td><td>"+
                        json.array[i].office+"</td><td>"+json.array[i].tel+"</td><td>"+json.array[i].email+
                        "</td><td>"+json.array[i].birth+"<td></tr>");
                  $("#allTeacher").prepend(str);
                }
                //var str=$("<p>标题："+json.title+"</p><P>内容："+json.content+"</p>")
            }else{
                alert("失败");
            }
        }
        xhr.open("post","teacherAll",false);
        xhr.send();
}
$(document).ready(getUserInfo);