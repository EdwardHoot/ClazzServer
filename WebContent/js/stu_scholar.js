$(function () {
    var path = window.location.pathname;
    if(path.indexOf("study")>0){
       $("#study").addClass("active");
       $("#scholar").removeClass('active');
    }
    else{
       $("#scholar").addClass("active");
       $("#study").removeClass('active');
    }
    $('#user').html(sessionStorage.getItem("username"));
})
function allShip(){
    $(function () {
        var xhr=new XMLHttpRequest();
        xhr.onload=function () {
            if(xhr.status>=200&&xhr.status<300||xhr.status==304){
                var json=JSON.parse(xhr.responseText);
                var length=json.array.length;
                for(var i=0;i<length;i++){
                  var stu_length = json.array[i].student.length;
                  var str2="";
                    for(var j =0;j<stu_length;j++)
                    {
                      str2=str2+json.array[i].student[j]+" ";
                    }
                 str=$("<tr><td>"+json.array[i].name+"</td><td>"+json.array[i].content+
                 "</td><td>"+json.array[i].state+"</td><td>"+json.array[i].dateTime+"</td><td>"+
                 str2+"</td></tr>");
                  $("#shipAll").prepend(str);
                }
        }else{
                alert("失败");
            }
        }
        xhr.open("post","scholarshipAll",false);
        xhr.send();
    })
}
$(document).ready(allShip);