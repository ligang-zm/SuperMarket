<%@page import="com.lg.entity.UserAccount"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.lg.entity.Goods"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>淘宝网首页</title>
<link rel="stylesheet" type="text/css" href="css/index.css">
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript"  src="js/index_pictureshow.js"></script>
<script type="text/javascript" src="js/index.js"></script>
<script type="text/javascript"> 
function djs(SysSecond,fn){
	 var InterValObj; 
	 var ldate = new Date(SysSecond);
	 var currDate=new Date();
	 var result=ldate.getTime()-currDate.getTime();
	 var SysSecond1=result/1000;
	 //将时间减去1秒，计算天、时、分、秒 
	 InterValObj = window.setInterval(function(){ 
	  if (SysSecond1 > 0) { 
	   var second = Math.floor(SysSecond1 % 60);             // 计算秒     
	   var minite = Math.floor((SysSecond1 / 60) % 60);      //计算分 
	   var hour = Math.floor((SysSecond1 / 3600) % 24);      //计算小时 
	   var day = Math.floor((SysSecond1 / 3600) / 24); 		//计算天 
	   SysSecond1 = SysSecond1 - 1;        
	   var msg=day + "天" + hour + "小时" + minite + "分" + second + "秒";
	  	fn(msg); 
	  } else {//剩余时间小于或等于0的时候，就停止间隔函数 
	   window.clearInterval(InterValObj);
	   fn("限时抢购结束");
	   //这里可以添加倒计时时间为0后需要执行的事件 
	  } 
	 },1000); 
	}
</script> 
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
						<form action="/SuperMarket/search.jsp" method="post">
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
				<%!String img=""; %>
				<%
				if(null!=session.getAttribute("img")){
				 img=(String)session.getAttribute("img");
				}
				%>
				
				<div class="two">
				<div class="myMarket bac-normal">
					<div class="img"><img src="upload/<%=img%>" width="40" height="40"/></div>
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
						
						<li class="con"><a href="/SuperMarket/ShowSelectProducts?location=JK" target="_blank">日韩馆</a></li>
						
						<li class="con"><a href="/SuperMarket/ShowSelectProducts?location=EA" target="_blank">欧美馆</a></li>
					    <li class="con"><a href="/SuperMarket/ShowSelectProducts?location=C" target="_blank">中国馆</a></li>    	
					
						<li class="con">帮助</li>
					</ul>
				</div>
			</div>
		</div>
		<div class="select">
			<ul class="select-kind">
				<li class="line"><a href="/SuperMarket/InfoByBrand?brand=apple">苹果</a></li>
				<li class="line"><a href="/SuperMarket/InfoByBrand?brand=samsung">三星</a></li>
				<li class="line"><a href="/SuperMarket/InfoByBrand?brand=lenovo">联想</a></li>
				<li class="line"><a href="/SuperMarket/InfoByBrand?brand=sony">索尼</a></li>
				<li class="line"><a href="/SuperMarket/InfoByBrand?brand=huawei">华为</a></li>
				<li class="line"><a href="/SuperMarket/InfoByBrand?brand=meizu">魅族</a></li>				
				<li class="line"><a href="/SuperMarket/InfoByBrand?brand=sharp">夏普</a></li>
				<li class="line"><a href="/SuperMarket/InfoByBrand?brand=nokia">诺基亚</a></li>
				<li><a href="/SuperMarket/InfoByBrand?brand=moto">摩托罗拉</a></li>
				
			</ul>
		</div>
		
		<div id="banner">        
			<div id="banner_bg"></div>  <!--标题背景-->    
			<div id="banner_info">
			</div> <!--标题-->    
			<ul>        
				<li class="on">1</li>        
				<li>2</li>        
				<li>3</li>        
				<li>4</li>    
			</ul>   
			<div id="banner_list">        
  				<a href="#" target="_blank"><img src="img/htc one s.jpg" title="htc one s" alt="htc one s" /></a>        
  				<a href="#" target="_blank"><img src="img/chacha.jpg" title="htc cha cha" alt="htc chacha " /></a>        
  				<a href="#" target="_blank"><img src="img/sensation.jpg" title="htc sensation" alt="htc G7" /></a>        
  				<a href="#" target="_blank"><img src="img/htc EVO 3D.jpg" title="htc EVO 3D" alt="htc inspiration XL" /></a>    
  			</div>
		</div>
		<div class="today">
			<div class="today-header">
				<p>今日特惠</p>
			</div>
			<ul>
				<li class="common"><a href="/SuperMarket/ProductInfo?pname=iphone4s"> 新款iphone暴走登陆商城</a></li>
				<li class="common"><a href="/SuperMarket/ProductInfo?pname=galaxy2">经典GalaxyII只要2199</a></li>
				<li class="common"><a href="/SuperMarket/ProductInfo?pname=galaxy3">三星GalaxyIII销售神话</a></li>
				<li class="last"><a href="/SuperMarket/ProductInfo?pname=lumia900"> 诺基亚Lumia900背水一战</a></li>
			</ul>
		</div>
		<div class="content">
			<div class="nice-p">
				<div data-tab="p1" class="choose bac-change">
					<p>最新上架</p>
				</div>
				<div data-tab="p2" class="choose">
					<p>疯狂抢购</p>
				</div>
				<div data-tab="p3" class="choose">
					<p>最新上市</p>
				</div>
				<div data-tab="p4" class="choose">
					<p>热评商品</p>
				</div>
				<div data-tab="p5" class="choose">
					<p>随便看看</p>
				</div>
				<div class="show  display hidden tab-p1">
				   <ul>
				   	<c:if test="${null!=sessionScope.datefive}">
				   <c:forEach var="p" items="${sessionScope.datefive}"
							varStatus="status" step="1">
				   		<li>
				   			<div class="img"><img src="${p.gimage}" width="130" height="130"/></div>
				   			<div class="desc"><a href="/SuperMarket/ProductInfo?pname=<c:out value='${p.gname}'></c:out> ">${p.gname}</a></div>
				   			<div class="price">商城价：${p.price}</div>
				   		</li>
				   	</c:forEach>
				   </c:if>
				   </ul>
				</div>
				<div class="show  hidden  tab-p2">
				    <ul >
				    <c:if test="${null!=sessionScope.topten}">
				    	 <c:forEach var="p" items="${sessionScope.topten}"
						begin="0" end="4" varStatus="status" step="1">
				   		<li>
				   			<div class="img"><img src="${p.gimage }" width="130" height="130"/></div>
				   			<div class="desc"><a href="/SuperMarket/ProductInfo?pname=<c:out value='${p.gname}'></c:out> ">${p.gname}</a></div>
				   			<div class="price">商城价：${p.price}</div>
				   		</li>
				   		</c:forEach>
				   	</c:if>
				   </ul>
				</div>
				<div class="show hidden tab-p3">
				    <ul >
				    <c:if test="${null!=sessionScope.appear}">
				     <c:forEach var="p" items="${sessionScope.appear}"
						begin="0" end="4" varStatus="status" step="1">
				   	<li>
				   		<div class="img"><img src="${p.gimage}" width="130" height="130"/></div>
				   		<div class="desc"><a href="/SuperMarket/ProductInfo?pname=<c:out value='${p.gname}'></c:out> ">${p.gname}</a></div>
				   		<div class="price">商城价：${p.price}</div>
				   	</li>
				   	</c:forEach>
				   	</c:if>
				   </ul>
				</div>
				<div class="show hidden tab-p4">
				   <ul>
				   	<li>
				   		<div class="img"><img src="img/galaxy2_130.jpg"></div>
				   		<div class="desc">ss</div>
				   		<div class="price"></div>
				   	</li>
				   	<li>
				   		<div class="img">
				   			<img src="img/galaxy3_130.jpg"></div>
				   		<div class="desc">ss</div>
				   		<div class="price"></div>
				   		</li>
				   	<li>
				   		<div class="img"><img src="img/galaxy2_130.jpg"></div>
				   		<div class="desc">ss</div>
				   		<div class="price"></div>
				   	</li>
				   	<li>
				   		<div class="img"><img src="img/galaxy2_130.jpg"></div>
				   		<div class="desc">ss</div>
				   		<div class="price"></div>
				   	</li>
				   	<li>
				   		<div class="img"><img src="img/galaxy2_130.jpg"></div>
				   		<div class="desc">ss</div>
				   		<div class="price"></div>
				   	</li>
				   </ul>
				</div>
				<div class="show hidden tab-p5">
				    <ul >
				    <c:if test="${null!=sessionScope.random}">
				    <c:forEach var="p" items="${sessionScope.random}"
						begin="0" end="4" varStatus="status" step="1">
				   	<li>
				   		<div class="img"><img src="img/galaxy2_130.jpg" width="130" height="130"/></div>
				   		<div class="desc"><a href="/SuperMarket/ProductInfo?pname=<c:out value='${p.gname}'></c:out> ">${p.gname}</a></div>
				   		<div class="price">商城价:${p.price}</div>
				   	</li>
				   	</c:forEach>
				   	</c:if>
				   </ul>
				</div>
			</div>
		</div>
		
		<div class="rangking">
			<div class="r-header">销售前八位</div>
			
			<% if(null!=session.getAttribute("topten")){
				List<Goods>  list=(List<Goods>)session.getAttribute("topten");
				for(int i=0;i<list.size();i++){
			 %>
				<div class="ten">
					<div>
						<%=i+1%>
					</div>
					<div class="img">
						<img src="<%=list.get(i).getGimage()%>" width="80" height="80"/>
					</div>
					<div>
						<a href="/SuperMarket/ProductInfo?pname=<%=list.get(i).getGname()%>"><%=list.get(i).getGname()%></a>
					</div>
				</div>
			
			<%
				}
			} 
			%>
			</div>
			<div class="count-time">
			<div class="ct-header"><h4>限时抢购</h4></div>
			<div class="ct-show">
				<div id="time0" style="display:none"> Dec 24 12:22:48 UTC+0800 2012</div>
				<div id="remainTime0" style="color:orange;" class="show-time text"></div>
				<img src="img/iphone4s_130.jpg" width="130" height="130"/>
				<div class="text"><a href="/SuperMarket/ProductInfo?pname=iphone4s">iphone4s</a></div>
				<div class="text">抢购价:￥4777</div>
				<div id="showT" class="text"></div>
			</div>			
			<div class="ct-show l-ten">
				<div id="time" style="display:none">Nov 24 12:22:48 UTC+0800 2012</div>
				<div id="remainTime" style="color:orange;" class="show-time text"></div>
				<img src="img/meizuMX_350.jpg" width="130" height="130"/>
				<div class="text"><a href="/SuperMarket/ProductInfo?pname=meizuMX">iphone4s</a></div>
				<div class="text">抢购价:￥2888</div>
				<div id="showT" class="text"></div>
			</div>
			<div class="ct-show l-ten">
				<div id="time1" style="display:none">Dec 24 12:22:48 UTC+0800 2012</div>
				<div id="remainTime1" style="color:orange;" class="show-time text"></div>
				<img src="img/nokia6700_350.jpg" width="130" height="130"/>
				<div class="text"><a href="/SuperMarket/ProductInfo?pname=nokia808">诺基亚808</a></div>
				<div class="text">抢购价:￥3777</div>
				<div id="showT" class="text"></div>
			</div>
			<div class="ct-show l-ten">
				<div id="time2" style="display:none">Sep 24 12:22:48 UTC+0800 2012</div>
				<div id="remainTime2" style="color:orange;" class="show-time text"></div>
				<img src="img/sonymt15_350.jpg" width="130" height="130"/>
				<div class="text"><a href="/SuperMarket/ProductInfo?pname=sonymt15">SonyMT15i</a></div>
				<div class="text">抢购价:￥2777</div>
				<div id="showT" class="text"></div>
			</div>
			<script type="text/javascript">
				var SysSecond = $("#time").html();
				djs(SysSecond,function(msg){
				document.getElementById('remainTime').innerHTML = msg;
				});
				var SysSecond2 = $("#time1").html();
				djs(SysSecond2,function(msg){
				document.getElementById('remainTime1').innerHTML = msg;
				});
				var SysSecond0 = $("#time0").html();
				djs(SysSecond0,function(msg){
				document.getElementById('remainTime0').innerHTML = msg;
				});
				var SysSecond3 = $("#time2").html();
				djs(SysSecond3,function(msg){
				document.getElementById('remainTime2').innerHTML = msg;
				});
			</script> 
		</div>
		<div class="line-bottom"></div>
<%@include file="common/common_bottom.jsp" %>