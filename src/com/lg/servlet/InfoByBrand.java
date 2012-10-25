package com.lg.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lg.dao.impl.GoodDAO;
import com.lg.entity.Goods;

public class InfoByBrand extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String brand=req.getParameter("brand");
		List<Goods> listB=new GoodDAO().findGoodsByBrand(brand);
		req.getSession().setAttribute("brand", listB);
//		for(int i=0;i<listB.size();i++){
//			System.out.println(listB.get(i).getBrand());
//		}
		req.getRequestDispatcher("/InfoByBrand.jsp").forward(req, resp);
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		this.doPost(req, resp);
	}
}
