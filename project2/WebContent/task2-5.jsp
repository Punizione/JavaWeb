<%@page import="package02.CountFileHandler2_5"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
  long count=CountFileHandler2_5.readFile(request.getRealPath("/")+"count.txt");
  if(session.getAttribute("visited")==null){
    session.setAttribute("visited","y");
    session.setMaxInactiveInterval(60*60*24);
    count=count+1;
    CountFileHandler2_5.writeFile(request.getRealPath("/")+"count.txt",count);
}
%>
<%!
public String getCounter(long count){
  String countNumber=count+"";
  String newNumber="";
  for(int i=0 ; i<countNumber.length() ; i++){
    newNumber=newNumber+"<img src=\"images\\"+countNumber.charAt(i)+".gif\">";
  }
  return newNumber;
}
%>

<!DOCTYPE HTML>
<html>
<head>
  <meta charset="UTF-8">
  <meta name="apple-mobile-web-app-capable" content="yes" />
  <meta name="apple-mobile-web-app-status-bar-style" content="black" />
  <link rel="stylesheet" type="text/css" href="css/base.css">
   <link rel="stylesheet" type="text/css" href="css/view.css">
  <title>易购网触屏版</title>
  <link rel="stylesheet" type="text/css" href="css/base.css">
  <link rel="stylesheet" type="text/css" href="css/view.css">
</head>
<body>
<div class="w f14">
  <ul class="easy-header fix" style="background:url(images/background.jpg)">
    <li class="img-header">
      <a href="#">
        <img src="images/1_120x120.jpg" alt="" width="63" height="63">
      </a>
    </li>
    <li class="header-text">
      <span>您好！LiMing</span>
      <span><br />欢迎来到易购网！</span>
    </li>
  </ul>
  <div class="easy-box-con">
    <ul class="easy-parent">
    <li class="fix">
      <a href="#" >
      <img src="images/all-order.png" alt=""><span>全部订单</span></a>
      <a href="#" >
      <img src="images/easy-pay.png" alt=""><span>易付宝</span></a>  
      <a href="#" >
      <img src="images/favoritor.png" alt=""><span>商品收藏</span></a>  
      <a href="#" >
      <img src="images/my-score.png" alt=""><span>我的积分</span></a>
      <a href="#" >
      <img src="images/my-coupon.png" alt=""><span>我的优惠券</span></a>
      <a href="#" >
      <img src="images/check-digest.png" alt=""><span>查看物流</span></a>
    </li>
    </ul>
  </div>
</div>
<footer class="footer w">
  <div class="layout fix user-info">
    <div class="user-name fl">
        <!-- a-统计网站的访问量 -->
        <span>当前在线用户共有<%=getCounter(count) %>位</span>
    </div>
    <div class="fr"><a href="#" class="backTop" id="backTop">回顶部</a></div>
  </div>
  <ul class="list-ui-a foot-list tc"> 
    <li>
      <a  href="" id="footerLogin" class="foot1">登录</a>
      <a  href="" id="footerRegister" class="foot2">注册</a>       
      <a  href="" id="shopCartTip" class="foot3">购物车</a>
    </li>
  </ul>
  <div class="tc copyright">Copyright© 2012-2018 m.ebuy.com</div>
</footer>

</body>
</html>
