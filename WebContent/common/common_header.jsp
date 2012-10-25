<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>信息</title>
<link rel="stylesheet" type="text/css" href="css/index.css">
<link rel="stylesheet" type="text/css" href="css/product.css">
<link rel="stylesheet" type="text/css" href="css/showSP.css">
<link rel="stylesheet" type="text/css" href="css/cart.css">
<link rel="stylesheet" type="text/css" href="css/buy.css">
<script type="text/javascript" src="js/jquery.js" charset="utf-8"></script>
<script type="text/javascript"  src="js/index_pictureshow.js" charset="utf-8"></script>
<script type="text/javascript" src="js/index.js" charset="utf-8"></script>
<script type="text/javascript" src="js/cart.js" charset="utf-8"></script>
<script type="text/javascript" src="js/productShow.js" charset="GBK" ></script>
</head>
<body>
	<div class="top">
		<ul class="t">
			<li>亲，欢迎来淘宝！</li>
			<li>请<a href="login1.jsp">登录</a></li>
			<li><a href="logon.jsp">免费注册</a></li>
			<li>收藏本站</li>
		</ul>
		<c:if test="${null!=sessionScope.userAccount}">
		<ul class="r">
			<li class="first"><a href="/SuperMarket/bookinfo">我的订单</a></li>
			<li><a href="/SuperMarket/cart.jsp">我的购物车</a></li>
			<li><a href="/SuperMarket/GetBuyGoods">我买的商品</a></li>
		</ul>
		</c:if>
	</div>
	<div class="main">
		<div class="header">
			<div class="c-header">
				<a href="/SuperMarket/IndexInfoGet"><div class="logo">
				</div></a>
				<div class="search">
					<div class="input-s">
						<form action="" method="post">
							<input type="text" name="keyword" class="search-i" value="" />
							<input type="submit" value="搜索" class="search-b" />
						</form>
					</div>
					<div class="keyword">
					<p>搜索热词:</p>
						<ul>
							<li><a href="/SuperMarket/ProductInfo?pname=iphone4s">iphone4s</a></li>
							<li><a href="/SuperMarket/ProductInfo?pname=galaxy2">galaxy2</a></li>
							<li><a href="/SuperMarket/ProductInfo?pname=meizuM9">meizuM9</a></li>
							<li><a href="/SuperMarket/ProductInfo?pname=lumia800">lumia800</a></li>
							<li><a href="/SuperMarket/ProductInfo?pname=huawei8860">huawei</a></li>
							<li><a href="/SuperMarket/ProductInfo?pname=sonymt15">sonymt15</a></li>
						</ul>
					</div>
				</div>
				<div class="two">
				<div class="myMarket bac-normal">
					<div class="img"></div>
					<p>我的商城</p>
					<div class="trangle  border_color_black "></div>
				</div>
				<div class="cart">
					<a href="/SuperMarket/cart.jsp">去购物车结算</a>
					<div class="trangle border_color_black"></div>
				</div>
				</div>
				<div class="tool">
				<div class="header"></div>
					<ul>
						<li></li>
						<li></li>
						<li></li>
						<li></li>
					</ul>
				</div>
				<div class="navigation">
					<p class="product-nav">商品导航</p>
					<ul class="nav">
						<li class="con"><a href="/SuperMarket/IndexInfoGet">首页</a></li>
						
						<li class="con"><a href="/SuperMarket/ShowSelectProducts?location=JK">日韩馆</a></li>
						
						<li class="con"><a href="/SuperMarket/ShowSelectProducts?location=EA">欧美馆</a></li>
						
						<li class="con"><a href="/SuperMarket/ShowSelectProducts?location=C">中国馆</a></li>
					
						<li class="con">帮助</li>
					</ul>
				</div>
			</div>
		</div>
	</div>