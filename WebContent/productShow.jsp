<%@page import="com.lg.dao.impl.CommentDAO"%>
<%@page import="com.lg.entity.Comment"%>
<%@page import="java.util.List"%>
<%@page import="java.io.PrintWriter"%>
<%@page import="com.lg.entity.Standard"%>
<%@page import="com.lg.entity.Goods"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="common/common_header.jsp" %>
<%
	if(null!=session.getAttribute("goods")||null!=session.getAttribute("stand")){
 Goods gds = (Goods) session.getAttribute("goods");
 Standard sd=(Standard) session.getAttribute("stand");
%>
		<div class="p-show">		
			<div class="left-info">
			<div class="header-left-show">相同价位的商品</div>
			<c:if test="${null!=sessionScope.closedprice}">
				<c:forEach var="p" items="${sessionScope.closedprice}"
							varStatus="status" step="1" >
				<div class="show-closed">
					<div class="img-left">
						<img src="${p.gimage}" width="130" height="130" />
					</div>
					<div class="price-red">
					￥${p.price}
					</div>
					<div class="text-name">
						<a href="/SuperMarket/ProductInfo?pname=${p.gname}">${p.gname}</a>
					</div>
				</div>
				</c:forEach>
				</c:if>
			</div>
				
		
			<div class="img">
				<img src="<%=gds.getGimage()%>" alt="iphone4s" />
			</div>
			<div class="s-info">
				<form action="/SuperMarket/Cart" method="post">
					<input type="text" name="gid" value="<%=gds.getGid()%>"
						class="no-show" /> 
						<input type="text" name="img"
						value="<%=gds.getGimage()%>" class="no-show" />
						<input type="text" name="store" id="store"
						value="<%=gds.getStore()%>" class="no-show" />
					<ul>
						<li>商品:<input type="text" name="gname" class="disable"
							value="<%=gds.getGname()%>" readonly /></li>
						<li>商城价：<input type="text" name="price" class="disable"
							value="<%=gds.getPrice()%>" readonly/></li>
						<li>库存送至 <select name="location">
								<option>上海</option>
								<option>无锡</option>
						</select>由商城统一发货
						</li>
						<li>商品评分</li>
						<li>优惠信息：</li>
						<li>库存：<%=gds.getStore()%>件 </li>
						<li class="count">
							<div>我要买</div>
							<div class="reduce"></div>
							<div>
								<input name="count" class="count" type="text"
									onafterpaste="this.value=this.value.replace(/\D/g,'')"
									 value="1"/>
							</div>
							<div class="add"></div>
							<div class="list hidden" style="color:red;">超出库存</div>
						</li>
						<li><input type="submit" class="btn-cart" value="" /> 
						<input type="submit" class="btn-buy" value="立即购买" /></li>
					</ul>
				</form>
			</div>		
			<div class="cart-info hidden">	
			<c:if test="${null!=sessionScope.shopping}">					
					<div class="middle-info">
						<div id="no-show-info"><%=request.getParameter("cart") %></div>
						<c:forEach var="goods" items="${sessionScope.shopping}"
							varStatus="status" step="1">
							<ul>
								<li><img alt="${goods.gname}" src="${goods.img}"
									width="80px" height="80px" /></li>
								<li>${goods.gname}</li>
								<li>${goods.count}件</li>							
							</ul>
						</c:forEach>
					</div>
					<div class="show-info-dump">您的商品已经成功加入购物车！</div>						
			</c:if>
			</div>	
			<div class="standard">
				<div class="standard-header">详细参数</div>
				<div class="standard-show">
					<ul>
						<li><div class="li-left">上市日期</div><div class="li-right"><%=sd.getAppearDate() %></div></li>
						<li><div class="li-left">屏幕尺寸(寸)</div><div class="li-right"><%=sd.getScreenSize() %></div></li>
						<li><div class="li-left">屏幕分辨率(像素)</div><div class="li-right"><%=sd.getSeperation() %></div></li>
						<li><div class="li-left">网络制式</div><div class="li-right"><%=sd.getNet() %></div></li>
						<li><div class="li-left">操作系统</div><div class="li-right"><%=sd.getOs() %></div></li>
					</ul>
				</div>
			</div>
			</div>
	<div class="comment">
		<div class="comment-content">
		<div class="comment-header">用户评论</div>
		<div class="comment-block">
			<table border="1">
					<tr>
						<td>客户评论Id</td><td>内容</td><td>评论时间</td><td>用户Id</td>
					</tr>
					<%
					PrintWriter pw=response.getWriter();
				   String gId="";
				   if(null!=request.getAttribute("gid")){
				 gId=(String)request.getAttribute("gid");
				   }
				   else if(null!=request.getAttribute("getid")){
					   gId=String.valueOf(request.getAttribute("getid"));
				   }
					List<Comment> list = new CommentDAO().findAllComment(Integer.valueOf(gId));
					if(list.size()==0)
					{
						%>					
						<% 
					}
					//当前页数的参数
					String strCurPage = request.getParameter("page");
					//当前的页数
					int curPage;
					if (strCurPage == null) {
						curPage = 1;
					} else {
						curPage = Integer.parseInt(strCurPage);
					}
					
					//每页显示的数量
					int counterPerPage = 3;
					//计算分页
					int pageCount=(list.size()-1)/counterPerPage+1;
					int i =counterPerPage*(curPage-1);
					int j=counterPerPage*curPage-1;
					while(i<counterPerPage*curPage&&i<list.size()){
					%>
					<tr>
						<td><%=list.get(i).getcId()%></td>
						<td><textarea cols="3" rows="3" readonly="readonly"><%=list.get(i).getContext()%></textarea></td>
						<td><%=list.get(i).getcTime()%></td>
						<td><%=list.get(i).getAcId()%></td>
					</tr>
					<% 
					i++;
				}
					%>
				</table>
	<%	
		if(curPage == 1){
	%>
	<br>
	第一页&nbsp;&nbsp;&nbsp;&nbsp; 上一页&nbsp;&nbsp;&nbsp;&nbsp;
	<%
		}
		else
		{
	%>
	<a href="productShow.jsp?page=1">第一页</a>&nbsp;&nbsp;&nbsp;&nbsp;
	<a href="ProductShow.jsp?page=<%=curPage - 1%>">上一页</a>&nbsp;&nbsp;&nbsp;&nbsp;
	<%
		}
		//如果是最后一页
		if (curPage == pageCount)
		{
	%>
	下一页&nbsp;&nbsp;&nbsp;&nbsp; 最后页&nbsp;&nbsp;&nbsp;&nbsp;
	<%
		}
		else
		{
	%>
	<a href="productShow.jsp?page=<%=curPage + 1%>">下一页</a>&nbsp;&nbsp;&nbsp;&nbsp;
	<a href="productShow.jsp?page=<%=pageCount%>">最后页</a>&nbsp;&nbsp;&nbsp;&nbsp;
	<%
		}
	
%>
	<form action="/SuperMarket/Servlet2?gid=<%=request.getAttribute("gid") %>" method="post">
		<table>
			<tr>
				<td><textarea rows="10" cols="45" name="context"></textarea></td>
			</tr>

			<tr>
				<td><input type="submit" value="发表帖子"></td>
			</tr>
		</table>
	</form>
	</div>
		</div>		
	</div>
	<%
	
	}
		%>
<%@include file="common/common_bottom.jsp" %>	
