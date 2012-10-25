package com.lg.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.lg.dao.impl.BookDAO;
import com.lg.entity.Book;
import com.lg.entity.UserAccount;

/**
 * Servlet implementation class BookInfo
 */
@WebServlet("/bookinfo")
public class BookInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookInfo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html");
//		UserAccount ua=(UserAccount)req.getSession().getAttribute("uaerAccount");
//		int acid=ua.getAcId();
		int acid=1;
		List<Book> list= new BookDAO().findAllBookInfo(acid);	
		req.setAttribute("list", list);
		req.getRequestDispatcher("/Show_Book.jsp").forward(req, resp);
	}

}
