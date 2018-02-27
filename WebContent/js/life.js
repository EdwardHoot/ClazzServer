$(function () {
    $('#user').html(sessionStorage.getItem("username"));
    var path = window.location.pathname;
       if(path.indexOf("life_Money")>0){
       $("#lifeMoney").addClass("active");
       $("#life").removeClass('active');
    }
    else{
       $("#life").addClass("active");
       $("#lifeMoney").removeClass('active');
    }
})
function boardInfo() {
    $(function () {
        var xhr=new XMLHttpRequest();
        xhr.onload=function () {
            if(xhr.status>=200&&xhr.status<300||xhr.status==304){
                var json=JSON.parse(xhr.responseText);
                var length=json.array.length;
                for(var i=0;i<length;i++){
                	str=$("<div><p>标题:"+json.array[i].title+"</p><i>发布时间："+json.array[i].dateTime+
                		"</i><em>发布人："+json.array[i].author+"</em><p>内容："+json.array[i].content+"</p></div>");
                	$("#info-body").prepend(str);
                }
                //var str=$("<p>标题："+json.title+"</p><P>内容："+json.content+"</p>")
            }else{
                alert("失败");
            }
        }
        xhr.open("post","message",false);
        xhr.send();
    })
}
function addBoard() {
    $('#leaveMes').click(function (event) {
    	//event.preventDefault();
        var xhr=new XMLHttpRequest();
        xhr.onload=function () {
            if(xhr.status>=200&&xhr.status<300||xhr.status==304){
            	alert("tianjiachenggong");
                $("#info-body").children().remove();
                var json=JSON.parse(xhr.responseText);
                if (json.flag=="success") {
                    alert("留言成功");
                }
                else{
                    alert("留言失败，请重新输入");
                }
            }else{
                alert("失败");
            }
        }
        var form = document.getElementById("add_mess");
        var formdata = new FormData(form);
        xhr.open("post","addMessage",false);
        xhr.send(formdata);
    });
}
function delBoard() {
    $('#delMes').click(function (event) {
    	//event.preventDefault();
        var xhr=new XMLHttpRequest();
        xhr.onload=function () {
            if(xhr.status>=200&&xhr.status<300||xhr.status==304){
               // alert(xhr.responseText);
                var json=JSON.parse(xhr.responseText);
                if (json.flag=="success") {
                    alert("成功删除该条留言");
                }
                else{
                    alert("删除失败，请重新输入该留言标题");
                }
            }else{
                alert("失败");
            }
        }
        xhr.open("post","deleteMessage",false);
        var form = document.getElementById("del_mess");
        var formdata = new FormData(form);
        xhr.send(formdata);
    });
}
function fee(){
	$(function () {
        var xhr=new XMLHttpRequest();
        xhr.onload=function () {
            if(xhr.status>=200&&xhr.status<300||xhr.status==304){
                var json=JSON.parse(xhr.responseText);
                var length=json.array.length;
                for(var i=0;i<length;i++){
                	str=$("<tr><td>"+json.array[i].title+"</td><td>"+json.array[i].income+
                		"</td><td>"+json.array[i].instate+"</td><td>"+json.array[i].output+"</td><td>"+
                		json.array[i].outstate+"</td><td>"+json.array[i].newTotal+"<td></tr>");
                	$("#fee").prepend(str);
                }
                //var str=$("<p>标题："+json.title+"</p><P>内容："+json.content+"</p>")
            }else{
                alert("失败");
            }
        }
        xhr.open("post","fee",false);
        xhr.send();
    })

}
$(document).ready(boardInfo);
$(document).ready(addBoard);
$(document).ready(delBoard);
$(document).ready(fee);