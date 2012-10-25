package com.lg.entity;

import java.sql.Timestamp;

public class Goods1 {
	  private int gid;
	  private String gname;
	  private double gprice;
	  private String brand;
	  private String description;
	  private int subcateid;
	  private int gstatus;
	  private int store;
	  private String gimage;
	  private String area;
	  private int gsid;
	  private int sid;
	  private Timestamp AppearDate;
	  private double screensize;
	  private String seperation;
	  private int cateid;
	  private String cateName;
	  private String cateDesc;
	  private String subcateName;
	  private String subDesc;
	public Goods1() {
		// TODO Auto-generated constructor stub
	}
	public Goods1(int gid, String gname, double gprice, String brand,
			String description, int subcateid, int gstatus, int store,
			String gimage, String area, int gsid, int sid,
			Timestamp appearDate, double screensize, String seperation,
			int cateid, String cateName, String cateDesc, String subcateName,
			String subDesc) {
		this.gid = gid;
		this.gname = gname;
		this.gprice = gprice;
		this.brand = brand;
		this.description = description;
		this.subcateid = subcateid;
		this.gstatus = gstatus;
		this.store = store;
		this.gimage = gimage;
		this.area = area;
		this.gsid = gsid;
		this.sid = sid;
		AppearDate = appearDate;
		this.screensize = screensize;
		this.seperation = seperation;
		this.cateid = cateid;
		this.cateName = cateName;
		this.cateDesc = cateDesc;
		this.subcateName = subcateName;
		this.subDesc = subDesc;
	}
	public Goods1(int gid, String gname, double gprice, String brand,
			String description, int subcateid, int gstatus, int store,
			String gimage, String area) {
		this.gid = gid;
		this.gname = gname;
		this.gprice = gprice;
		this.brand = brand;
		this.description = description;
		this.subcateid = subcateid;
		this.gstatus = gstatus;
		this.store = store;
		this.gimage = gimage;
		this.area = area;
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
	public int getGstatus() {
		return gstatus;
	}
	public void setGstatus(int gstatus) {
		this.gstatus = gstatus;
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
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public int getGsid() {
		return gsid;
	}
	public void setGsid(int gsid) {
		this.gsid = gsid;
	}
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public Timestamp getAppearDate() {
		return AppearDate;
	}
	public void setAppearDate(Timestamp appearDate) {
		AppearDate = appearDate;
	}
	public double getScreensize() {
		return screensize;
	}
	public void setScreensize(double screensize) {
		this.screensize = screensize;
	}
	public String getSeperation() {
		return seperation;
	}
	public void setSeperation(String seperation) {
		this.seperation = seperation;
	}
	public int getCateid() {
		return cateid;
	}
	public void setCateid(int cateid) {
		this.cateid = cateid;
	}
	public String getCateName() {
		return cateName;
	}
	public void setCateName(String cateName) {
		this.cateName = cateName;
	}
	public String getCateDesc() {
		return cateDesc;
	}
	public void setCateDesc(String cateDesc) {
		this.cateDesc = cateDesc;
	}
	public String getSubcateName() {
		return subcateName;
	}
	public void setSubcateName(String subcateName) {
		this.subcateName = subcateName;
	}
	public String getSubDesc() {
		return subDesc;
	}
	public void setSubDesc(String subDesc) {
		this.subDesc = subDesc;
	}
	
}
