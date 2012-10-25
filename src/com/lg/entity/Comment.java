package com.lg.entity;
import java.sql.Date;

public class Comment {
    public int cId;
	private String Context;
    private Date cTime;
    private int acId;
    private int gId;
    
    public int getcId() {
		return cId;
	}

	public void setcId(int cId) {
		this.cId = cId;
	}

    public String getContext() {
		return Context;
	}

	public void setContext(String context) {
		Context = context;
	}

	public Date getcTime() {
		return cTime;
	}

	public void setcTime(Date cTime) {
		this.cTime = cTime;
	}

	public int getAcId() {
		return acId;
	}

	public void setAcId(int acId) {
		this.acId = acId;
	}

	public int getgId() {
		return gId;
	}

	public void setgId(int gId) {
		this.gId = gId;
	}

	
    
    public Comment()
    {
    	
    }
    
    public Comment(String Context,Date cTime,int acId,int gId)
    {
    	this.Context=Context;
    	this.cTime=cTime;
    	this.acId=acId;
    	this.gId=gId;
    }
}
