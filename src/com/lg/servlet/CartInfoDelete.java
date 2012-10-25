package com.lg.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lg.dao.impl.GoodDAO;
import com.lg.entity.ShoppingInfo;

public class CartInfoDelete extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		this.doPost(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		
		List<ShoppingInfo> ldelete=null;
		List<ShoppingInfo> list=(List<ShoppingInfo>) req.getSession().getAttribute("shopping");
		if(true){		
			if(null!=req.getParameter("gname")){
				String gname=req.getParameter("gname");
					for(int i=0;i<list.size();i++){
						if(gname.equals(list.get(i).getGname())){				
							ldelete=new GoodDAO().deleteGoodfromCart(i);
						}
					}
					req.getSession().setAttribute("shopping", ldelete);
					req.getRequestDispatcher("/cart.jsp").forward(req, resp);
				}
			if(null!=req.getParameterValues("select")){
				String gnames[] =req.getParameterValues("select");
				for(int j=0;j<gnames.length;j++){			
					for (int i = 0; i < list.size(); i++) {
						if(gnames[j].equals(list.get(i).getGname())){
							ldelete=new GoodDAO().deleteGoodfromCart(i);
							
						}
					}
				}
				req.getSession().setAttribute("shopping", ldelete);
				req.getRequestDispatcher("/cart.jsp").forward(req, resp);
			}
		}
		
		
		
		
	}
}
