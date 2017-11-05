<%@ page language="java" contentType="text/html; charset=UTF-8"   pageEncoding="UTF-8"%>
<%
   String name=(String)session.getAttribute("username");
%>    
<footer class="footer w">  
  <div class="layout fix user-info">
    <div class="user-name fl" id="footerUserName" >
         <a href="" id="footerUserName" class="foot1" >当前用户:
         <span class="a"><%=name%></span></a>
    </div>
    <div class="fr"><a href="#" class="backTop" id="backTop">回顶部</a></div>
  </div>  
  <ul class="list-ui-a foot-list tc">    
    <li>
      <a href="" id="footerLogin" class="foot1">登录</a>
      <a href="" id="footerRegister" class="foot2">注册</a>       
      <a href="" id="shopCartTip" class="foot3">购物车</a>
    </li>
  </ul>
  <div class="tc copyright">Copyright© 2012-2018 m.ebuy.com</div>
</footer>
