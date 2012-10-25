package com.lg.servlet;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lg.dao.impl.BookDAO;
import com.lg.entity.Book;
import com.lg.entity.ShoppingInfo;
import com.lg.entity.UserAccount;

public class BookAdd extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		if(null!=req.getParameter("guest")){
			UserAccount ua=(UserAccount)req.getSession().getAttribute("userAccount");
			List<ShoppingInfo> listSI=(List<ShoppingInfo>)req.getSession().getAttribute("shopping");
			String guest=req.getParameter("guest");
			String zip=req.getParameter("zip");
			String address=req.getParameter("address");
			String phone=req.getParameter("phone");
			System.out.println(guest);
			System.out.println(zip);
			Book bk=new Book();		
			bk.setGuest(guest);
			bk.setBooktime(new Timestamp(System.currentTimeMillis()));
			bk.setGuestAddress(address);
			bk.setPostCode(zip);
			bk.setGuestPhone(phone);
			bk.setStatus(0);
			boolean addBook=new BookDAO().addbook(bk);
			req.setAttribute("addbook", addBook);
			if(addBook){
			for (int i = 0; i < listSI.size(); i++) {
				Book subBook=new Book();		
				int id=new BookDAO().getLastBookId(guest);
				subBook.setGid(listSI.get(i).getGid());
				subBook.setGcount(1);
				subBook.setBookid(id);
				boolean addSubBook=new BookDAO().addSubBook(subBook);
				if(addSubBook){
					resp.sendRedirect("/SuperMarket/Show_Book.jsp");
				}
			}
			}
			
		}
	}
}
