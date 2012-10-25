package com.lg.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.lg.dao.impl.GoodsDAO;
import com.lg.entity.Goods;


/**
 * Servlet implementation class SearchMainServlet
 */
@WebServlet("/main")
public class SearchMainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchMainServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//设置请求编码
				req.setCharacterEncoding("UTF-8");
				//设置响应编码
				resp.setCharacterEncoding("UTF-8");
				//设置响应格式
				resp.setContentType("text/html");
				String str=req.getParameter("keywords");
				Collection goodlist=new ArrayList<Goods>();
			   try {
				   
				  goodlist= new GoodsDAO().searchgoods(str);
				   Goods gt=new Goods();
				   if(goodlist!=null){
					   if(gt.getGname().equals(str)){
						   HttpSession session=req.getSession();
						   session.setAttribute("goods", gt);
						   resp.sendRedirect("pages/welcome.jsp");
					   }
					   else {
						   resp.sendRedirect("pages/error.jsp");
					   }
				   }
				   else {
					   resp.sendRedirect("pages/error.jsp");
				   }
		
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
	}
	}
}

