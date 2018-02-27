$(function () {
    $('#user').html(sessionStorage.getItem("username"));
})
function activity(){
        var xhr=new XMLHttpRequest();
        xhr.onload=function () {
            if(xhr.status>=200&&xhr.status<300||xhr.status==304){
                var json=JSON.parse(xhr.responseText);
                var length=json.array.length;
                for(var i=0;i<length;i++){
                	str=$("<tr><td>"+json.array[i].title+"</td><td>"+json.array[i].type+
                		"</td><td>"+json.array[i].content+"</td><td>"+json.array[i].dateTime+"<td></tr>");
                	$("#activities").prepend(str);
                }
                //var str=$("<p>标题："+json.title+"</p><P>内容："+json.content+"</p>")
            }else{
                alert("失败");
            }
        }
        xhr.open("post","activity",false);
        xhr.send();
}
$(document).ready(activity);