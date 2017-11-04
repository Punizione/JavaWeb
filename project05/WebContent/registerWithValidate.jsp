<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript">
  function fun_getVcode(){
    document.getElementById("vcodeimg1").src = "validatecode?"+Math.random(); 
} 
</script>
<link rel="stylesheet" type="text/css" href="css/module.css">
<link rel="stylesheet" type="text/css" href="css/member.css">
</head>
<body>
<nav class="w nav pr">
  <a class="goback" href="javascript:history.back(1)">返回</a>
  <div class="nav-title wb">用户注册</div>
  <div class="title-submit-ui-a">
    <a href="./login05.jsp">登录</a>
  </div>
</nav>
<!--页面顶部导航代码省略-->
<div class="login w f14">
<div class="signup layout f14" id="Sign_Check">
    <div class="regist-box" id="Login_Check">
      <div class="signup-tab-box tabBox ">
        <form  id="formRegister" name="formRegister" method="post" 
               action="sendEmailServlet">
          <ul class="input-list mt10">
            <li>
              <input type="text" class="input-ui-a" name="username" id="username"  
                    value="" placeholder="请输入您的邮箱地址">
              <p class="err-tips mt5 hide" id="p_egoAccountOfEmail_info">  
                 邮箱格式不正确</p>
            </li>
            <li>
              <input type="password" class="input-ui-a" name="password"  
                    maxlength="20" id="emailLogonPassword" value=""  
                    placeholder="请输入6-20位密码">
              <p class="err-tips mt5 hide" id="p_egoAcctEmailPwd_info">  
                 请输入6-20位密码</p>
            </li>
            <li>
              <input type="password" class="input-ui-a" name="PasswordVerify"  
                    maxlength="20" id="emailLogonPasswordVerify" value=""  
                    placeholder="请再次输入您的密码">
              <p class="err-tips mt5 hide" id="p_egoAcctEmailConfirmPwd_info"> 
                 请再次输入密码</p>
            </li>
            <li>
              <input type="text" class="input-ui-a half" name="verifyCode" id="verifyCode" 
                    maxlength="4" value="" placeholder="请输入验证码：">
              <input type="hidden" name="uuid" id="uuid"  
                   value="196f8850-5bda-4a68-b395-d0547549d4d1">
              <img id="vcodeimg1" src="validatecode" width="63" 
                   height="29" alt="验证码" onclick="fun_getVcode();">
              <a class="a" href="javascript:void(0);" onclick="fun_getVcode();">换一张</a>
              <p class="err-tips mt5 hide" id="p_emailValCode_info"> 
                 验证码输入不正确！</p>
            </li>
            <p class="err-tips mt10" id="normalLogonServerErrMsg"></p>
          </ul>
          <div class="btn-ui-b mt10"><a href="javascript:void(0);" 
              onclick="formRegister.submit();">注册</a></div>
          <div class="wbox a label-bind zhmm mt10">
            <label><input type="checkbox" class="input-checkbox-a f-les m-tops" 
                        id="epp_email_checked" checked="checked"></label>
            <div class="wbox-flex">
            <p>同意易购网触屏版会员章程</p>
            <p>同意易付宝协议，创建易付宝账户</p>
            <p class="err-tips mt5 hide" id="epp_email_checked_error">请确认此协议！</p>
            </div>
          </div>
</form>
      </div>
    </div>
  </div>
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