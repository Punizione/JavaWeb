<%@ page language="java"  contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>欢迎登陆JSP留言板</title>
<link rel="stylesheet" type="text/css" href="style/main.css">
<style>
.item{padding-left:380px;position:relative;padding-bottom:10px;}
.label{width:360px;position:absolute;left:0;text-align:right;}
</style>
</head>
<body>
	<div class="header"></div>
	<div class="ui-widget-header" style="text-align:center">登录</div>
	<div class="ui-widget-content">
	<s:form id="form1" action="login.action" theme="simple" >
	<div>
		<span class="label">用户名</span>
		<div class="item">
		<s:textfield name="userName" ></s:textfield>
		</div>
	</div>
	<div>
		<span class="label">密码</span>
		<div class="item"><s:password name="password" ></s:password></div>
	</div>
	<div class="item">
		<s:submit value="确认" theme="simple"></s:submit>
		<s:reset  value="重写" theme="simple"></s:reset>
		<a href="register.jsp">没账号？立即注册</a>
	</div>
	</s:form>
</div>
	
</body>
</html>