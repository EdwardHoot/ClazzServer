<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'Upload.jsp' starting page</title>

  </head>
  
  <body>
  		<form name="f1" id="f1" action="uploadAction" method="post" enctype="multipart/form-data">
  			<table border="0">
  				<tr>
					<td>type</td>
					<td><input type="text" name="type" id="login"></td>
				</tr>
				<tr>
					<td>File</td>
					<td><input type="file" name="upload" id="login"></td>
				</tr>
				
				<tr>
					<td colspan="2" align="center"><input type="submit"></td>
				</tr>	
  			</table>
  		</form>
  </body>
</html>
