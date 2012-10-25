package com.lg.entity;

import java.sql.Timestamp;

public class Book {
private int bookid;
private Timestamp booktime; 
private String guest;
private String guestAddress;
private String PostCode;
private Timestamp sendTime;
private Timestamp receiveTime;
private String guestPhone;
private int status;


private int sbid;
private int sgid;
private int gcount;
private int sbookid;
private int gid;
private String gname;
private double gprice;
private String brand;
private String description;
private  String gimage1;
public String getGimage1() {
	return gimage1;
}
public void setGimage1(String gimage1) {
	this.gimage1 = gimage1;
}
private int subcateid;
public int getBookid() {
	return bookid;
}
public void setBookid(int bookid) {
	this.bookid = bookid;
}
public Timestamp getBooktime() {
	return booktime;
}
public void setBooktime(Timestamp booktime) {
	this.booktime = booktime;
}
public String getGuest() {
	return guest;
}
public void setGuest(String guest) {
	this.guest = guest;
}
public String getGuestAddress() {
	return guestAddress;
}
public void setGuestAddress(String guestAddress) {
	this.guestAddress = guestAddress;
}
public String getPostCode() {
	return PostCode;
}
public void setPostCode(String postCode) {
	PostCode = postCode;
}
public Timestamp getSendTime() {
	return sendTime;
}
public void setSendTime(Timestamp sendTime) {
	this.sendTime = sendTime;
}
public Timestamp getReceiveTime() {
	return receiveTime;
}
public void setReceiveTime(Timestamp receiveTime) {
	this.receiveTime = receiveTime;
}
public String getGuestPhone() {
	return guestPhone;
}
public void setGuestPhone(String guestPhone) {
	this.guestPhone = guestPhone;
}
public int getStatus() {
	return status;
}
public void setStatus(int status) {
	this.status = status;
}
public int getSbid() {
	return sbid;
}
public void setSbid(int sbid) {
	this.sbid = sbid;
}
public int getSgid() {
	return sgid;
}
public void setSgid(int sgid) {
	this.sgid = sgid;
}
public int getGcount() {
	return gcount;
}
public void setGcount(int gcount) {
	this.gcount = gcount;
}
public int getSbookid() {
	return sbookid;
}
public void setSbookid(int sbookid) {
	this.sbookid = sbookid;
}
public int getGid() {
	return gid;
}
public void setGid(int gid) {
	this.gid = gid;
}
public String getGname() {
	return gname;
}
public void setGname(String gname) {
	this.gname = gname;
}
public double getGprice() {
	return gprice;
}
public void setGprice(double gprice) {
	this.gprice = gprice;
}
public String getBrand() {
	return brand;
}
public void setBrand(String brand) {
	this.brand = brand;
}
public String getDescription() {
	return description;
}
public void setDescription(String description) {
	this.description = description;
}
public int getSubcateid() {
	return subcateid;
}
public void setSubcateid(int subcateid) {
	this.subcateid = subcateid;
}
public int getStore() {
	return store;
}
public void setStore(int store) {
	this.store = store;
}
public String getGimage() {
	return gimage;
}
public void setGimage(String gimage) {
	this.gimage = gimage;
}
public Book(int bookid, Timestamp booktime, String guest, String guestAddress,
		String postCode, Timestamp sendTime, Timestamp receiveTime,
		String guestPhone, int status, int sbid, int sgid, int gcount,
		int sbookid, int gid, String gname, double gprice, String brand,
		String description, int subcateid, int store, String gimage) {
	super();
	this.bookid = bookid;
	this.booktime = booktime;
	this.guest = guest;
	this.guestAddress = guestAddress;
	PostCode = postCode;
	this.sendTime = sendTime;
	this.receiveTime = receiveTime;
	this.guestPhone = guestPhone;
	this.status = status;
	this.sbid = sbid;
	this.sgid = sgid;
	this.gcount = gcount;
	this.sbookid = sbookid;
	this.gid = gid;
	this.gname = gname;
	this.gprice = gprice;
	this.brand = brand;
	this.description = description;
	this.subcateid = subcateid;
	this.store = store;
	this.gimage = gimage;
}
public Book() {
	super();
	// TODO Auto-generated constructor stub
}
private int store;
private String gimage;
}
