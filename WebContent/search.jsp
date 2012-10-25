<%@page import="com.lg.entity.Goods1"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@include file="common.jsp" %>
    <%@page import="java.util.Collection,java.util.Iterator" %>
    <jsp:useBean id="smartupload" class="org.lxh.smart.SmartUpload"/>
    <%@taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="common/common_header.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>欢迎光临网上商城</title>
</head>
<body>
 <%
	request.setCharacterEncoding("UTF-8");
	response.setCharacterEncoding("UTF-8");

  String strKeyword=request.getParameter("keyword");
  if(null==strKeyword||strKeyword.equals("")){
  response.sendRedirect("catalog.jsp");
  return;
  }
  Collection cl=shopping.searchgoods(strKeyword);
  if(cl.size()<0){
  out.println("没有符合搜索要求的商品");
  out.println("<a href=\"main.jsp\">返回</a>");
  return;
  }
  %>
  <div class="show1">
	<div class="show1-left">
		<ul>
			<li class="nav-sp">品牌导航</li>
			<li><a href="/buyweb/InfoByBrand?brand=apple"><div class="brand-c"><div class="logo"><img src="img/Apple_logo.jpg" height="40"/></div><div class="brand-text">苹果</div></div></a></li>
			<li><a href="/buyweb/InfoByBrand?brand=htc"><div class="brand-c"><div class="logo"><img  class="mini" src="img/HTC_logo_mini.jpg" /></div><div class="brand-text">HTC</div></div></a></li>
			<li><a href="/buyweb/InfoByBrand?brand=samsung"><div class="brand-c"><div class="logo"><img  class="mini" src="img/samsung_logo_mini.jpg" /></div><div class="brand-text">三星</div></div></a></li>
			<li><a href="/buyweb/InfoByBrand?brand=lenovo"><div class="brand-c"><div class="logo"><img  class="mini" src="img/lenovo_logo_mini.jpg" /></div><div class="brand-text">联想</div></div></a></li>
			<li><a href="/buyweb/InfoByBrand?brand=moto"><div class="brand-c"><div class="logo"><img  class="mini" src="img/moto_logo_mini.jpg" /></div><div class="brand-text">摩托</div></div></a></li>
			<li><a href="/buyweb/InfoByBrand?brand=nokia"><div class="brand-c"><div class="logo"><img  class="mini" src="img/Nokia_logo_mini.jpg" /></div><div class="brand-text">诺基亚</div></div></a></li>						
			<li><a href="/buyweb/InfoByBrand?brand=meizu"><div class="brand-c"><div class="logo"><img  class="mini" src="img/MEIZU_logo_mini.jpg" /></div><div class="brand-text">魅族</div></div></a></li>
			<li><a href="/buyweb/InfoByBrand?brand=sony"><div class="brand-c"><div class="logo"><img  class="mini" src="img/sony _logo_mini.jpg" /></div><div class="brand-text">索尼</div></div></a></li>
			<li><a href="/buyweb/InfoByBrand?brand=sharp"><div class="brand-c"><div class="logo"><img   src="img/SHARP_logo.jpg"  class="sharp" height="40"/></div><div class="brand-text">夏普</div></div></a></li>			
		</ul>
	</div>
	<div class="condition">
		<div class="choice">&nbsp;&nbsp;&nbsp;&nbsp;商品筛选</div>
		<div class="sl">
		   <ul>
		   	<li class="header">网络:</li>
		   	<li><a href="">不限</a></li>
		   	<li><a href="/buyweb/InfoByNet?net=联通3G">联通3G</a></li>
		   	<li><a href="/buyweb/InfoByNet?net=电信3G">电信3G</a></li>
		   	<li><a href="/buyweb/InfoByNet?net=移动3G">移动3G</a></li>
		   	<li><a href="/buyweb/InfoByNet?net=GSM">GSM</a></li>
		   	<li><a href="/buyweb/InfoByNet?net=CDMA">CDMA</a></li>
		   </ul>
		</div>
		<div class="sl">
			<ul>
			<li class="header">品牌:</li>
			 <li>不限</li>   
			 <li><a href="/buyweb/InfoByBrand?brand=htc">HTC</a></li>
			 <li><a href="/buyweb/InfoByBrand?brand=samsung">三星</a></li>
			 <li><a href="/buyweb/InfoByBrand?brand=apple">苹果</a></li>
			 <li><a href="/buyweb/InfoByBrand?brand=meizu">魅族</a></li>
			 <li><a href="/buyweb/InfoByBrand?brand=nokia">诺基亚</a></li>
			 <li><a href="/buyweb/InfoByBrand?brand=sony">索尼</a></li>
			</ul>
		</div>
		<div class="sl">
			<ul>
			 <li class="header">价格:</li>
			 <li>不限</li>
             <li><a href="/buyweb/InfoByPrice?price=1-499">1-499</a></li>
			 <li><a href="/buyweb/InfoByPrice?price=500-999">500-999</a></li>
			 <li><a href="/buyweb/InfoByPrice?price=1000-1999">1000-1999</a></li>
			 <li><a href="/buyweb/InfoByPrice?price=2000-2999">2000-2999</a></li>
			 <li><a href="/buyweb/InfoByPrice?price=3000-3999">3000-3999</a></li>
			 <li><a href="/buyweb/InfoByPrice?price=4000-4999">4000-4999</a></li>
			 <li><a href="/buyweb/InfoByPrice?price=>4999">>4999</a></li>
			</ul>
		</div>
		<div class="sl">
			<ul>
				<li class="header">系统:</li>
				<li><a href="">不限</a></li>
				<li><a href="/buyweb/InfoByOs?os=Android">Android</a></li>
				<li><a href="/buyweb/InfoByOs?os=IOS">IOS</a></li>
				<li><a href="/buyweb/InfoByOs?os=WindowPhone">WindowPhone</a></li>
				<li><a href="/buyweb/InfoByOs?os=Symbian">Symbian</a></li>
				<li><a href="/buyweb/InfoByOs?os=BlackBarry OS">BlackBarry OS</a></li>
	            <li><a href="/buyweb/InfoByOs?os=Palm OS">Palm OS</a></li>
			</ul>
		</div>
	</div>
	<div>
	
</div>
	 <div class="show1-right">
	  <%
    Iterator it=cl.iterator();
    while(it.hasNext()){
    Goods1 goods=(Goods1)it.next();
    String gimage=goods.getGimage();
    String gname=goods.getGname();
    int gid=goods.getGid();
    Double gprice=goods.getGprice();
     %>
		<div class="p1-show">
			<div class="p-img">
			  <img src="<%=gimage %>" width="160px" height="160px"/>
			</div>
			<div class="p-desc">
			    <div><a href="/buyweb/servlet/ProductInfo?gname=<%=gname %>"><%=gname %></a></div>
			    <div>价格：<%=gprice %></div>
			    <div class="p-buy"><a href="/buyweb/servlet/Cart?gname=<%=gname %>">购买</a></div>
			</div>
		</div>
		<%
    }
		%>
	</div> 
</div>
<%@include file="common/common_bottom.jsp" %>
</body>
</html>