package com.lg.filter;

import java.util.Vector;

public class CommentFilter {
     public static String Filter(String str)
     {
    	 Vector<String> vec=new Vector<String>();
    	 vec.add("²Ù");
    	 vec.add("ÎÒ²Ù");
    	 vec.add("ÈÕ");
    	 vec.add("Éµ±Æ");
    	 vec.add("¿¿");
    	 vec.add("Êº");
    	 vec.add("ÄãÂè");
    	 vec.add("×°±Æ");
    	 vec.add("È¥ËÀ");
    	 vec.add("¹ö");
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
