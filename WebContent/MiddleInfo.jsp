<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<c:if test="${null!=sessionScope.shopping}">
<div class="middle">
	<div class="middle-info">
		<ul>
			<c:forEach var="goods" items="${sessionScope.shopping}" varStatus="status"   step="1">
			<li>${goods.gid}</li>
			<li>${goods.gname}</li>
			<li>${goods.img}</li>
			</c:forEach>
		</ul>
	</div>
</div>
</c:if>
</body>
</html>