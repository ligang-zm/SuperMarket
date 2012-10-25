package com.lg.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.lg.entity.Comment;
import com.lg.filter.CommentFilter;
import com.lg.dao.impl.CommentDAO;

/**
 * Servlet implementation class Servlet2
 */
@WebServlet("/Servlet2")
public class Servlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Servlet2() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
//		List<Comment> list = new CommentDAO().findAllComment();
		PrintWriter pw = resp.getWriter();
		HttpSession session=req.getSession();
//		req.setAttribute("list", list);
		String acId=(String) session.getAttribute("acId");
		String gId=(String) req.getAttribute("gid");
		String context = req.getParameter("context");
		context = CommentFilter.Filter(context);
		Comment c = new Comment(context, new Date(System.currentTimeMillis()),Integer.valueOf(acId), Integer.valueOf(gId));
		session.setAttribute("comment",c);
		CommentDAO cd = new CommentDAO();
		cd.addComment(c);
		pw.print("ok");
	//	req.getRequestDispatcher("/pages/allComment.jsp").forward(req, resp);
		resp.sendRedirect("pages/allComment.jsp");

	}
}
