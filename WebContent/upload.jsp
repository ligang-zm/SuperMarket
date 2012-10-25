<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form id="form1" name="msform" method="post" action="/SuperMarket/do_upload.jsp" enctype="multipart/form-data" onSubmit="return Check_Found(this);" target="iframe1"> 
<table width="50%" border="1" align="center"> 
  <tr> 
  <td align="center"><input type="text" name="name" id="text1"></td> 
  </tr> 
  <tr> 
  <td align="center">产品说明： 
  <input type="file" name="file2" value=""/> 
<iframe name="iframe1" style="display:none"> </iframe> 
  <input type="submit" name="Submit" value="上传图片" /> 
</td> 
  </tr> 
</table> 
</form>  
</body>
</html>