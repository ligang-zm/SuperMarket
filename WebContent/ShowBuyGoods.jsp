<%@include file="common/common_header.jsp" %>
	<div class="show-buy-goods">
	<div class="show-header-common">购买商品</div>
		<c:if test="${null!=requestScope.list1}">			
			<div class="sg-buy">
				<div class="header-info-buy">
					<ul>
						<li>图片</li>
						<li>名称</li>
						<li>品牌</li>
						<li>价格</li>						
						<li>评价</li>
					</ul>
				</div>
			<c:forEach var="goods" items="${requestScope.list1}"
						 varStatus="status" step="1">
				<div class="content-buy">
					<ul>
						<li><img src="${goods.gimage}" width="80"height="80"/></li>
						<li>${goods.gname}</li>
						<li>${goods.brand}</li>
						<li>${goods.gprice}</li>							
						<li><a href="/SuperMarket/ProductInfo?pname=${goods.gname}&pid=${goods.sgid}">评价</a></li>																					
					</ul>
				 </div>
				</c:forEach>						
		</div>
		</c:if>
	</div>
<%@include file="common/common_bottom.jsp" %>