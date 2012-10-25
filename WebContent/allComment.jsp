<%@page import="com.lg.dao.impl.CommentDAO"%>
<%@page import="java.io.PrintWriter"%>
<%@page import="com.lg.entity.Comment"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
<form>
				<table border="1">
					<tr>
						<td>客户评论Id</td><td>内容</td><td>评论时间</td><td>用户Id</td>
					</tr>
					
					<%
					PrintWriter pw=response.getWriter();
					String gId=(String)request.getAttribute("gid");
					int gid=Integer.parseInt(gId);
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
			</form>
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
	<form action="../Servlet2" method="post">
		<table>
			<tr>
				<td><textarea rows="10" cols="45" name="context"></textarea></td>
			</tr>

			<tr>
				<td><input type="submit" value="发表帖子"></td>
			</tr>
		</table>
	</form>
</body>
</html>
