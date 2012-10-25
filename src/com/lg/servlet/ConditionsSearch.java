package com.lg.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lg.dao.impl.GoodDAO;
import com.lg.entity.Goods;

public class ConditionsSearch extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String net=req.getParameter("net");
		String brand=req.getParameter("brand");
		String price=req.getParameter("price");
		String os=req.getParameter("os");
		System.out.println(" sfsdfsdfsd"+net+"sdf"+os);
		List<Goods> listCon=new GoodDAO().conditionsSearch(net, brand, price, os);
		for (int i = 0; i < listCon.size(); i++) {
			System.out.println(" sfsdfsdfsd"+listCon.get(i).getGname());
		}
//		req.getSession().setAttribute("listGoods", listCon);
		
//		req.getRequestDispatcher("/ShowSelectProduct.jsp").forward(req, resp);
	}
}
