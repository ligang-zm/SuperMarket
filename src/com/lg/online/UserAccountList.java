package com.lg.online;

import java.util.Enumeration;
import java.util.Vector;

public class UserAccountList {
    private static final UserAccountList userlist=new UserAccountList();
    private Vector<String> vector;
    private UserAccountList(){
    	vector=new Vector<String>();
    }
    public static UserAccountList getInstance(){
		return userlist;
		
    	
    }
    public void addUser(String name){
    	if(name!=null){
    		vector.addElement(name);
    	}
    }
    public void removeUser(String name){
    	if(name!=null){
    		vector.removeElement(name);
    	}
    }
    public Enumeration<String>getUserList(){
    	return vector.elements();
    }
    public int getUserCount(){
    	return vector.size();
    }
}
