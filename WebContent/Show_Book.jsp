<%@include file="common/common_header.jsp" %>
<%@taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>	
<div class="show-buy-goods">
	<div class="show-header-common">订单查询</div>
		<c:if test="${null!=requestScope.list}">			
			<div class="sg-buy">
				<div class="header-info-buy">
					<ul>
						<li>订单id</li>
						<li>收货人</li>
						<li>收货地址</li>
						<li>联系方式</li>
						<li>发货状态</li>
					</ul>
				</div>
			<c:forEach var="book" items="${requestScope.list}"
						 varStatus="status" step="1">
				<div class="content-buy">
					<ul class="book-info">
						<li>${book.bookid}</li>
						<li>${book.guest}</li>
						<li>${book.guestAddress}</li>							
						<li>${book.guestPhone}</li>
						<c:if test="${book.status==0}"><li>等待发货</li></c:if>
						<c:if test="${book.status==1}"><li>已经发货</li></c:if>
						<c:if test="${book.status==2}"><li>确认收货</li></c:if>
						<c:if test="${book.status==3}"><li>取消订单</li></c:if>																	
					</ul>
				 </div>
				</c:forEach>						
		</div>
		</c:if>
	</div>
<%@include file="common/common_bottom.jsp" %>