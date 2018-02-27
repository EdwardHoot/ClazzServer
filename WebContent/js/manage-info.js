$(function () {
	$('#user').html(sessionStorage.getItem("username"));
    var path = window.location.pathname;
    if(path.indexOf("teacherPass")>0){
       $("#stuPass").addClass("active");
       $("#infomation").removeClass('active');
    }
    else{
       $("#infomation").addClass("active");
       $("#stuPass").removeClass('active');
    }
    $('#user').html(sessionStorage.getItem("username"));
    $('.info-edit').hide();//jquery中的hide方法与CSS中的visibility的hide类似，而diplay和visibility隐藏元素的方法是不一样的
    $('#edit').click(function (event) {
        event.preventDefault();//当在IE浏览器下面时，button标签按钮，input标签type属性为button的按钮是一样的功能，不会对表单进行任何操作。
        //但是在W3C浏览器，如Firefox下就需要注意了，button标签按钮会提交表单，所以我们要祖师他的默认行为-提交表单
        // 而input标签type属性为button不会对表单进行任何操作。
        if($('.info-edit').is(':hidden')){//如果当前隐藏
            $('.info-edit').show();//那么就显示
        }else{//否则
            $('.info-edit').hide();//就隐藏
        }
    });
    $('#sub').click(function () {
        $('.info-edit').hide();
    });
})
function getInfo() {
    $(function () {
        var xhr=new XMLHttpRequest();
        xhr.onload=function () {
            if(xhr.status>=200&&xhr.status<300||xhr.status==304){
                var json=JSON.parse(xhr.responseText);
                $('#number').html(json.number);
                $('#major').html(json.major);
                $('#name').html(json.name);
                $('#office').html(json.office);
                $('#tel').html(json.tel);
                $('#email').html(json.email);
                $('#sex').html(json.sex);
                $('#birth').html(json.birth);
            }else{
                alert("失败");
            }
        }
        xhr.open("post","teacher",false);
        var get_name=sessionStorage.getItem("username");
        var get_password=sessionStorage.getItem("password");
        var form=new FormData();
        form.append("username",get_name);
        form.append("password",get_password);
       // form.append("username","hupeng");
      //  form.append("password","123456");
        xhr.send(form);
    })
}
function setInfo() {
    $('#sub').click(function (event) {
        var xhr=new XMLHttpRequest();
        xhr.onload=function () {
            if(xhr.status>=200&&xhr.status<300||xhr.status==304){
                var json=JSON.parse(xhr.responseText);
                if(json.flag=="success"){
                	alert("修改成功！");
                }
            }else{
                alert("失败");
            }
        }
        xhr.open("post","teacherInfo",false);
        var form = document.getElementById("teacher-info");
        var formData = new FormData(form);
        xhr.send(formData);
    })
}
$(document).ready(getInfo);
$(document).ready(setInfo);