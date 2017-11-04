<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>欢迎注册JSP留言板</title>
<link rel="stylesheet" type="text/css" href="style/main.css">
<style>
.item{padding-left:380px;position:relative;padding-bottom:10px;}
.label{width:360px;position:absolute;left:0;text-align:right;}
</style>
</head>
<body>
	<div class="header"></div>
	<div class="ui-widget-header" style="text-align:center">注册</div>
	<div class="ui-widget-content">
	<s:form id="form1" action="Reg.action" theme="simple">
	<div>
		<span class="label">用户名</span>
		<div class="item"><s:textfield name="userName" ></s:textfield>
		
		</div>
	</div>
	<div>
		<span class="label">密码</span>
		<div class="item"><s:password name="password" ></s:password></div>
	</div>
	<div>
		<span class="label">性别</span>
		<div class="item"><s:radio list="#{1:'女',2:'男'}" name="gender" value="1"></s:radio></div>
	</div>
	<div>
		<span class="label">头像</span>
		<div class="item">
		<input type="radio" name="head" value="1.gif" checked/><img src="images/head/1.gif">
		<input type="radio" name="head" value="2.gif"/><img src="images/head/2.gif">
		<input type="radio" name="head" value="3.gif"/><img src="images/head/3.gif">
		<input type="radio" name="head" value="4.gif"/><img src="images/head/4.gif">
		<input type="radio" name="head" value="5.gif"/><img src="images/head/5.gif"><br/>
		<input type="radio" name="head" value="6.gif"/><img src="images/head/6.gif">
		<input type="radio" name="head" value="7.gif"/><img src="images/head/7.gif">
		<input type="radio" name="head" value="8.gif"/><img src="images/head/8.gif">
		<input type="radio" name="head" value="9.gif"/><img src="images/head/9.gif">
		<input type="radio" name="head" value="10.gif"/><img src="images/head/10.gif"><br/>
		<input type="radio" name="head" value="11.gif"/><img src="images/head/11.gif">
		<input type="radio" name="head" value="12.gif"/><img src="images/head/12.gif">
		<input type="radio" name="head" value="13.gif"/><img src="images/head/13.gif">
		<input type="radio" name="head" value="14.gif"/><img src="images/head/14.gif">
		<input type="radio" name="head" value="15.gif"/><img src="images/head/15.gif">
		</div>
	</div>
	<div class="item">
		<s:submit value="注册" theme="simple"></s:submit>
		<s:reset  value="重写" theme="simple"></s:reset>
		
	</div>
	</s:form>
</div>
	
</body>
</html>