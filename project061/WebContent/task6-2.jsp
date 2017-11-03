<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/base.css">
<link rel="stylesheet" type="text/css" href="css/view.css">
<script type="text/javascript">
var c_num = 0;

function checkSelect(){
  var goods=document.getElementsByName("commodity");  
  var i=0;
  for(i=0;i<goods.length;i++){
    if(goods[i].checked){
      voteform.btnSubmit.disabled=true;
      voteform.submit();
      alert("投票成功！");
      break;
    }
  }  
  if(c_num == 0)
       alert("请至少选择一项！");
}

function changeSelect(chk){
    if(chk.checked) c_num ++;
  else c_num --;
    alert("你已选择了"+c_num+"项");
}
</script>

</head>
<body>
<nav class="nav nav-sub pr w">
  <a class="goback" href="javascript:history.back(1)">返回</a>
  <div class="nav-title wb">我所喜爱的手机款式评选投票</div>
  <a href="#" class="home"></a>
</nav>

<!--页面顶部导航代码省略-->
<form action="vote" name="voteform" method="post"> 
<div class="layout w" style="margin:4px auto 0px;">  
  <c:set var="options" value="${requestScope.optionlist}"/>  
  <c:if test="${empty options}">
      <span>没有投票选项</span>
  </c:if>    
<c:if test="${!empty options}">
  <c:set var="i" value="0"/>    
    <c:forEach var="option" varStatus="ovs" items="${options}">
      <c:if test="${i==0}">
      <c:set var="start" value="0"/> 
      <ul class="jhy1 wbox"> 
      </c:if>
      <li> 
        <img src="${option.goodsImageAddress}" alt="${option.goodsName}"></a>
        <p><input type="checkbox" name="commodity" value="${option.goodsId}" 
                 onclick="changeSelect(this)"> &nbsp;${option.goodsName}
        </p>
      <li>          
      <c:if test="${i==1}">   
      </ul>      
      <c:set var="i" value="0"/> 
      <c:set var="start" value="1"/>
      </c:if>
      <c:if test="${(i==0) and (start==0)}"> 
      <c:set var="i" value="1"/> 
      </c:if>
    </c:forEach>
  </c:if> 
  <div class="tr"> 
   <input class="button" id="btnSubmit" value="投票" type="button" name="btnSubmit"  
         onclick="checkSelect()" /> 
   <input class="button" value="重选" type="reset" />
   <input class="button" value="网页浏览投票结果" type="button" 
         onclick="window.open('voteresult')"/>  
  </div>  
</div>     
</form>  
<!-- 底部导航开始 -->
<footer class="footer w">
  <div class="tr"> 
   <input class="button" value="柱形图浏览投票结果" type="button"  
         onclick="window.open('viewresult?showmode=bar')"/> 
   <input class="button" value="饼形图浏览投票结果" type="button" 
         onclick="window.open('viewresult?showmode=pie')"/>    
  </div> 
  <ul class="list-ui-a foot-list tc">
    <li>
    <a  href="#" id="footerLogin" class="foot1">登录</a>
    <a  href="#" id="footerRegister" class="foot2">注册</a>
    <a  href="#" id="shopCartTip" class="foot3">购物车</a>
    </li>
  </ul>
  <div class="tc copyright">Copyright© 2012-2018 m.ebuy.com</div>
</footer>
</body>

</html>