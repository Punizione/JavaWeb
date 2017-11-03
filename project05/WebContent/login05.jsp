<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/member.js"></script>
<script type="text/javascript" src="js/sntouch.js"></script>
<link rel="stylesheet" type="text/css" href="css/module.css">
<link rel="stylesheet" type="text/css" href="css/member.css">


<script type="text/javascript">
	function checkForm(){
	  var retFlag = true;
	  var email2 =  $("#email2").val();
	  var password = $("#password").val();
	  if(email2 == ""){
	  retFlag = false;
	  }
	  if (password == null || password == "") {
	  retFlag = false;
	  }
	  return retFlag;
	}
	function submitForm(){
	  if(!checkNormalLogonId() || !checkNormalLogonPwd()) {
	  return;
	  }
	  if(checkForm()){
	  $("#formlogon").submit();
	  return true;
	  }else{
	  return false;
	  }
	}
	$(function(){
	  $("#email2").blur(function(){
	  var email2 =  $("#email2").val();
	  if($(this).val() == ''){
	    $("#logonIdErrMsg").html('请输入昵称/邮箱/注册手机！');
	    $("#logonIdErrMsg").show();
	    } else if (email2.match( /^\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*$/ )) {
	    $("#logonIdErrMsg").html('');
	    return true;
	    }
	  })
	$("#password").blur(function(){
	  var pwd = $('#password').val();
	  if (pwd == null || pwd == "") {
	  $("#passwordErrMsg").html('请输入密码！');
	  $("#passwordErrMsg").show();
	  } else if (pwd.length<6 || pwd.length>20) {
	  $("#passwordErrMsg").html('请输入6-20位密码！');
	  $("#passwordErrMsg").show();
	  } else {
	  $("#passwordErrMsg").html('');
	  return true;
	  }
	  })
	  showServerErrorMsg();
	});
	function checkNormalLogonId() {
	// 清掉服务器错误消息
	  $("#normalLogonServerErrMsg").hide();
	  var eml = $('#email2').val();
	  if(eml=='昵称/邮箱/注册手机'){
	  //$('#email2').val("");
	  eml = "";
	  }
	  if (eml == null || eml == "") {
	  $("#logonIdErrMsg").show().html('<em class="tipFalse"></em>请输入昵称/邮箱/注册手机！');
	  return false;
	  }
	  if (eml.length != 0 && eml.length < 50
	  && eml.match( /^\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*$/ )){
	  $('#logonId').val(eml.toLowerCase());
	  } else {
	  $('#logonId').val(eml);
	  }
	  $("#logonIdErrMsg").html('');
	  return true;
	}
	function checkNormalLogonPwd() {
	  // 清掉服务器错误消息
	  $("#normalLogonServerErrMsg").hide();
	  var pwd = $('#password').val();
	  if (pwd == null || pwd == "") {
	  $("#passwordErrMsg").show().html('<em class="tipFalse"></em>请输入密码！');
	  return false;
	  } else if (pwd.length<6 || pwd.length>20) {
	  $("#passwordErrMsg").show().html('<em class="tipFalse"></em>请输入6-20位密码！');
	  return false;
	  } else {
	  $("#passwordErrMsg").html('');
	  return true;
	  }
	}
	function fun_getVcode(){
	  var timenow = new Date().getTime();
	  var uid = document.getElementById("uuid").value;  
	  document.getElementById("vcodeimg1").src =   
	        "https://vcs.suning.com/vcs/imageCode.htm?uuid="+ uid +"&yys=" + timenow;
	}
</script>


</head>
<body>
<nav class="w nav pr">
  <a class="goback" href="javascript:history.back(1)">返回</a>
  <div class="nav-title wb">用户登录</div>
  <div class="title-submit-ui-a">
    <a href="./register05.jsp">注册</a>
  </div>
</nav>

<!--页面顶部导航代码省略-->
<div class="login w f14">
<form id="formlogon" name="formlogon" method="post" action="validateYZMServlet" >
  <ul class="input-list mt10" id="Login_Check">
    <li>
      <input type="text" class="input-ui-a" placeholder="用户名:手机/邮箱/昵称" 
            name="login_username" id="email2" value="">
      <p class="err-tips mt5 hide" id="logonIdErrMsg">请输入用户名！</p>
    </li>
    <li>
      <input type="password" class="input-ui-a" placeholder="密码：" 
            name="login_password" id="password" maxlength="20">
      <p class="err-tips mt5 hide" id="passwordErrMsg">请输入密码！</p>
    </li>    
    <li>
      <input type="text" class="input-ui-a half" id="validate" name="verifyCode"  
            maxlength="4" placeholder="验证码：">
      <img id="vcodeimg1" src="validatecode" width="63" height="29" alt="验证码"  
          onclick="fun_getVcode();">
      <a class="a" href="javascript:void(0);" onclick="fun_getVcode();">换一张  
      </a>&nbsp;&nbsp;&nbsp;&nbsp;
      <p class="err-tips mt5 hide" id="vcodeErrMsg">验证码输入不正确！</p>
    </li>  
  </ul>   
  <div class="btn-ui-b mt10">
  <a href="javascript:void(0);" onclick="return submitForm();">登录</a>
  </div>
</form>
</div>
<!--页面底部导航代码省略-->
<div id="footer" class="w">
  <ul class="list-ui-a">
    <li>
     <div class="w user-login">
       <a href="#" id="footerLogin" style="">登录</a>
       <a href="#" id="footerRegister" style="">注册</a>
<a href="#" >购物车</a>
     </div>
    </li>
  </ul>
  <div class="copyright">Copyright© 2012-2018 m.ebuy.com</div>
</div>

</body>

</html>