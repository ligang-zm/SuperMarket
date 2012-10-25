package com.lg.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.lg.dao.impl.GoodDAO;
import com.lg.entity.Goods;

public class IndexInfoGet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
			List<Goods> listGetTopTen =new GoodDAO().getSoldTopTen();
			List<Goods> listLastDateFive=new GoodDAO().getLastDateFive();
			List<Goods> listRandom=new GoodDAO().getRandomInfo();
			List<Goods> listLastAppear=new GoodDAO().getLastAppear();
//			for (int i = 0; i < listLastDateFive.size(); i++) {
//				System.out.println(listLastDateFive.get(i).getGname());
//			}
			req.getSession().setAttribute("random", listRandom);
			req.getSession().setAttribute("topten", listGetTopTen);
			req.getSession().setAttribute("datefive", listLastDateFive);
			req.getSession().setAttribute("appear", listLastAppear);
			req.getRequestDispatcher("/index.jsp").forward(req, resp);
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		this.doPost(req, resp);
	}
}
