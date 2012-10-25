package com.lg.dao.impl;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Vector;

import com.lg.common.DBTool;
import com.lg.dao.IBookDAO;
import com.lg.entity.Book;

public class BookDAO implements IBookDAO{
	@Override
	public List<Book> findAllBookInfo(int acid) {
		// TODO Auto-generated method stub
		Connection conn = DBTool.getInstance().getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Book> list = new Vector<Book>();
		try {
			ps = conn.prepareStatement("select b.bookid, bookTime, guest, guestAddress, PostCode, sendTime, " +
					" receiveTime, guestPhone, b.status from Book b where acid=?");
			ps.setInt(1, acid);
			rs = ps.executeQuery();
			while(rs.next())
			{
				Book b = new Book();
                b.setBookid(rs.getInt("bookid"));
                b.setBooktime(rs.getTimestamp("booktime"));
                b.setGuest(rs.getString("guest"));
                b.setGuestAddress(rs.getString("guestAddress"));
                b.setPostCode(rs.getString("PostCode"));
                b.setSendTime(rs.getTimestamp("sendTime"));
                b.setReceiveTime(rs.getTimestamp("receiveTime"));
                b.setGuestPhone(rs.getString("guestPhone"));
                b.setStatus(rs.getInt("status"));
                                     
                list.add(b);
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

	@Override
	public List<Book> findAllGoodsInfo(int acid) {
		// TODO Auto-generated method stub
		Connection conn = DBTool.getInstance().getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Book> list1 = new Vector<Book>();
		try {
			ps = conn.prepareStatement("select b.bookid, sbid, sb.gid, gcount, gname, gprice, brand,gimage from Book b, " +
					" goods g, subbook sb where b.bookid=sb.bookid and g.gid = sb.gid and b.acid=?");
			ps.setInt(1, acid);			
			rs = ps.executeQuery();
			while(rs.next())
			{
				Book b = new Book();
                b.setBookid(rs.getInt("bookid"));
                b.setSbookid(rs.getInt("sbid"));
                b.setSgid(rs.getInt("gid"));
                b.setGcount(rs.getInt("gcount"));
                b.setGname(rs.getString("gname"));
                b.setGprice(rs.getDouble("gprice"));
                b.setBrand(rs.getString("brand")); 
                b.setGimage(rs.getString("gimage"));
                list1.add(b);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			DBTool.closeAll(ps, rs);
		}
		return list1;
	}
	@Override
	public boolean addbook(Book book) {
		Connection conn = DBTool.getInstance().getConnection();
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement( "insert into Book(bookTime,guest,guestAddress,PostCode,guestPhone,status) values(?,?,?,?,?,?)");
			ps.setTimestamp(1, book.getBooktime());
			ps.setString(2, book.getGuest());
			ps.setString(3, book.getGuestAddress());
			ps.setString(4, book.getPostCode());
			ps.setString(5, book.getGuestPhone());
			ps.setInt(6, book.getStatus());
			if (ps.executeUpdate()>0) {
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBTool.closeAll(ps, null);
		}
		return false;

	}

	@Override
	public boolean addSubBook(Book sub) {
		Connection conn = DBTool.getInstance().getConnection();
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement( "insert into subbook(gid,gcount,bookid) values(?,?,?)");
			ps.setInt(1, sub.getGid());
			ps.setInt(2, sub.getGcount());
			ps.setInt(3, sub.getBookid());			
			if (ps.executeUpdate()>0) {
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBTool.closeAll(ps, null);
		}
		return false;
		
	}

	@Override
	public int getLastBookId(String guest) {
		Connection conn=DBTool.getInstance().getConnection();
		PreparedStatement stmt=null;
		ResultSet rs=null;
		int id=0;
		try {
			stmt=conn.prepareStatement("select bookid from book where guest=?  order by bookTime desc limit 1");
			stmt.setString(1, guest);
			rs=stmt.executeQuery();
			while (rs.next()) {
				id=rs.getInt("bookid");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			DBTool.closeAll(stmt, rs);
		}
		return id;
	}
}
