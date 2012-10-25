<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录商城</title>
<link href="css/mycss.css" rel="stylesheet" type="text/css">
<style type="text/css">
 
 
</style>
</head>
<body>
  <div></div>
  <div></div>
  <div id="divtop">
    <ul class="t">
			<li>亲，欢迎来淘宝！</li>
			<li>可<a href="logon.jsp">免费注册</a></li>
			<li>收藏本站</li>
	</ul>
	<c:if test="${null!=sessionScope.userAccount}">
		<ul class="r">
			<li class="first"><a href="">我的订单</a></li>
			<li><a href="/SuperMarket/cart.jsp">我的购物车</a></li>
			<li><a href="">我的信息</a></li>
			<li></li>
		</ul>
		</c:if>
  </div>
  <div><h2 id="top">用户登录</h2></div>
  <form action="login" method="post">
  <table style="margin-left:50px;">
  <tr style="height:300px;">
  <td style="width:700px;background-color:#f1f1f1;">
  <div class="div1">用户名：<input type="text" class="txt"name="acname"></div>
  <div class="div1">密码：<input type="password" class="txtpwd"name="password"><a href="forget.jsp">忘记密码？</a>
  </div>
  <div class="div2"> <input type="submit" value="登录"class="btn">&nbsp;&nbsp;&nbsp;&nbsp;<input type="reset" value="重置"class="btn"></div></td>
  <td style="width:650px;">
    <div style="margin-left:150px;"><img src="img/0030.jpg"></div>
    <div style="height:30px;width:500px;margin-left:150px;font-size:30px;font-face:Microsoft Jhenghei;margin-top:30px;">还不是商城用户</div>
    <div style="height:30px;width:410px;margin-left:150px;margin-top:10px;font-face:Microsoft Jhenghei;font-size:20px;">现在免费注册成为商城用户，便能立刻享受便宜又放心的购物乐趣。</div>
    <div style="height:30px;margin-left:260px;margin-top:40px;"><a href="logon.jsp"><b><font style="font-face:Microsoft Jhenghei;font-size:40px;">注册新用户</font></b></a></div>
    
  </td>
  </tr>
    
  </table>
  </form>
</body>
</html>