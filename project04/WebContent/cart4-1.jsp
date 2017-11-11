<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/module.css">
<link rel="stylesheet" type="text/css" href="css/cart.css">
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/snmwshopCart1.js"></script>
<script type="text/javascript" src="js/snmwshopCart1_v2.js"></script>
<script type="text/javascript">
    function updateNum(code,num,price,flag){
      var q=parseInt(num);
      if(flag=="add"){
        q++;
      }
      else{
        q--;
      }
      var num1=q.toString();
      var url = "buy?action=update&code="+code+"&num="+num1+"&price="+price;
      window.location = url;
    }
    function changeNum(code,num,price){
 var url = "buy?action=update&code="+code+"&num="+num+"&price="+price;
      window.location = url;
    }
    function deleteCartItem(a,code) {
        $(a).addClass("delete");
        if (confirm("确认删除吗？")) {
            var b = $(a).prev("input").val();
            var url = "buy?action=del&code="+code;
        window.location = url;
        } else {
            $(a).removeClass("delete")
        }
    } 
    function clearCart(){
      var url = "buy?action=clear";
      window.location = url;
    }
</script>  

</head>
<body>
	<div id="header" class="title-ui-a w">
	  <div class="back-ui-a">
	    <a href="javascript:history.back(1)">返回</a>
	  </div>
	  <div class="header-title">购物车</div>
	  <div class="site-nav">
	    <ul class="fix">
	      <li class="mysn"><a href="#" >我的易购</a></li>
	      <li class="mycart"><a href="#" >购物车</a></li>    
	      <li class="home"><a href="#" >返回主页</a></li>    
	    </ul>
	  </div>
	</div>
	<div class="cart-list-1 w f14">
	    <ul class="cart-list list-ui-c" id="Cart_List">
	    <c:forEach var="cart" items="${requestScope.cartList1}">  
	    <li>
	      <div class="wbox">
	        <div class="mr10" style="margin-top:32px;">
	          <input type="checkbox" class="input-checkbox-a" name="checkbox_1"   
	                itemid="1" id="checkbox_1" checked="true">
	</div>
	        <p class="pro-img"><a href="" title="${cart.goodsName}">
	           <img src="${cart.goodsImageAddress}" alt="${cart.goodsName}" /></a>
	       </p>
	        <div class="wbox-flex">
	          <p><span class="attr">编号:</span>${cart.goodsCode}</p>
	          <p class="pro-name">
	            <a id="name_1" href="" title="${cart.goodsName}">${cart.goodsName}
	            </a><br />
	          </p>
	          <div class="count">
	           <span class="attr">数量:</span>    
	           <div class="countArea">
	           <a href="javascript:void(0)" class="min"  onclick="lesV2(this,&#39;1&#39;); 
	              updateNum('${cart.goodsCode}', ${cart.goodsNumber}, 
	                        ${cart.goodsPrice},'min');"></a>
	            <input class="count-input" type="text" value="${cart.goodsNumber}" 
	                onChange="javascript:changeNum('${cart.goodsCode}',  
	                                            this.value,${cart.goodsPrice});" >
	              <!--    name="quantity" id="quantity" -->
	            <a href="javascript:void(0)" class="add"  onclick="addV2(this,&#39;1&#39;); 
	             updateNum('${cart.goodsCode}', ${cart.goodsNumber},
	                       ${cart.goodsPrice},'add');"></a>
	            </div>    
	          </div>
	          <p>
	          <span class="attr">易购价:</span>    
	          <span class="price">¥ ${cart.goodsPreferentialPrice}</span>
	          </p>
	          <div class="trash" onclick="javascript:deleteCartItem(this,'${cart.goodsCode}');">
	               <span class="lid"></span><span class="can"></span></div>
	        </div>
	      </div>
	      <div class="a5 mt5" name="error_message" id="error_message_1"></div>
	    </li>
	    </c:forEach>    
	    </ul> 
	  <c:forEach var="cart2" items="${requestScope.cartList2}">     
	    <p class="mt5 tr">商品总计:
	       <span><em id="userPayAllprice">￥${cart2.payAll}</em></span>
	       <span id="promotionAmountSpan" >- 优惠:<em id="totalPromotionAmount"> 
	                                      ￥${cart2.promotionAmount}</em>
	       </span>
	    </p>
	    <p class="mt5 tr">应付总额(未含运费) : <span class="price">
	                   <em id="userPayAllpriceList">￥${cart2.payAll}</em></span>
	    </p>
	  </c:forEach> 
	  <div class="btn-ui-b mt10" id="checkOutButton"><a title="去结算" >去结算</a></div>
	  <div class="btn-ui-c mt10">
	 
	<a href="task4-1.html" title="继续购物" >&lt;&lt;继续购物</a>  
	  </div>
	   <div class="btn-ui-b mt10" id="checkOutButton"><a title="清空购物车"  
	        href="javascript:;" onclick="clearCart();">清空购物车</a></div>
	</div>
	<div id="footer" class="w">
	  <div class="layout fix user-info">
	    <div class="user-name fl" id="footerUserName">当前用户: 
	        <span class="a">LiMin</span></div>
	    <div class="fr"><a id="backTop" href="javascript:;" >回顶部</a></div>
	  </div>
	  <ul class="list-ui-a">
	    <li>
	      <div class="w user-login">
	          <a href="#" id="footerLogin" style="">登录</a>
	          <a href="#" id="footerRegister" style="">注册</a>
	          <a href="#" id="footerLogout" style="display:none">注销</a>
	          <a href="#" >购物车</a>
	      </div>
	    </li>
	  </ul>
	  <div class="copyright">Copyright© 2012-2018 m.ebuy.com</div>
	</div>


</body>
</html>