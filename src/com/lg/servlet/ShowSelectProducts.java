package com.lg.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lg.dao.impl.GoodDAO;
import com.lg.entity.Goods;

public class ShowSelectProducts extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
			String location=req.getParameter("location");
			List<Goods> listGoods=new GoodDAO().findGoodsByLocation(location);
//			for (int i = 0; i < listGoods.size(); i++) {
//				System.out.println(listGoods.get(i).getGname());
//			}
			req.getSession().setAttribute("listGoods", listGoods);
			req.getRequestDispatcher("/ShowSelectProduct.jsp").forward(req, resp);
			
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req, resp);
	}
}
