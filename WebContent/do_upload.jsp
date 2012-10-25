<%@page import="com.jspsmart.upload.SmartUpload"%>
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
 SmartUpload su =new SmartUpload();
 su.initialize(pageContext); 
 su.upload(); 
 String name; 
 int count=su.save("/upload",su.SAVE_VIRTUAL); 
 out.println(count+"个文件上传成功！ <br>"); 
 for(int i=0;i <su.getFiles().getCount();i++) 
 { 
 com.jspsmart.upload.File file=su.getFiles().getFile(i); 
 if(file.isMissing()) continue; 
 String files=file.getFileName(); 
 out.print("<script>window.parent.document.text1.value='../upload/"+file.getFileName()+"';</script>");
 out.print("<script>alert('上传成功！');</script>");
 //response.setHeader("Refresh","0;URL=addnewproduce.jsp");
 } 
 
 %>
</body>
</html>