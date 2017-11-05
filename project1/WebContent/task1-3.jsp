<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
<head>
  <meta charset="UTF-8">
  <meta name="apple-mobile-web-app-capable" content="yes" />
  <meta name="apple-mobile-web-app-status-bar-style" content="black" />
  <title>易购网触屏版</title>
  <link rel="stylesheet" type="text/css" href="css/base.css">
  <link rel="stylesheet" type="text/css" href="css/view.css">
</head>
<body>
<%
   String strName=request.getParameter("logonName").trim();
   session.setAttribute("username",strName);
%>
<%@ include file="top1-3.jsp" %>
<div class="w f14">
  <ul class="easy-header fix" style="background:url(images/background.jpg)">
    <li class="img-header">
      <a href="#">
        <img src="images/1_120x120.jpg" alt="" width="63" height="63">
      </a>
    </li>
    <li class="header-text">
       <%  if (strName.length()>0){   %>     
       <span>您好！</span> <%=strName%>
    <span><br />欢迎来到易购网！&nbsp;&nbsp;</span>
       <%}
         else{
       %>           
       <span>您好！请先登录 </span>
      <% } %>  
    </li>
  </ul>    
</div>
<jsp:include page="bottom1-3.jsp" />
</body>
</html>
