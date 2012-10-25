package com.lg.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.lg.dao.impl.UserDAO;
import com.lg.entity.UserAccount;
@WebServlet("/login")
public class LoginServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -11616360738731496L;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		doPost(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//设置请求编码
		req.setCharacterEncoding("UTF-8");
		//设置响应编码
		resp.setCharacterEncoding("UTF-8");
		//设置响应格式
		resp.setContentType("text/html");
		String name=req.getParameter("acname");
		String pwd=req.getParameter("password");
		
		UserAccount ac=new UserDAO().findUserByName(name);
		if(ac!=null){
			if(ac.getAcName().equalsIgnoreCase(name)&&ac.getAcPassword().equals(pwd)){
				HttpSession session=req.getSession();
				session.setAttribute("userAccount", ac);
				resp.sendRedirect("IndexInfoGet");
			}
			else {
				resp.sendRedirect("pages/error.jsp");
			}
		}
		else {
			resp.sendRedirect("pages/error.jsp");
		}
	
	}
}
