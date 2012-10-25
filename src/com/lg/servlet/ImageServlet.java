package com.lg.servlet;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ImageServlet
 */
@WebServlet("/image")
public class ImageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ImageServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("image/jpeg");
		int w=60;
		int h=30;
		//澹版槑鍐呭湪涓殑鍥剧墖	
		BufferedImage img=new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
		//鑾峰彇g瀵硅薄寮�
		Graphics g=img.getGraphics();
		
		//璁剧疆鑳屾櫙
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, w, h);
		//璁剧疆瀛椾綋
		g.setFont(new Font("WJ",Font.BOLD,18));
		
		Random r=new Random();
		int a=r.nextInt(10000);
		Color c=new Color(r.nextInt(256),r.nextInt(256),r.nextInt(256));
		g.setColor(c);
		//灏嗙敓鎴愮殑闅忔満鏁版斁鍒皊ession涓幓锛�
		request.getSession().setAttribute("sCode", ""+a);
		g.drawString(""+a, 0, h);
		
		//璁剧疆骞叉壈绾�
		for(int i=0;i<15;i++)
		{
			Color c1=new Color(r.nextInt(256),r.nextInt(256),r.nextInt(256));
			g.setColor(c1);
			g.drawLine(r.nextInt(60), r.nextInt(30), r.nextInt(60), r.nextInt(30));
		}
		//璁╁浘鐢熸晥
		g.dispose();
		//鍐欏嚭鍥�
		ImageIO.write(img, "JPEG", response.getOutputStream());
	}

}
