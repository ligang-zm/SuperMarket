package com.lg.entity;

public class Goods {
	private int gid;
	private String gname;
	private double price;
	private String brand;
	private String desc;
	private int store;
	private  String gimage;
	private int status;
	private String area;
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public Goods() {
		// TODO Auto-generated constructor stub
	}
	public Goods(int gid, String gname, double price, String brand,
			String desc, int store, String gimage,int status,String area) {
		super();
		this.gid = gid;
		this.gname = gname;
		this.price = price;
		this.brand = brand;
		this.desc = desc;
		this.gimage = gimage;
		this.store=store;
		this.status=status;
		this.area=area;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public int getStore() {
		return store;
	}
	public void setStore(int store) {
		this.store = store;
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
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public String getGimage() {
		return gimage;
	}
	public void setGimage(String gimage) {
		this.gimage = gimage;
	}
	
}
