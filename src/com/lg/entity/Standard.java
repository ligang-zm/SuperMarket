package com.lg.entity;

public class Standard {
	private String appearDate;
	private String screenSize;
	private String seperation;
	private String net;
	private String os;
	public Standard() {
		// TODO Auto-generated constructor stub
	}
	public Standard(String appearDate, String screenSize, String seperation,
			String net, String os) {
		super();
		this.appearDate = appearDate;
		this.screenSize = screenSize;
		this.seperation = seperation;
		this.net = net;
		this.os = os;
	}
	public String getAppearDate() {
		return appearDate;
	}
	public void setAppearDate(String appearDate) {
		this.appearDate = appearDate;
	}
	public String getScreenSize() {
		return screenSize;
	}
	public void setScreenSize(String screenSize) {
		this.screenSize = screenSize;
	}
	public String getSeperation() {
		return seperation;
	}
	public void setSeperation(String seperation) {
		this.seperation = seperation;
	}
	public String getNet() {
		return net;
	}
	public void setNet(String net) {
		this.net = net;
	}
	public String getOs() {
		return os;
	}
	public void setOs(String os) {
		this.os = os;
	}
	
}
