package com.lg.entity;

import java.sql.Timestamp;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;

import com.lg.online.UserAccountList;

public class UserAccount implements HttpSessionBindingListener{

	
 
    private String acName;
    private String acPassword;
    private String email;
    private String phone;
    private String address;
    private String userdesc;
    private String birthday;
    private int gender;
    private String avator;
    private int score;
    private int grpId;
    private int userstatus;
    private String regIp;
    private Timestamp regTime;
    private String answer;
    private String problem;
    private int acid;
    public int getAcid() {
		return acid;
	}


	public void setAcid(int acid) {
		this.acid = acid;
	}
	private UserAccountList ul=UserAccountList.getInstance();
	public UserAccount() {
		// TODO Auto-generated constructor stub
	}
	
	
	public UserAccount(String acName, String acPassword, String email,
			String phone, String address, String userdesc,String birthday,
			int gender, String avator, int score, int grpId, int userstatus,
			String regIp, Timestamp regTime,String answer,String problem, UserAccountList ul) {
		this.acName = acName;
		this.acPassword = acPassword;
		this.email = email;
		this.phone = phone;
		this.address = address;
		this.userdesc = userdesc;
		this.birthday = birthday;
		this.gender = gender;
		this.avator = avator;
		this.score = score;
		this.grpId = grpId;
		this.userstatus = userstatus;
		this.regIp = regIp;
		this.regTime = regTime;
		this.answer=answer;
		this.problem=problem;
		this.ul = ul;
	}


	

	public String getAcName() {
		return acName;
	}


	public void setAcName(String acName) {
		this.acName = acName;
	}


	public String getAcPassword() {
		return acPassword;
	}


	public void setAcPassword(String acPassword) {
		this.acPassword = acPassword;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public String getUserdesc() {
		return userdesc;
	}


	public void setUserdesc(String userdesc) {
		this.userdesc = userdesc;
	}

	public String getBirthday() {
		return birthday;
	}


	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}


	public int getGender() {
		return gender;
	}


	public void setGender(int gender) {
		this.gender = gender;
	}


	public String getAvator() {
		return avator;
	}


	public void setAvator(String avator) {
		this.avator = avator;
	}


	public int getScore() {
		return score;
	}


	public void setScore(int score) {
		this.score = score;
	}


	public int getGrpId() {
		return grpId;
	}


	public void setGrpId(int grpId) {
		this.grpId = grpId;
	}


	public int getUserstatus() {
		return userstatus;
	}


	public void setUserstatus(int userstatus) {
		this.userstatus = userstatus;
	}


	public String getRegIp() {
		return regIp;
	}


	public void setRegIp(String regIp) {
		this.regIp = regIp;
	}


	public Timestamp getRegTime() {
		return regTime;
	}


	public void setRegTime(Timestamp regTime) {
		this.regTime = regTime;
	}


	public String getProblem() {
		return problem;
	}


	public void setProblem(String problem) {
		this.problem = problem;
	}
	public String getAnswer() {
		return answer;
	}


	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public UserAccountList getUl() {
		return ul;
	}


	public void setUl(UserAccountList ul) {
		this.ul = ul;
	}


	@Override
	public void valueBound(HttpSessionBindingEvent event) {
		// TODO Auto-generated method stub
		ul.addUser(acName);
	}
	@Override
	public void valueUnbound(HttpSessionBindingEvent event) {
		// TODO Auto-generated method stub
		ul.removeUser(acName);
	}

	
	
	
	
	
}
