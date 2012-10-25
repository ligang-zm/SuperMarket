package com.lg.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.lg.dao.impl.GoodDAO;
import com.lg.entity.Goods;
import com.lg.entity.Standard;

public class ProductInfo extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		resp.setContentType("text/html;charset=utf-8");
		if(null!=req.getParameter("pname")){
		String pname=req.getParameter("pname");
		String getid=String.valueOf(new GoodDAO().GetGid(pname));
		String pid=req.getParameter("pid");
		Standard sd=new GoodDAO().getStandard(pname);
		Goods gds=new GoodDAO().findGoodByName(pname);
		List<Goods> listPC=new GoodDAO().getPriceClosedInfo(pname);
//		for (int i = 0; i < listPC.size(); i++) {
//			System.out.println(listPC.get(i).getPrice());
//		}
		HttpSession session = req.getSession();
		session.setAttribute("goods", gds);
		session.setAttribute("closedprice", listPC);
		session.setAttribute("stand", sd);
//		System.out.println(pid);
		req.setAttribute("gid", pid);
		req.setAttribute("getid", getid);
		req.getRequestDispatcher("/productShow.jsp").forward(req, resp);
	}
	}
}
