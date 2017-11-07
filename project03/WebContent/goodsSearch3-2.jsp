<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/base.css">
<link rel="stylesheet type="text/css" href="css/view.css">
<script type="text/javascript" src="js/jquery.min.js"></script>
</head>

<body><!-- 头部导航 -->
	<nav class="nav nav-sub pr w">  
	  <a class="goback" href="javascript:history.back(1)">返回</a>
	  <div class="nav-title wb">商品搜索结果</div>  
	  <a href="#" class="my-account" ></a>
	  <a href="#" class="my-cart my-cart-in"></a>  
	  <a href="#" class="home"></a>  
	</nav>

	<div class="search-box w" style="position:relative;top:0;margin-top:10px;">
	  <form action="GoodsServlet" method="post" name="formSearch">
	    <input type="search" name="keywords" id="keywordsTop"   
	          class="search-input" autocomplete="off" value="" />
	    <input type="submit" class="search-btn" style="border:none;text-indent:-99em;">
	  </form>
	</div>
	<div id="resultMsg" class="w f14 search-result">
	  <span class="a3" id="searchKeyword">${requestScope.searchName}</span>，共找到
	      <span id="productAmount">（${requestScope.goodsCount}）条相关结果。</span> 
	</div>
	<div class="search-list w">
	  <ul class="my-order-list pro-list list-ui-c" id="productList">
	   <c:forEach var="goods" items="${requestScope.goodsList}">  
	    <li>
	      <a href="${goods.goodsCode}.html">
	        <div class="wbox">
	          <div class="pro-img"><img width="100" height="100" 
	               src="${goods.goodsImageAddress}" alt="${goods.goodsName}">
	          </div>
	          <div class="pro-info">
	            <p class="pro-name">${goods.goodsCode}</p>
	 
	<p class="pro-name">${goods.goodsName}</p>
	            <p class="pro-tip gray6 mt5">${goods.goodsParameter}</p>
	            <p class="mt5">
	              <span class="snPrice" style="font-size:14px;">¥ ${goods.goodsPrice}</span>
	            </p>
	          </div>
	        </div>
	        </a>
	        <span class="arrow"></span>
	    </li>
	  </c:forEach>   
	  </ul>
	</div>

<!-- 尾部导航 -->
	<footer class="footer w">
	  <div class="tr"><a href="#" class="backTop" id="backTop">回顶部</a></div>
	  <ul class="list-ui-a foot-list tc">  
	    <li>
	      <a href="" id="footerRegister" class="foot2">注册</a>
	      <a href="" id="footerUserName" class="foot1" style="">当前账户:   
	         <span class="a">LiMin</span></a>
	    </li>
	  </ul>
	  <div class="tc copyright">Copyright© 2012-2018 m.ebuy.com</div>
	</footer>

</body>
</html>