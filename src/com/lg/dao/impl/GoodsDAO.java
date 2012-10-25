package com.lg.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import com.lg.common.DBTool;
import com.lg.dao.IGoodsDAO;
import com.lg.entity.Goods;
import com.lg.entity.Goods1;
import com.lg.entity.ShoppingInfo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
public class GoodsDAO implements IGoodsDAO{

	Connection conn = DBTool.getInstance().getConnection();
	PreparedStatement ps = null;
	ResultSet rs = null;
	public static List<ShoppingInfo> list=new ArrayList<ShoppingInfo>();;
	private  List<Goods> listGoods=null;
	private List<Goods1> listTopTen=null;
	private List<Goods1> listgoods=new ArrayList<Goods1>();
	public Collection getgoods()throws SQLException{
		Connection conn=null;
		Statement stmt=null;
		ResultSet rs=null;
		ArrayList<Goods1> goodlist=new ArrayList<Goods1>();
		try{
		conn=DBTool.getInstance().getConnection();
		stmt=conn.createStatement();
		rs=stmt.executeQuery("select * from goods");
		while (rs.next()) {
			Goods1 goods=new Goods1(rs.getInt(1),rs.getString(2), rs.getDouble(3),
					rs.getString(4),rs.getString(5), rs.getInt(6),rs.getInt(7),
					rs.getInt(8),rs.getString(9),rs.getString(10));
			goodlist.add(goods);
			
		}
		return goodlist;
	}
	
		finally{
			DBTool.closeAll(stmt, rs);
		}
	}

	/**
	 * 寰楀埌閫夋嫨鐨勫晢鍝佷俊鎭�
	 */
	public Goods1 getGoods(int gid)throws SQLException{
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		try{
		conn=DBTool.getInstance().getConnection();
		ps=conn.prepareStatement("select * from goods where gid=?");
        ps.setInt(1, gid);
        rs=ps.executeQuery();
        Goods1 goods=null;
		if(rs.next()){
			goods=new Goods1(rs.getInt(1),rs.getString(2), rs.getDouble(3),
					rs.getString(4),rs.getString(5), rs.getInt(6),rs.getInt(7),
					rs.getInt(8),rs.getString(9),rs.getString(10));
		}
		return goods;
	}
	
		finally{
			DBTool.closeAll(ps, rs);
		}
	}
	/**
	 * 閫氳繃鍏抽敭瀛楁悳绱㈠晢鍝佷俊鎭�
	 */
	public Collection searchgoods(String keyword)throws SQLException{
		Connection	conn=DBTool.getInstance().getConnection();
		PreparedStatement ps=null;
		ResultSet rs=null;
		ArrayList<Goods1> goodlist=new ArrayList<Goods1>();
		String sql="select gname,gimage,gprice from goods where gname like ?";
		try{
		ps= conn.prepareStatement(sql);
		ps.setString(1, "%"+keyword+"%");
        rs=ps.executeQuery();
		while(rs.next()){
			Goods1 gd1=new Goods1();
			  gd1.setGname(rs.getString("gname"));
			  gd1.setGimage(rs.getString("gimage"));
			  gd1.setGprice(rs.getDouble("gprice"));
				goodlist.add(gd1);
			
		}
		return goodlist;
	}
	
		finally{
			DBTool.closeAll(ps, rs);
		}
	}
	public Collection searchGoodsByBrand(String brand)throws SQLException{
		Connection	conn=DBTool.getInstance().getConnection();
		PreparedStatement ps=null;
		ResultSet rs=null;
		ArrayList<Goods1> goodlist=new ArrayList<Goods1>();
		String sql="select gname,gimage,gprice from goods where brand like ?";
		try{
		ps= conn.prepareStatement(sql);
		ps.setString(1, brand);
        rs=ps.executeQuery();
		while(rs.next()){
			Goods1 gd1=new Goods1();
			  gd1.setGname(rs.getString("gname"));
			  gd1.setGimage(rs.getString("gimage"));
			  gd1.setGprice(rs.getDouble("gprice"));
				goodlist.add(gd1);
			
		}
		return goodlist;
	}
	
		finally{
			DBTool.closeAll(ps, rs);
		}
	}
	public Collection searchGoodsByPrice(String gprice)throws SQLException{
		Connection	conn=DBTool.getInstance().getConnection();
		Statement stmt=null;
		ResultSet rs=null;
		ArrayList<Goods1> goodlist=new ArrayList<Goods1>();
		if(gprice.equals("1-499")){
			String sql="select gname,gimage,gprice from goods where gprice between 0 and 499";
			try{
				stmt=conn.createStatement();
				rs=stmt.executeQuery(sql);
				while(rs.next()){
				  Goods1 gd1=new Goods1();
				  gd1.setGname(rs.getString("gname"));
				  gd1.setGimage(rs.getString("gimage"));
				  gd1.setGprice(rs.getDouble("gprice"));
					goodlist.add(gd1);
				}
				return goodlist;
			}
			
				finally{
					DBTool.closeAll(ps, rs);
				}
		}
		else if(gprice.equals("500-999")){
			String sql="select  gname,gimage,gprice  from goods where gprice between 500 and 999";
			try{
				stmt=conn.createStatement();
				rs=stmt.executeQuery(sql);
				while(rs.next()){
					Goods1 gd1=new Goods1();
					  gd1.setGname(rs.getString("gname"));
					  gd1.setGimage(rs.getString("gimage"));
					  gd1.setGprice(rs.getDouble("gprice"));
						
					goodlist.add(gd1);
					
				}
				return goodlist;
			}
			
				finally{
					DBTool.closeAll(ps, rs);
				}
		}
		else if(gprice.equals("1000-1999")){
			String sql="select gname,gimage,gprice from goods where gprice between 1000 and 1999";
			try{
				stmt=conn.createStatement();
				rs=stmt.executeQuery(sql);
				while(rs.next()){
					Goods1 gd1=new Goods1();
					  gd1.setGname(rs.getString("gname"));
					  gd1.setGimage(rs.getString("gimage"));
					  gd1.setGprice(rs.getDouble("gprice"));
						
					goodlist.add(gd1);
					
				}
				return goodlist;
			}
			
				finally{
					DBTool.closeAll(ps, rs);
				}
			
		}
		else if(gprice.equals("2000-2999")){
			String sql="select gname,gimage,gprice from goods where gprice between 2000 and 2999";
			try{
				stmt=conn.createStatement();
				rs=stmt.executeQuery(sql);
				while(rs.next()){
					Goods1 gd1=new Goods1();
					  gd1.setGname(rs.getString("gname"));
					  gd1.setGimage(rs.getString("gimage"));
					  gd1.setGprice(rs.getDouble("gprice"));
						
					goodlist.add(gd1);
					
				}
				return goodlist;
			}
			
				finally{
					DBTool.closeAll(ps, rs);
				}
			
		}
		else if(gprice.equals("3000-3999")){
			String sql="select gname,gimage,gprice from goods where gprice between 3000 and 3999";
			try{
				stmt=conn.createStatement();
				rs=stmt.executeQuery(sql);
				while(rs.next()){
					Goods1 gd1=new Goods1();
					  gd1.setGname(rs.getString("gname"));
					  gd1.setGimage(rs.getString("gimage"));
					  gd1.setGprice(rs.getDouble("gprice"));
						
					goodlist.add(gd1);
					
				}
				return goodlist;
			}
			
				finally{
					DBTool.closeAll(ps, rs);
				}
			
		}
		else if(gprice.equals("4000-4999")){
			String sql="select gname,gimage,gprice from goods where gprice between 4000 and 4999";
			try{
				stmt=conn.createStatement();
				rs=stmt.executeQuery(sql);
				while(rs.next()){
					Goods1 gd1=new Goods1();
					  gd1.setGname(rs.getString("gname"));
					  gd1.setGimage(rs.getString("gimage"));
					  gd1.setGprice(rs.getDouble("gprice"));
						
					goodlist.add(gd1);
					
				}
				return goodlist;
			}
			
				finally{
					DBTool.closeAll(ps, rs);
				}
			
		}
		else if(gprice.equals(">4999")){
			String sql="select gname,gimage,gprice from goods where gprice >4999";
			try{
				stmt=conn.createStatement();
				rs=stmt.executeQuery(sql);
				while(rs.next()){
					Goods1 gd1=new Goods1();
					  gd1.setGname(rs.getString("gname"));
					  gd1.setGimage(rs.getString("gimage"));
					  gd1.setGprice(rs.getDouble("gprice"));
						
					goodlist.add(gd1);
				}
				return goodlist;
			}
			
				finally{
					DBTool.closeAll(ps, rs);
				}
		}
		return goodlist;
		
	}
	
	@Override
	public List<Goods1> findAllGoods() {
		return null;
		// TODO Auto-generated method stub
	}
	public Collection searchgoodsbyos(String os)throws SQLException{
		Connection	conn=DBTool.getInstance().getConnection();
		PreparedStatement ps=null;
		ResultSet rs=null;
		ArrayList<Goods1> goodlist=new ArrayList<Goods1>();
		String sql="select * from goods g,goodsstandard gs where g.gid=gs.gid and gs.os=?";
		try{
		ps=conn.prepareStatement(sql);
		 ps.setString(1, os);
        rs=ps.executeQuery();
		while(rs.next()){
		Goods1 goods=new Goods1(rs.getInt(1),rs.getString(2), rs.getDouble(3),
				rs.getString(4),rs.getString(5), rs.getInt(6),rs.getInt(7),
				rs.getInt(8),rs.getString(9),rs.getString(10));
			goodlist.add(goods);
			
		}
		return goodlist;
	}
	
		finally{
			DBTool.closeAll(ps, rs);
		}
	}
	public Collection searchgoodsbynet(String net)throws SQLException{
		Connection	conn=DBTool.getInstance().getConnection();
		PreparedStatement ps=null;
		ResultSet rs=null;
		ArrayList<Goods1> goodlist=new ArrayList<Goods1>();
		String sql="select g.gid,gname,gprice,gimage from goods g,goodsstandard gs where g.gid=gs.gid and gs.net=?";
		try{
		ps=conn.prepareStatement(sql);
		ps.setString(1, net);
        rs=ps.executeQuery();
		while(rs.next()){
			Goods1 gd1=new Goods1();
			  gd1.setGname(rs.getString("gname"));
			  gd1.setGimage(rs.getString("gimage"));
			  gd1.setGprice(rs.getDouble("gprice"));				
			goodlist.add(gd1);
			
		}
		return goodlist;
	}
	
		finally{
			DBTool.closeAll(ps, rs);
		}
	}
	@Override
	public Goods1 findGoodsByName(String gName) {
		
		Connection conn = DBTool.getInstance().getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		Goods1 gs = null;
		
		try {
			ps = conn.prepareStatement("select gid , area, gname, gprice, brand, gimage,  description, g.subcateid, " +
					" gstatus, store, gimage, subcateName, s.cateid, subDesc,cateName, cateDesc" +
					" from goods g, category c, subCategory s where gname=? and g.subcateid=s.subcateid" +
					" and s.cateid = c.cateid");
			ps.setString(1, gName);
			rs = ps.executeQuery();
			while(rs.next())
			{
				gs = new Goods1();
				gs.setGid(rs.getInt("gid"));
				gs.setArea(rs.getString("area"));
				gs.setGname(rs.getString("gname"));
				gs.setGprice(rs.getDouble("gprice"));
				gs.setBrand(rs.getString("brand"));
				gs.setDescription(rs.getString("description"));
				gs.setSubcateid(rs.getInt("subcateid"));
				gs.setGstatus(rs.getInt("gstatus"));
				gs.setStore(rs.getInt("store"));
				gs.setGimage(rs.getString("gimage"));
				gs.setCateid(rs.getInt("cateid"));
				gs.setSubcateid(rs.getInt("subcateid"));
				gs.setSubcateName(rs.getString("subcateName"));
				gs.setSubDesc(rs.getString("subDesc"));
				gs.setCateName(rs.getString("cateName"));
				gs.setCateDesc(rs.getString("cateDesc"));
				gs.setGimage(rs.getString("gimage"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			DBTool.closeAll(ps, rs);
		}
		
		return gs;
		// TODO Auto-generated method stub
	}

	@Override
	public Goods findGoodsStandardByName(String gName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Goods> getPriceClosedInfo(String gname) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Goods> findGoodsByBrand(String brand) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Goods> getSoldTopTen() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Goods> findGoodsByLocation(String location) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ShoppingInfo> addGoodToCart(ShoppingInfo si) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ShoppingInfo> updataGoodToCart(ShoppingInfo si, int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ShoppingInfo> deleteGoodfromCart(int index) {
		// TODO Auto-generated method stub
		return null;
	}

}