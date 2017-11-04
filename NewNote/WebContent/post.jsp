<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>新留言</title>
<link rel="stylesheet" type="text/css" href="style/main.css">
</head>
<body>
<%@include file="header.jsp" %>
<div class="mainDiv">
<div class="ui-widget-header" style="text-align:center;">新留言</div>
<s:form name="form1" action="addNote.action"  theme="simple">
	<div class="col1">标题</div>
	<div class="col2">
		<s:textfield name="title" size="50">
		</s:textfield>
	</div>
	<div class="col1">内容</div>
	<div class="col2">
	<s:textarea rows="20" cols="60" name="content"></s:textarea><br/>
	</div>
	<div class="col2">
		<s:submit value="确定" theme="simple"></s:submit>
		<s:reset value="重填"></s:reset>
	</div>
	</s:form>
	</div>
</body>
</html>