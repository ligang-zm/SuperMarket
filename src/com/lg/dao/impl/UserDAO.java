package com.lg.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.lg.common.DBTool;
import com.lg.dao.IUserDAO;
import com.lg.entity.UserAccount;


public class UserDAO implements IUserDAO{
	List<UserAccount>useList=new ArrayList<UserAccount>();
	@Override

	public boolean addUser(UserAccount ac) {
		Connection conn=DBTool.getInstance().getConnection();
		PreparedStatement ps=null;	
		try{
		ps=conn.prepareStatement("insert into useraccount(acName,acPassword,email,phone,address,userdesc," +
				"birthday,gender,avatar,score,grpId,userstatus,regIp,regTime,answer,problem) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
		
		ps.setString(1, ac.getAcName());
		ps.setString(2,ac.getAcPassword());
		ps.setString(3, ac.getEmail());
		ps.setString(4, ac.getPhone());
		ps.setString(5, ac.getAddress());
		ps.setString(6, ac.getUserdesc());
		ps.setString(7, ac.getBirthday());	
		ps.setInt(8, ac.getGender());
		ps.setString(9, ac.getAvator());
		ps.setInt(10, ac.getScore());
		ps.setInt(11, ac.getGrpId());
		ps.setInt(12, ac.getUserstatus());
		ps.setString(13, ac.getRegIp());
		ps.setTimestamp(14, ac.getRegTime());
		ps.setString(15, ac.getAnswer());
		ps.setString(16, ac.getProblem());
		ps.executeUpdate();
		return true;
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	finally{
		DBTool.closeAll(ps, null);
	}
		return false;
	}
	@Override
	public boolean deleteUser(int acId) {
		// TODO Auto-generated method stub
		return false;
	}
   
	@Override
	public boolean updateUser(String acname,String acpassword,String problem,String answer) {
		Connection conn=DBTool.getInstance().getConnection();
		PreparedStatement ps=null;
		ResultSet rs=null;
		int i = 0;
		boolean flag = false;
		try {
			ps=conn.prepareStatement("update useraccount set acPassword=? WHERE acName=? and problem=? and answer=? ");
			System.out.println(acpassword);
			ps.setString(1,acpassword );
			ps.setString(2, acname);
			System.out.println(problem);
			System.out.println(acname);
			System.out.println(answer);
			
			ps.setString(3,problem );
			ps.setString(4,answer);
			i = ps.executeUpdate();
			if(i > 0) {
				flag = true;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			DBTool.closeAll(ps, rs);
		}
		return flag;
	}

	public boolean checkUserByName(String acName) {
		Connection conn=DBTool.getInstance().getConnection();
		PreparedStatement ps=null;
		ResultSet rs=null;
		boolean truth=false;
		try {
			ps=conn.prepareStatement("select * from useraccount where acName=?");
			ps.setString(1,acName);
			rs=ps.executeQuery();
			while(rs.next()){
				truth=true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			DBTool.closeAll( ps, rs);
		}
		return truth;
	}

	@Override
	public UserAccount findUserByName(String acName) {
		Connection conn=DBTool.getInstance().getConnection();
		PreparedStatement ps=null;
		ResultSet rs=null;
		UserAccount ac=null;
		try {
			ps=conn.prepareStatement("select * from useraccount where acName=?");
			ps.setString(1, acName);
			rs=ps.executeQuery();
			while(rs.next()){
				ac=new UserAccount();
				
				ac.setAcName(rs.getString("acName"));
				ac.setAcPassword(rs.getString("acPassword"));
				ac.setEmail(rs.getString("email"));
				ac.setPhone(rs.getString("phone"));
				ac.setAddress(rs.getString("address"));
				ac.setUserdesc(rs.getString("userdesc"));
				ac.setBirthday(rs.getString("birthday"));
				ac.setGender(rs.getInt("gender"));
				ac.setAvator(rs.getString("avator"));
				ac.setScore(rs.getInt("score"));
				ac.setGrpId(rs.getInt("grpid"));
				ac.setUserstatus(rs.getInt("userstatus"));
				ac.setRegIp(rs.getString("regip"));
				ac.setRegTime(rs.getTimestamp("regTime"));
				ac.setProblem(rs.getString("problem"));
				ac.setAnswer(rs.getString("answer"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			DBTool.closeAll( ps, rs);
		}
		return ac;
	}

	@Override
	public List<UserAccount> findAllUsers() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public boolean findUser(String acName) {
		return false;
		
		 
		
	}
	@Override
	public UserAccount findUserById(int acId) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public boolean updateUser(UserAccount ac) {
		// TODO Auto-generated method stub
		return false;
	}
	
	

	

}


