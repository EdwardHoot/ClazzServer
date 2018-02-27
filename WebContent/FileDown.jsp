<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'FileDown.jsp' starting page</title>
  </head>
  
  <body>
    第五次作业：<a href="<%=path %>/downloadAction.action?number=1">点击下载</a></br>
    第六次作业：<a href="<%=path %>/downloadAction.action?number=2">点击下载</a></br>
    <a href="<%=path %>/File.jsp">返回</a>
  </body>
</html>
