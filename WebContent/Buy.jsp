<%@include file="common/common_header.jsp" %>

	<div class="show-buy-goods">
		<div class="show-header-common">订单提交</div>
		<c:if test="${null!=sessionScope.shopping}">
			<form  id="form1" class="form1" action="/SuperMarket/BookAdd" method="post">
			<div class="sg-buy">
				<div class="header-info-buy">
					<ul>
						<li>图片</li>
						<li>名称</li>
						<li>价格(元/件)</li>
						<li>数量(件)</li>
						<li>总价(元)</li>
					</ul>
				</div>
				<c:forEach var="goods" items="${sessionScope.shopping}" varStatus="status"   step="1">
				<div class="content-buy">
					<ul>
						<li><img src="${goods.img}" alt="${goods.gname}" width="90px" height="90px"/></li>
						<li>${goods.gname}</li>
						<li><span style="color:red;font-style:bold;">￥${goods.price}</span></li>
						<li>											
							${goods.count}															
						</li>
						<li>
							${goods.price*goods.count}
						</li>											
					</ul>
				 </div>
				</c:forEach>						
		</div>
		<div class="deal-with-buy"><div>总计：￥</div><div id="totalFinal"><%=request.getParameter("totalFinal") %></div>
		</div>
		<div class="book-info">	
			<div class="book-info-header">填写订单</div>
			<ul>
				<li>
					收货人<input type="text" class="guest-name" name="guest" >
				</li>
				<li>收货地址<input type="text" class="address" name="address" /></li>
				<li>邮政编码<input type="text" class="zip" name="zip" /></li>
				<li>联系方式<input type="text" class="phone" name="phone" /></li>
			</ul>
			<input type="submit" value="订单提交" class="book-btn"/>
		</div>		
			</form>
		</c:if>
	</div>
<%@include file="common/common_bottom.jsp" %>