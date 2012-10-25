<%@page import="com.sun.java.swing.plaf.windows.resources.windows"%>
<%@page import="com.sun.xml.internal.txw2.Document"%>
<%@page import="java.sql.*"%>
<%@page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="css/mycss.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="js/jquery-1.8.0.js"></script>
<script type="text/javascript" src="js/jquery.flexslider.js"></script>
<link type="text/css" rel="stylesheet" href="css/flexslider.css">
<script type="text/javascript">
  $(function(){
   $(window).load(function() {
		$(".flexslider").flexslider({
			animation : "slide",
			directionNav :false,
			slideshowSpeed : 3000
		});
		$(".btn").click(function(){
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
    
     });
  });
  });
  function tips(id,str){
var l=document.getElementById(id).offsetLeft+300;
var t=document.getElementById(id).offsetTop+8;
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
  <h2 id="top"><a href="login1.jsp">登录页面</a><em> &gt; </em>修改密码
</h2>
  </div>
  <center>
  
  <div style="font-face:Microsoft Jhenghei;font-size:20px;background:url(img/3-52.jpg);background-repeat:no-repeat;width:380px;height:30px;">亲爱的，在此可以直接修改密码</div>
  <div>
    <form action="problem"method="post"> 
    <div id="tips" style="position:absolute;border:0px solid #ccc;padding:0px 3px;color:#f00;display:none;height:30px;line-height:20px;font-face:Microsoft Jhenghei;font-size:20px;"></div>
    <div class="div1"id="div1">用户名：<input type="text"class="txt"name="username"id="user"onfocus="tips('user','姓名长度2-20个字符')"onblur="outtips()"></div>
    <div id="msg"></div>
	<div class="div4"id="problem">密保问题:
    <select style="width:300px;height:40px;margin-left:48px;font-size:20px;font-face:Microsoft Jhenghei"name="problem">
      <option>最喜欢的一首歌</option>
      <option>最敬佩的人</option>
      <option>最想去的城市</option>
    </select></div>
    <div class="divpwd"id="ans">答案：<input type="text"class="txtpwd"name="answer"id="answ"onfocus="tips('answ','用于找回密码')"onblur="outtips()"></div>		
	<div class="divpwd"id="divpwd">密码：<input type="password" id="pwd"class="txtpwd"name="password"onfocus="tips('pwd','长度6-16个字符')"onblur="outtips()"></div>
  <div id="pwdmsg"></div>
  <div class="div3"id="divrepwd">再次输入密码：<input type="password" class="txt"id="repwd"name="repassword"onfocus="tips('repwd','请再次输入新密码')"onblur="outtips()"></div>
  <div id="repwdmsg"></div>
  <div class="divcode">验证码：<input type="text"class="txt"name="code"id="txtcode"><img border="0" src="./image"id="code"> 看不清？<a href="javascript:chkImg();">换一张</a></div>
  <div id="codemsg"></div>
  <div><input type="submit"value="确定"class="btn"style="margin-top:20px;"></div>
</form>
</div>
  </center>		
</body>
</html>