<%@ page language="java"  contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<div class="header">
	<div class="welcomePanel">
		<s:if test="null!=#session.user.userName">
			 欢迎<s:property value="#session.user.userName"/>回来
			 <img alt="" src="images/split.jpg">
			 <a href="logout.action">登出</a>
		</s:if>	
			 </div>
			</div>