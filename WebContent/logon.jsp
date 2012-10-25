<%@page import="com.sun.java.swing.plaf.windows.resources.windows"%>
<%@page import="com.sun.xml.internal.txw2.Document"%>
<%@page import="java.sql.*"%>
<%@page import="com.lg.common.DBTool"%>
<%@page import="com.lg.entity.UserAccount"%>
<%@page import="com.lg.dao.IUserDAO"%>
<%@page import="com.lg.dao.impl.UserDAO"%>
<%@page import="java.util.*"%>
<jsp:useBean id="smartupload" class="org.lxh.smart.SmartUpload"/>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>注册新用户</title>
<link href="css/mycss.css" rel="stylesheet" type="text/css">
<link type="text/css" rel="stylesheet" href="css/flexslider.css">
<script type="text/javascript" src="js/jquery-1.8.0.js"></script>
<script type="text/javascript" src="js/jquery.flexslider.js"></script>
<script type="text/javascript">
$(function(){
  $(window).load(function() {
		$(".flexslider").flexslider({
			animation : "slide",
			directionNav :false,
			slideshowSpeed : 3000
		});
		
 $(".logon").click(function(){
     var username=$("#user").val();
     if(username==null||username==""){
       $("#msg").html("<p>用户名不能为空</p>");
       $("#msg").css("color","red");
       return false;
      // event.preventDefault();
     }
    else if(username.length<2||username.length>20){
     
     $("#msg").html("<p>请输入2-20位字符</p>");
       $("#msg").css("color","red");
       return false;
     }
   
    var pwd=$("#pwd").val();
    if(pwd==null||pwd==""){
     
      $("#pwdmsg").html("<p>密码不能为空</p>");
       $("#pwdmsg").css("color","red");
       return false;
    }
   else if(pwd.length<6||pwd.length>20){
     
      $("#pwdmsg").html("<p>请确保密码长度范围在6-16位字符</p>");
       $("#pwdmsg").css("color","red");
       return false;
    }
  /*  else{
     $("#pwdmsg").html("<img src="images\success.png">");
    }*/
     var repwd=$("#repwd").val();
    if(!(pwd==repwd)){
   
      $("#repwdmsg").html("<p>两次输入的密码不一致</p>");
      $("#repwdmsg").css("color","red");
      return false;
    }
    
 /*   else{
    $("#pwdmsg").html("<img src='images\success.png'>");
    }*/
    
       var email =$("#email").val();
		var reg =  /^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+((\.[a-zA-Z0-9_-]{2,3}){1,2})$/;
		if(reg.test(email)==false)
		{ 
       $("#emailmsg").html("<p>邮箱格式不正确</p>");
       $("#emailmsg").css("color","red");
       return false;
		}
		
/*		else{
		$("#emailmsg").html("<img src='images\success.png'>");
		}*/
		 var year =$("#year").val();var month =$("#month").val();var day =$("#day").val();
	//	 var bir=\d{4}[年|\-|\.]\d{\1-\12}[月|\-|\.]\d{\1-\31}日?;
		if((month==4||month==6||month==9||month==11)&&day==31){
		   $("#birmsg").html("<p>日期不对</p>");
           $("#birmsg").css("color","red");
           return false;
		}
		if(year%100==0){
		  if(year%400==0&&month==2&&day>29){
		    $("#birmsg").html("<p>日期不对</p>");
           $("#birmsg").css("color","red");
           return false;
		  }
		}
		else{
		if(year%4==0&&month==2&&day>28){
		  $("#birmsg").html("<p>日期不对</p>");
           $("#birmsg").css("color","red");
           return false;
		}
		}
   });
   });
   
});

function tips(id,str){
var l=document.getElementById(id).offsetLeft+850;
var t=document.getElementById(id).offsetTop+110;
document.getElementById("tips").innerHTML="提示："+str;
document.getElementById("tips").style.left=l+"px";
document.getElementById("tips").style.top=t+"px";
document.getElementById("tips").style.display="";
}
function outtips(){
    document.getElementById("tips").style.display='none';
}
  function chkImg(){
	  var img = document.getElementById("code");
		var d = new Date();
		var t = d.getTime();
		img.src ="./image?"+t ;
  }    

</script>
</head>
<body>
 <%
 String getFileName=(String)session.getAttribute("img");
 
  %>
<div id="divtop">
    <ul class="t">
			<li>亲，欢迎来淘宝！</li>
			<li>请<a href="login1.jsp">登录</a></li>
			<li>收藏本站</li>
		</ul>
  </div> 
  <div>
  <h2 id="top">新用户注册</h2>
  </div>
  <table>
  <tr>
  <td width="500px;">
<div style="width:400px;height:150px;"><center><div style="background:url('img/1-7.jpg');width:120px;height:120px;"><img src="upload/<%=getFileName %>" width="120px"height="120px"></div></center></div>
<div class="div4"><font style="font-face:Microsoft Jhenghei;font-size:40px;"><b>上传头像</b></font></div>
<form action="userimg.jsp"method="post"enctype="multipart/form-data">
  <div class="div3">  <b>上传图片：</b>
  <input type="file" name="file"style="width:300px;height:30px;font-size:20px;"> <input type="submit" value="上传"style="font-size:20px;font-face:Microsoft Jhenghei;margin-top:10px;">
  </div>
 </form>
 <!--  <input type="submit" value="上传"style="font-size:20px;font-face:Microsoft Jhenghei;margin-top:10px;"> </div>  --> 
	  
  </td>
  
 <!--   <td style="width:800px;background:url('images/802.png')">-->
  <td style="width:800px;background:#EFEFEF">
 <form action="logon1"method="post"> 
  <div id="tips" style="position:absolute;border:0px solid #ccc;padding:0px 3px;color:#f00;display:none;height:30px;line-height:20px;font-face:Microsoft Jhenghei;font-size:20px;"></div>
  <div id="tips1" style="position:absolute;border:0px solid #ccc;padding:0px 3px;color:#f00;display:none;height:30px;line-height:20px;font-face:Microsoft Jhenghei;font-size:20px;"></div>
  <div class="div1"id="div1">用户名：<input type="text"class="txt"name="username"id="user"onfocus="tips('user','姓名长度2-20个字符')"onblur="outtips()"></div>
  <div id="msg"></div> 
  <div class="divpwd"id="divpwd">密码：<input type="password" id="pwd"class="txtpwd"name="password"onfocus="tips('pwd','长度6-16个字符')"onblur="outtips()"></div>
  <div id="pwdmsg"></div>
  <div class="div3"id="divrepwd">再次输入密码：<input type="password" class="txt"id="repwd"name="repassword"onfocus="tips('repwd','请再次输入新密码')"onblur="outtips()"></div>
  <div id="repwdmsg"></div>
   <div class="div4"id="problem">密保问题:
    <select style="width:300px;height:40px;margin-left:48px;font-size:20px;font-face:Microsoft Jhenghei"name="problem">
      <option>最喜欢的一首歌</option>
      <option>最敬佩的人</option>
      <option>最想去的城市</option>
    </select></div>
    <div class="divpwd"id="ans">答案：<input type="text"class="txtpwd"name="answer"id="answ"onfocus="tips('answ','用于找回密码')"onblur="outtips()"></div> 
  <div class="divemail">E-mail:<input type="text"class="txt"name="email"id="email"></div>
  <div id="emailmsg"></div>
  <div class="divemail">积分 ：<input type="text"class="txt"name="score"value="0"readonly="readonly"></div>
  <div class="div4"id="biryear">出生年月：
    <select id="year"name="year">
    <option>1994</option>
    <option>1993</option>
    <option>1992</option>
    <option>1991</option>
    <option>1990</option>
    <option>1989</option>
    <option>1988</option>
    <option>1987</option>
    <option>1986</option>
    <option>1985</option>
    <option>1984</option>
    <option>1983</option>
    <option>1982</option>
    <option>1981</option>
    <option>1980</option>
    </select>年
    <select id="month"name="month"> 
    <option>1</option>
    <option>2</option>
    <option>3</option>
    <option>4</option>
    <option>5</option>
    <option>6</option>
    <option>7</option>
    <option>8</option>
    <option>9</option>
    <option>10</option>
    <option>11</option>
    <option>12</option>
    </select>月
    <select id="day"name="day">
    <option>1</option>
    <option>2</option>
    <option>3</option>
    <option>4</option>
    <option>5</option>
    <option>6</option>
    <option>7</option>
    <option>8</option>
    <option>9</option>
    <option>10</option>
    <option>11</option>
    <option>12</option>
    <option>13</option>
    <option>14</option>
    <option>15</option>
    <option>16</option>
    <option>17</option>
    <option>18</option>
    <option>19</option>
    <option>20</option>
    <option>21</option>
    <option>22</option>
    <option>23</option>
    <option>24</option>
    <option>25</option>
    <option>26</option>
    <option>27</option>
    <option>28</option>
    <option>29</option>
    <option>30</option>
    <option>31</option>
    </select>日
  </div>
  <div id="birmsg"></div>
  <div class="div1">验证码：<input type="text"class="txt"name="code"id="txtcode"><img border="0" src="./image"id="code"> 看不清？<a href="javascript:chkImg();">换一张</a></div>
  <div id="codemsg"></div>
  <!--  <div class="div1">注册条款：<div id="checkmsg"></div><input type="checkbox"name="check"checked="checked"id="cb">我已仔细阅读并接受注册条款</div>-->
  <div style="margin-left:200px;margin-top:30px;"><input type="submit" value="注册"class="logon"></div>
</form></td>
  </tr>
  </table>
</body>
</html>