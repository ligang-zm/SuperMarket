<%@page import="com.lg.entity.Goods"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="com.lg.common.DBTool"%>
<%@page import="java.sql.Connection"%>
<jsp:useBean id="smartupload" class="org.lxh.smart.SmartUpload"/>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	response.setCharacterEncoding("UTF-8");
	request.setCharacterEncoding("UTF-8");
	smartupload.initialize(pageContext);
	smartupload.upload();
	smartupload.save("upload");
	String getFileName=smartupload.getFiles().getFile(0).getFileName();
	session.setAttribute("img", getFileName);
	request.getRequestDispatcher("/logon.jsp").forward(request, response);
	
	%>

</body>
</html>