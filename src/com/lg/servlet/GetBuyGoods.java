package com.lg.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lg.dao.impl.BookDAO;
import com.lg.entity.Book;

public class GetBuyGoods extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html");
		int acid=1;
		List<Book> listGoods= new BookDAO().findAllGoodsInfo(acid);
		req.setAttribute("list1", listGoods);
		req.getRequestDispatcher("/ShowBuyGoods.jsp").forward(req, resp);
	}
}
