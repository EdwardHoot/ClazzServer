$(function () {
    $("#login").click(function (event) {
        event.preventDefault();
        var xhr=new XMLHttpRequest();
        xhr.onload=function(){
                if(xhr.status>=200&&xhr.status<300||xhr.status==304){
                    var json=JSON.parse(xhr.responseText);
                    if(json.flag=="fail"){
                        alert("用户名或密码错误");
                    }else if (json.flag=="student"){
                        window.open("information.html","_self");
                    }else if(json.flag=="teacher"){
                        window.open("manage-info.html","_self");
                    }
                }
            }
        xhr.open("post","login",false);
        var form=new FormData(document.getElementById("loginForm"));
        xhr.send(form);
        sessionStorage.setItem("username",$("#username").val());
        sessionStorage.setItem("password",$("#password").val());
    })
})