package com.lg.filter;

import java.util.Vector;

public class CommentFilter {
     public static String Filter(String str)
     {
    	 Vector<String> vec=new Vector<String>();
    	 vec.add("��");
    	 vec.add("�Ҳ�");
    	 vec.add("��");
    	 vec.add("ɵ��");
    	 vec.add("��");
    	 vec.add("ʺ");
    	 vec.add("����");
    	 vec.add("װ��");
    	 vec.add("ȥ��");
    	 vec.add("��");
    	 if(null==str||"".equals(str))
    	 {
    		 
    	 }
    	 else{
    		for(int i=0;i<vec.size();i++)
    		{   
    			str=str.replace(vec.elementAt(i).toString(), "***");
    		}
    	 }
    	 return str; 
     }


}
