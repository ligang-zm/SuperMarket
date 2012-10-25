
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>welcome</title>
<link href="css/mycss.css" rel="stylesheet" type="text/css">
<style type="text/css">
 .btn{
 width:180px;
   height:35px;
   background:orange;
   font-size:20px;
   font-family:Microsoft Jhenghei;  
    font--weight:bold;
    border-style:hidden;
    cursor:pointer;
     /*firefox设置圆角*/
     -moz-border-radius:5px;
     /*safari 等其他Webkit核心浏览器 设置圆角*/
     -webkit-border-radius:5px;
     /*其他浏览器例如Opera IE9+等*/
      border-radius:5px;     
 }
 .btn:hover{
 background:-webkit-gradient(linear,0% 0%,0% 100%,from(orange),to(darkorange));
      background:-moz-linear-gradient(top,orange,darkorange);/*firefox浏览器*/
 }
 .btn.active{
 background-color:orange;
 }
</style>
</head>
<body>
<center>
   <h1>注册成功</h1>
 <a href="login1.jsp"><input type="button"class="btn"value="进入登录页面"></a>  
   </center>
</body>
</html>