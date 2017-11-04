<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>留言列表</title>
<link rel="stylesheet" type="text/css" href="style/main.css">
</head>
<body>
	<%@ include file="header.jsp" %>
	<a href="addNote.action"><img src="images/book_write.png"/></a>
	<div class="ui-widget-header" style="text-align:center;">留言列表</div>
	<div class="col1">留言人</div>
	<div class="col2">主题</div>
		<s:iterator value="notes" var="note">
		<div class="clear"></div>
		<div class="col1">
			<s:property value="#note.user.userName"/>
		</div>
		<div class="col2">
		<s:a href="detail.action?noteId=%{#note.noteId}">
			<s:property value="#note.title"/></s:a>
		</div>
	</s:iterator>
	
</body>
</html>