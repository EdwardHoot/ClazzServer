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
function search_stu(){
      $('#CSS-search').click(function (event) {
        event.preventDefault();
        var xhr=new XMLHttpRequest();
        xhr.onload=function () {
            if(xhr.status>=200&&xhr.status<300||xhr.status==304){
                var json=JSON.parse(xhr.responseText);
                  str=$("<tr><td>"+json.number+"</td><td>"+json.name+
                    "</td><td>"+json.clazz+"</td><td>"+json.major+"</td><td>"+
                        json.sex+"</td><td>"+json.tel+"</td><td>"+json.email+
                        "</td><td>"+json.birth+"<td></tr>");
                  $("#stuAll").prepend(str);
            }else{
                alert("失败");
            }
        }
        xhr.open("post","stuSearch",false);
        var form = document.getElementById("search-stu");
        var formData = new FormData(form);
        xhr.send(formData);
      })
}
$(document).ready(search_stu);