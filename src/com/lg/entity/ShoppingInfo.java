package com.lg.entity;

public class ShoppingInfo implements java.io.Serializable{
	private String img;
	private int gid;
	private String address;
	private int count;
	private double price;
	private String gname;
	private int store;
    public int getStore() {
		return store;
	}
	public void setStore(int store) {
		this.store = store;
	}
	public ShoppingInfo(){
    	 
     }
	public ShoppingInfo(String img, int gid, String address, int count,
			double price, String gname ,int store) {
		super();
		this.img = img;
		this.gid = gid;
		this.address = address;
		this.count = count;
		this.price = price;
		this.gname = gname;
		this.store=store;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public int getGid() {
		return gid;
	}
	public void setGid(int gid) {
		this.gid = gid;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getGname() {
		return gname;
	}
	public void setGname(String gname) {
		this.gname = gname;
	}
}
