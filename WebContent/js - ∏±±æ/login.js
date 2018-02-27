$(function () {
    $("#login").click(function (event) {
        event.preventDefault();
        var xhr=new XMLHttpRequest();
        xhr.onload=function(){
                if(xhr.status>=200&&xhr.status<300||xhr.status==304){
                    var json=JSON.parse(xhr.responseText);
                    if(json.flag=="fail"){
                        alert("用户名或密码错误");
                    }
                    else{
                        var al=$("input[name='authority']:checked").val();
                        if($(al=="学生")){
                            alert("欢迎登陆！");
                            window.open("information.html","_self");
                        }
                        else{
                            alert("管理员");
                            window.open("manage-info.html","_self");
                        }
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

//         var xhr;
//         if(window.XMLHttpRequest){
//             xhr = new XMLHttpRequest();
//         }else if(window.ActiveXObject){
//             xhr = new window.ActiveXObject();
//         }else{
//             alert("请升级至最新版本的浏览器");
//         }
//         if(xhr !=null){
//             xhr.open("POST","login",false);//我也遇到这个问题了，这个只是一个友好的提醒，在主线程上用同步的请求，会导致阻塞，必须得等到请求完毕并且有了返回(正确或错误),才能执行后面的代码，用户体验来说，就是卡了啊，这种就会出现在这种友好的提示，不过，我的场景就是要使用同步的请求方式。
//             var form=new FormData(document.getElementById("loginForm"));
// //                form.append("username","hupeng");
// //                form.append("password","123456");
//             xhr.send(form);
//              sessionStorage.setItem("username",$("#username").val());
//              sessionStorage.setItem("password",$("#password").val());
//             //这里面有2个概念。
//             //一个是Ajax请求分异步和同步2种模式。如果请求是同步的，在请求返回之前线程会一直阻塞，如果请求是在主线程中发起的，那就会造成整个浏览器阻塞。
// //另外一个就是主线程。这段话应该是针对HTML5说的，因为在HTML5以前，JavaScript是完全的单线程方式，主线程之外不存在其他线程。但在HTML5中增加了Worker对象，每个Worker运行在一个独立的线程中，Worker线程被阻塞一般是不会影响主线程和浏览器的。因此，如果非要使用同步的Ajax（这种情况应该很少见），那就放到Worker线程中吧，千万千万不要放到主线程里。

//             xhr.onload=function(){
//                 if(xhr.status>=200&&xhr.status<300||xhr.status==304){
//                     var json=JSON.parse(xhr.responseText);
//                     alert(json.flag);
//                     if(json.flag=="fail"){
//                         alert("用户名或密码错误");
//                     }
//                     else{
//                         var al=$("input[name='authority']:checked").val();
//                         alert(al);
//                         if($(al=="学生")){
//                             alert("欢迎登陆！");
//                             window.open("information.html","_self");
//                         }
//                         else{
//                             alert("管理员");
//                             window.open("manage-info.html","_self");
//                         }
//                     }
//                 }
//             }
//         }

