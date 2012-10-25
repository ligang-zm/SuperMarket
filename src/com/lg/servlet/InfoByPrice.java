package com.lg.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Collection;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lg.dao.impl.GoodsDAO;
import com.lg.entity.Goods;

/**
 * Servlet implementation class InfoByPrice
 */
@WebServlet("/InfoByPrice")
public class InfoByPrice extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InfoByPrice() {
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
		String price=req.getParameter("price");
	
		Collection listB;
		try {
			listB = new GoodsDAO().searchGoodsByPrice(price);
			req.getSession().setAttribute("price", listB);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
//		for(int i=0;i<listB.size();i++){
//			System.out.println(listB.get(i).getBrand());
//		}
		req.getRequestDispatcher("/InfoByPrice.jsp").forward(req, resp);
	}

}
