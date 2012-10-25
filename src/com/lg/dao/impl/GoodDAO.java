package com.lg.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.lg.common.DBTool;
import com.lg.dao.IGoodDAO;
import com.lg.entity.Goods;
import com.lg.entity.ShoppingInfo;
import com.lg.entity.Standard;
import com.sun.org.apache.bcel.internal.generic.NEW;

public class GoodDAO implements IGoodDAO{
	public static List<ShoppingInfo> list=new ArrayList<ShoppingInfo>();;
	private  List<Goods> listGoods=null;
	private List<Goods> listTopTen=null;
	private List<Goods> listLastDateFive=null;
	private List<Goods> listRandom=null;
	private List<Goods> listLastAppear=null;
	private List<Goods> listConditions=null;
	@Override
	public boolean addGood(Goods gd) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean deleteGood(int gid) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean updateGood(Goods gd) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Goods findGoodById(int gid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Goods findGoodByName(String gname) {
		// TODO Auto-generated method stub
		Connection conn=DBTool.getInstance().getConnection();
		PreparedStatement ps=null;
		Goods gd=null;
		ResultSet rs=null;
		try {
			ps=conn.prepareStatement("select gid,gname,gprice,brand,description,status,store,gimage from goods where gname=?");
			ps.setString(1, gname);                
			rs=ps.executeQuery();
			
			gd=new Goods();
			while(rs.next()){
				gd.setGid(rs.getInt("gid"));
				gd.setGname(rs.getString("gname"));
				gd.setPrice(rs.getDouble("gprice"));
				gd.setBrand(rs.getString("brand"));
				gd.setDesc(rs.getString("description"));
				gd.setStatus(rs.getInt("status"));
				gd.setStore(rs.getInt("store"));
				gd.setGimage(rs.getString("gimage"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			DBTool.closeAll(ps, rs);
		}
		return gd;
	}
	
	@Override
	public List<ShoppingInfo> addGoodToCart(ShoppingInfo si) {		
		list.add(si);
		return list;
	}

	@Override
	public List<ShoppingInfo> updataGoodToCart(ShoppingInfo si, int index) {
		list.set(index, si);
		return list;
	}

	@Override
	public List<ShoppingInfo> deleteGoodfromCart(int index) {
		list.remove(index);
		return list;
	}


	@Override
	public List<Goods> findGoodsByLocation(String location) {
		// TODO Auto-generated method stub
		
		Connection conn=DBTool.getInstance().getConnection();
		PreparedStatement ps=null;
		Goods gd=null;
		ResultSet rs=null;
		try {
			ps=conn.prepareStatement("select gid,gname,gprice,brand,description,status,store,gimage from goods where location=?");
			ps.setString(1, location);                
			rs=ps.executeQuery();
			listGoods=new ArrayList<Goods>();
			while(rs.next()){
				gd=new Goods();
				gd.setGid(rs.getInt("gid"));
				gd.setGname(rs.getString("gname"));
				gd.setPrice(rs.getDouble("gprice"));
				gd.setBrand(rs.getString("brand"));
				gd.setDesc(rs.getString("description"));
				gd.setStatus(rs.getInt("status"));
				gd.setStore(rs.getInt("store"));
				gd.setGimage(rs.getString("gimage"));
				listGoods.add(gd);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			DBTool.closeAll(ps, rs);
		}
		return listGoods;
	}

	@Override
	public List<Goods> getSoldTopTen() {
		Connection conn=DBTool.getInstance().getConnection();
		PreparedStatement ps=null;
		Goods gd=null;
		ResultSet rs=null;
		listTopTen=new ArrayList<Goods>();
		try {
			ps=conn.prepareStatement("select g.gname,g.gimage,g.gprice from goods g,soldcount s where g.gid=s.gid order by s.count desc limit 8");
		    rs=ps.executeQuery();
		    while(rs.next()){
		    	gd=new Goods();
		    	gd.setGname(rs.getString("gname"));
		    	gd.setGimage(rs.getString("gimage"));
		    	gd.setPrice(rs.getDouble("gprice"));
		    	listTopTen.add(gd);
		    }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			DBTool.closeAll(ps, rs);
		}
		return listTopTen;
	}

	@Override
	public List<Goods> findGoodsByBrand(String brand) {
		Connection conn=DBTool.getInstance().getConnection();
		PreparedStatement ps=null;
		Goods gd=null;
		ResultSet rs=null;
		try {
			ps=conn.prepareStatement("select gid,gname,gprice,brand,description,status,store,gimage from goods where brand=?");
			ps.setString(1, brand);                
			rs=ps.executeQuery();
			listGoods=new ArrayList<Goods>();
			while(rs.next()){
				gd=new Goods();
				gd.setGid(rs.getInt("gid"));
				gd.setGname(rs.getString("gname"));
				gd.setPrice(rs.getDouble("gprice"));
				gd.setBrand(rs.getString("brand"));
				gd.setDesc(rs.getString("description"));
				gd.setStatus(rs.getInt("status"));
				gd.setStore(rs.getInt("store"));
				gd.setGimage(rs.getString("gimage"));
				listGoods.add(gd);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			DBTool.closeAll(ps, rs);
		}
		return listGoods;
	}

	@Override
	public List<Goods> getPriceClosedInfo(String gname) {
		// TODO Auto-generated method stub
		Connection conn=DBTool.getInstance().getConnection();
		PreparedStatement ps=null;
		ResultSet rs=null;
		Goods gd=null;
		String currPrice="";
		List<Goods> listPC=null;
		try {
			ps=conn.prepareStatement("select gprice from goods where gname=?");
			ps.setString(1, gname);
		    rs=ps.executeQuery();
		    
		    while (rs.next()) {
		    	currPrice=String.valueOf(rs.getDouble("gprice"));
				
			}
		    
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			gd=new Goods();
			ps=conn.prepareStatement("select gname,gprice,gimage from goods where ABS(gprice-?)<500");
			double currPriceD=Double.parseDouble(currPrice);
			ps.setDouble(1, currPriceD);
			rs=ps.executeQuery();
			while(rs.next()){
			gd.setGname(rs.getString("gname"));
			gd.setPrice(rs.getDouble("gprice"));
			gd.setGimage(rs.getString("gimage"));
			listPC=new ArrayList<Goods>();
			listPC.add(gd);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			DBTool.closeAll(ps, rs);
		}
		return listPC;
	}
	@Override
	public Standard getStandard(String gname) {
		
		Connection conn=DBTool.getInstance().getConnection();
		PreparedStatement ps=null;
		Standard sd=null;
		ResultSet rs=null;
		try {
			ps=conn.prepareStatement("select gs.appeardate,gs.screensize,gs.seperation,gs.net,gs.os from goods g,goodsstandard gs where g.gid=gs.gid and g.gname=?");
			ps.setString(1, gname);                
			rs=ps.executeQuery();
			sd=new Standard();
			while(rs.next()){
				sd.setAppearDate(rs.getString("appeardate"));
				sd.setScreenSize(rs.getString("screensize"));
				sd.setSeperation(rs.getString("seperation"));
				sd.setNet(rs.getString("net"));
				sd.setOs(rs.getString("os"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			DBTool.closeAll(ps, rs);
		}
		return sd;
	}
	@Override
	public List<Goods> getLastDateFive() {
		Connection conn=DBTool.getInstance().getConnection();
		PreparedStatement ps=null;
		Goods gd=null;
		ResultSet rs=null;
		listLastDateFive=new ArrayList<Goods>();
		try {
			ps=conn.prepareStatement("select gname,gimage,gprice from goods  order by gdate desc limit 5");
		    rs=ps.executeQuery();
		    while(rs.next()){
		    	gd=new Goods();
		    	gd.setGname(rs.getString("gname"));
		    	gd.setGimage(rs.getString("gimage"));
		    	gd.setPrice(rs.getDouble("gprice"));
		    	listLastDateFive.add(gd);
		    }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			DBTool.closeAll(ps, rs);
		}
		return listLastDateFive;
	}
	@Override
	public List<Goods> getRandomInfo() {
		Connection conn=DBTool.getInstance().getConnection();
		PreparedStatement ps=null;
		Goods gd=null;
		ResultSet rs=null;
		listRandom=new ArrayList<Goods>();
		try {
			ps=conn.prepareStatement("select g.gname,g.gimage,g.gprice from goods g,soldcount s  limit 6");
		    rs=ps.executeQuery();
		    while(rs.next()){
		    	gd=new Goods();
		    	gd.setGname(rs.getString("gname"));
		    	gd.setGimage(rs.getString("gimage"));
		    	gd.setPrice(rs.getDouble("gprice"));
		    	listRandom.add(gd);
		    }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			DBTool.closeAll(ps, rs);
		}
		return listRandom;
	}
	@Override
	public List<Goods> getLastAppear() {
		Connection conn=DBTool.getInstance().getConnection();
		PreparedStatement ps=null;
		Goods gd=null;
		ResultSet rs=null;
		listLastAppear=new ArrayList<Goods>();
		try {
			ps=conn.prepareStatement("select g.gname,g.gimage,g.gprice from goods g,goodsstandard gt where g.gid=gt.gid order by gt.appeardate desc limit 5");
		    rs=ps.executeQuery();
		    while(rs.next()){
		    	gd=new Goods();
		    	gd.setGname(rs.getString("gname"));
		    	gd.setGimage(rs.getString("gimage"));
		    	gd.setPrice(rs.getDouble("gprice"));
		    	listLastAppear.add(gd);
		    }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			DBTool.closeAll(ps, rs);
		}
		return listLastAppear;
	}
	@Override
	public List<Goods> conditionsSearch(String net, String brand, String price,
			String os) {
		Connection conn=DBTool.getInstance().getConnection();
		PreparedStatement ps=null;
		ResultSet rs=null;
		Goods gd=null;
		listConditions=new ArrayList<Goods>();
		try {
			ps=conn.prepareStatement("select gname,gimage,gprice from goods where ? and ? and ? and ?");
			if(net!=null){
				ps.setString(1, "net="+net);
			}
			else{
				ps.setString(1, "1=1");
			}
			if(brand!=null){
				ps.setString(2, "brand="+brand);
			}
			else{
				ps.setString(2, "1=1");
			}
			if(price!=null){
				if(price.equals("250")){
				ps.setString(3, "gprice between 1 and 499");
				}
				if(price.equals("750")){
					ps.setString(3, "gprice between 500 and 999");
				}
				if(price.equals("1500")){
					ps.setString(3, "gprice between 1000 and 1999");
				}
				if(price.equals("2500")){
					ps.setString(3, "gprice between 2000 and 2999");
				}
				if(price.equals("3500")){
					ps.setString(3, "gprice between 3000 and 3999");
				}
				if(price.equals("4500")){
					ps.setString(3, "gprice between 4000 and 4999");
				}
				if(price.equals("5000")){
					ps.setString(3, "gprice >5000");
				}	
			}
			else{
				ps.setString(3, "1=1");
			}
			if(os!=null){
				ps.setString(4, "os="+os);
			}
			else{
				ps.setString(4, "1=1");
			}
			rs=ps.executeQuery();
			while(rs.next()){
				gd=new Goods();
				gd.setGimage(rs.getString("gimage"));
				gd.setGname(rs.getString("gname"));
				gd.setPrice(rs.getDouble("gprice"));
				listConditions.add(gd);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			DBTool.closeAll(ps, rs);
		}
		return listConditions;
	}
	@Override
	public int GetGid(String pname) {
		Connection conn=DBTool.getInstance().getConnection();
		PreparedStatement ps=null;
		Goods gd=null;
		ResultSet rs=null;
		int id=0;
		try {
			ps=conn.prepareStatement("select gid from goods where gname=?");
			ps.setString(1, pname);
		    rs=ps.executeQuery();
		    while(rs.next()){
		    	id=rs.getInt("gid");
		    }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			DBTool.closeAll(ps, rs);
		}
		
		return id;
	}

}
