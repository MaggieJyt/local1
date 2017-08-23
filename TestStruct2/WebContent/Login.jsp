<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>  
<%  
String path = request.getContextPath();  
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";  
%>  
<html>  
  <head>  
  </head>  
    <body>  
  <form action="LoginAction.action">  
   <input type="text" name="username"/><br/>  
   <input type="password" name="password"/><br/>  
   <input type="submit" value="提交"/>  
   </form>  
  </body>  
</html>  
