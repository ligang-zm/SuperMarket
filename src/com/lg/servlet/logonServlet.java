package com.lg.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.lg.dao.IUserDAO;
import com.lg.dao.impl.UserDAO;
import com.lg.entity.UserAccount;

/**
 * Servlet implementation class logonServlet
 */
@WebServlet("/logon1")
public class logonServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

//	@Override
//	public void init(ServletConfig config) throws ServletException {
//		this.config = config;
//	}
//
//	private ServletConfig config = null;
//	
//	
//
//	private File tempPath = new File("D:\\upload\\temp\\"); // 鐢ㄤ簬瀛樻斁涓存椂鏂囦欢鐨勭洰褰�
//
//	public void destroy() {
//		config = null;
//		super.destroy();
//	}

    /**
     * @see HttpServlet#HttpServlet()
     */
    public logonServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		       //璁剧疆璇锋眰缂栫爜
				req.setCharacterEncoding("UTF-8");
				//璁剧疆鍝嶅簲缂栫爜
				resp.setCharacterEncoding("UTF-8");
				//璁剧疆鍝嶅簲鏍煎紡
				resp.setContentType("text/html");
			    PrintWriter out = resp.getWriter();
	        	String acname=req.getParameter("username");	
				String pwd=req.getParameter("password");
				String email=req.getParameter("email");
				String phone="0";
				String address="无锡NIIT";
//				String birthday=req.getParameter("birthday");
				String desc=null;
				HttpSession session=req.getSession();
				String avator=(String)session.getAttribute("img");
			   String problem=req.getParameter("problem");
				String answer = req.getParameter("answer");
	//			SimpleDateFormat df=new SimpleDateFormat("yyyy-MM--DD");
			    
				int gender=0;
				int userscore=0;
				int grpId=1;
				int userstatus=1;
				String regIp="localhost";
				Timestamp regTime=new Timestamp(System.currentTimeMillis());
				String year=req.getParameter("year");
				String month=req.getParameter("month");
				String day=req.getParameter("day");
				 UserAccount ac=new UserAccount();
				 ac.setAcName(acname);
				 ac.setAcPassword(pwd);
				 ac.setEmail(email);
				 ac.setPhone(phone);
				 ac.setAddress(address);
				 ac.setBirthday(year+"-"+month+"-"+day);
				 ac.setGender(gender);
				 ac.setScore(userscore);
				 ac.setGrpId(grpId);
				 ac.setAvator(avator);
				 ac.setUserdesc(desc);
				 ac.setUserstatus(userstatus);
				 ac.setRegIp(regIp);
				 ac.setRegTime(regTime);
				 ac.setAnswer(answer);
				 ac.setProblem(problem);
				 
				 String code1=req.getParameter("code");
				 String code2=(String)req.getSession().getAttribute("sCode");
				 if(code1.equalsIgnoreCase(code2)){
					 IUserDAO dao= new UserDAO();
					 
						if(dao.addUser(ac)){
							req.getRequestDispatcher("pages/welcome.jsp").forward(req, resp);
						}
						else {
							req.getRequestDispatcher("pages/error.jsp").forward(req, resp);
						}
				 }
				 else {
					out.println("验证码不正确");
				}
				 
	}
     
}
