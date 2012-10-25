package com.lg.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lg.dao.impl.GoodsDAO;

/**
 * Servlet implementation class InfoByOs
 */
@WebServlet("/InfoByOs")
public class InfoByOs extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InfoByOs() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
         String os=req.getParameter("os");
		try {
			Collection	listB = new GoodsDAO().searchgoodsbyos(os);
			req.getSession().setAttribute("os", listB);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
//		for(int i=0;i<listB.size();i++){
//			System.out.println(listB.get(i).getBrand());
//		}
		req.getRequestDispatcher("/InfoByOs.jsp").forward(req, resp);
	}

}
