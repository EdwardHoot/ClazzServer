$(function () {
    $('#user').html(sessionStorage.getItem("username"));
       var path = window.location.pathname;
       if(path.indexOf("search")>0){
       $("#search").addClass("active");
       $("#stu").removeClass('active');
    }
    else{
       $("#stu").addClass("active");
       $("#search").removeClass('active');
    }
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
function addShip(){
      $('#add_scholar').click(function () {
        var xhr=new XMLHttpRequest();
        xhr.onload=function () {
            if(xhr.status>=200&&xhr.status<300||xhr.status==304){
                var json=JSON.parse(xhr.responseText);
                  if(json.flag=="success"){
                    alert("添加成功");
                  }else{
                    alert("添加失败");
                  }
            }else{
                alert("失败");
            }
        }
        xhr.open("post","addScholarship",false);
        var form = document.getElementById("add_ship");
        var formData = new FormData(form);
        xhr.send(formData);
      })
}
function delShip(){
      $('#del_scholar').click(function () {
        var xhr=new XMLHttpRequest();
        xhr.onload=function () {
            if(xhr.status>=200&&xhr.status<300||xhr.status==304){
                var json=JSON.parse(xhr.responseText);
                  if(json.flag=="success"){
                    alert("删除成功");
                  }else{
                    alert("删除失败");
                  }            
            }else{
                alert("失败");
            }
        }
        xhr.open("post","deleteScholarship",false);
        var form = document.getElementById("del_ship");
        var formData = new FormData(form);
        xhr.send(formData);
      })
}
function addStu(){
      $('#add_stu').click(function () {
        var xhr=new XMLHttpRequest();
        xhr.onload=function () {
            if(xhr.status>=200&&xhr.status<300||xhr.status==304){
                var json=JSON.parse(xhr.responseText);
                  if(json.flag=="success"){
                    alert("评奖成功");
                  }else{
                    alert("评奖失败");
                  }            
            }else{
                alert("失败");
            }
        }
        xhr.open("post","awards",false);
        var form = document.getElementById("add_student");
        var formData = new FormData(form);
        xhr.send(formData);
      })
}
$(document).ready(allShip);
$(document).ready(addShip);
$(document).ready(delShip);
$(document).ready(addStu);