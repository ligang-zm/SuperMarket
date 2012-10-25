<%@include file="common/common_header.jsp" %>
	<div class="show-cart">
		
		<c:if test="${null!=sessionScope.shopping}">
			<form  id="form1" action="" class="form1"  method="post">
			<div class="sg-cart">
				<div class="header-cart">
				<ul>
					<li class="checkbox"><input class="select-all" type="checkbox" name="all"/></li>
					<li>图片</li>
					<li>名称</li>
					<li>价格(元/件)</li>
					<li>数量(件)</li>
					<li>总价(元)</li>
					<li>删除</li>
				</ul>
				</div>
				<c:forEach var="goods" items="${sessionScope.shopping}" varStatus="status"   step="1">
				<div class="content-cart">
					<ul>
						<li><input type="checkbox" class="select" value="${goods.gname}" name="select"/></li>
						<li><img src="${goods.img}" alt="${goods.gname}" width="90px" height="90px"/></li>
						<li>${goods.gname}</li>
						<li><span style="color:red;font-style:bold;">￥</span><input type="text" id="${goods.gname}C"value="${goods.price}" class="price no-border"  readOnly/></li>
						<li>						
							<div  dataT="${goods.gname}T" dataC="${goods.gname}C" dataR="${goods.gname}"class="reduce-cart">
							</div>							
							<input type="text" dataT="${goods.gname}T" dataC="${goods.gname}C" name="count"  id ="${goods.gname}"class="count-cart" onafterpaste="this.value=this.value.replace(/\D/g,'')" onkeyup="this.value=this.value.replace(/\D/g,'');this.value=this.value.replace(/^0/g,'');" value="${goods.count}"/>							
							<div dataS="${goods.gid}" dataP="${goods.gname}" dataT="${goods.gname}T" dataC="${goods.gname}C" class="add-cart">
							</div>							
							<input  type="text" id="${goods.gid}" class="store-cart" value="${goods.store}"/>
						</li>
						<li class="s-total"><input type="text" id="${goods.gname}T" value="${goods.price*goods.count}"  class="total-s no-border"readOnly/></li>
						<li><a href="/SuperMarket/CartInfoDelete?gname=${goods.gname}">删除</a></li>						
					</ul>
				 </div>
				</c:forEach>
				<div id="exist" style=""><c:out value="${sessionScope.userAccount}"></c:out></div>						
		</div>
		<div class="delete-block"><input type="submit" id="delete" value="删除所选" class="delete"/></div>
		<div class="deal-with"><div>总计：￥</div><div id="totalFina"><input id="totalFinal" name="totalFinal" type="text" value="<c:out value='${sessionScope.total}'></c:out>" Style="border:none;"readonly/></div>
			<input type="submit" value="" id="buy-cart" class="buy-cart"/>
		</div>
			</form>
		</c:if>
		<c:if test="${null==sessionScope.shopping}">
			<div class="sg-cart">
				<img src="img/cart.png" />购物车还是空空的哦。。。。
			</div>
   		</c:if>
	</div>
<%@include file="common/common_bottom.jsp" %>
