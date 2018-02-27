function displayMes() {
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
        xhr.send();
    })
}
$(document).ready(displayMes);