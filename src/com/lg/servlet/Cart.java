package com.lg.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.catalina.Session;

import com.lg.dao.impl.GoodDAO;
import com.lg.entity.Goods;
import com.lg.entity.ShoppingInfo;

public class Cart extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		if(null!=req.getParameter("count")||null!=req.getParameter("store")){
		String address=req.getParameter("location");
		int count=Integer.parseInt(req.getParameter("count"));
		String gname=req.getParameter("gname");
		String img=req.getParameter("img");
		int gid=Integer.parseInt(req.getParameter("gid"));
		double price=Double.parseDouble(req.getParameter("price"));
		int store=Integer.parseInt(req.getParameter("store"));
		ShoppingInfo si=new ShoppingInfo();
		si.setGid(gid);
		si.setAddress(address);
		si.setCount(count);
		si.setGname(gname);
		si.setPrice(price);
		si.setImg(img);
		si.setStore(store);
		add_updataCart(req, count, si);
		req.setAttribute("cart","true");
		req.setAttribute("gid", String.valueOf(si.getGid()));
		req.getRequestDispatcher("/productShow.jsp?cart=true").forward(req, resp);
//		resp.sendRedirect("/SuperMarket/productShow.jsp?cart=true");
		}
//		else{
//			if(null!=req.getParameter("gname")){
//				String gname=req.getParameter("gname");
//				Goods gd=new GoodDAO().findGoodByName(gname);
//				System.out.println(gd.getGname());
//				ShoppingInfo si2=new ShoppingInfo();
//				si2.setCount(1);
//				si2.setGname(gd.getGname());
//				si2.setImg(gd.getGimage());
//				si2.setPrice(gd.getPrice());
//				si2.setStore(gd.getStore());
//				si2.setGid(gd.getGid());
//				add_updataCart(req, 1, si2);
//				req.getRequestDispatcher("/IndexInfoGet").forward(req, resp);
//			}
//		}
	}
	private void add_updataCart(HttpServletRequest req, int count,
			ShoppingInfo si) {
		if(null!=req.getSession().getAttribute("shopping")){
			List<ShoppingInfo> list=(List<ShoppingInfo>) req.getSession().getAttribute("shopping");
			boolean flag=false;
			for(int i=0;i<list.size();i++){
				if(si.getGid()==list.get(i).getGid()){
					si.setCount(count+list.get(i).getCount());
					List<ShoppingInfo> lupdata=new GoodDAO().updataGoodToCart(si, i);
					HttpSession session=req.getSession();
					session.setAttribute("shopping", lupdata);
					flag=true;
				}
				double total=0.0;
				total=total+list.get(i).getPrice()*list.get(i).getCount();
				req.getSession().setAttribute("total",total);
//				else{
//					List<ShoppingInfo> lshop=new GoodDAO().addGoodToCart(si);
//					HttpSession session=req.getSession();
//					session.setAttribute("shopping", lshop);
//				}
			}
			if(flag==false){
				List<ShoppingInfo> lshop=new GoodDAO().addGoodToCart(si);
				HttpSession session=req.getSession();
				session.setAttribute("shopping", lshop);
			}
		}
		else{
			GoodDAO.list.clear();
			List<ShoppingInfo> lshop=new GoodDAO().addGoodToCart(si);
			HttpSession session=req.getSession();
			session.setAttribute("shopping", lshop);
		}
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, resp);
	}
}
