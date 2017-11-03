<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="project05.UserInfo" %>
<%
 String info=(String)request.getAttribute("info");
 if(info !=null){
  out.println(info);
}
 UserInfo user=(UserInfo)session.getAttribute("loginUser");
 if(user!=null){
   out.println("欢迎"+user.getName()+"光临易购网"); 
 }
%>
