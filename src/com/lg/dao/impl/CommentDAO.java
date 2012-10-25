package com.lg.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Vector;
 

import com.lg.common.DBTool;
import com.lg.dao.ICommentDAO;
import com.lg.entity.Comment;

public class CommentDAO implements ICommentDAO{

	@Override
	public boolean addComment(Comment comment) {
		Connection conn=DBTool.getInstance().getConnection();
		PreparedStatement ps=null;
		
		try {
			ps=conn.prepareStatement("insert into Comment(Context,cTime,acId,gId) values(?,?,?,?)");
			ps.setString(1, comment.getContext());
			ps.setDate(2, comment.getcTime());
			ps.setInt(3, comment.getAcId());
			ps.setInt(4, comment.getgId());
			if(ps.executeUpdate()>0)
			{
				return true;
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		finally{
			DBTool.closeAll(ps, null);
			 
		}
		
		return false;
	
	}

	@Override
	public List<Comment> findAllComment(int gId) {
		Connection conn=DBTool.getInstance().getConnection();
		PreparedStatement ps=null;
		ResultSet rs=null;
		List<Comment> list=new Vector<Comment>();
		System.out.println("wwwwwwwwwwww");
		try {
			ps=conn.prepareStatement("select cId,Context,cTime,acId,gid from Comment where gid=?");
			ps.setInt(1,gId);
			rs=ps.executeQuery();
			if(rs!=null)
			{
			while(rs.next())
			{
				Comment c=new Comment();
				c.setcId(rs.getInt("cId"));
				c.setContext(rs.getString("Context"));
				c.setcTime(rs.getDate("cTime"));
				c.setAcId(rs.getInt("acId"));
				c.setgId(rs.getInt("gId"));
				System.out.println(c.getAcId());
				list.add(c);
			}
			
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		finally{
	    	DBTool.closeAll(ps, rs); 
	     }
		
		return list;
	}
     

}
