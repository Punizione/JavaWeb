<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="./css/style.css">
</head>
<body>
<nav class="nav nav-sub pr w">
  <a class="goback" href="javascript:history.back(1)">返回</a>
  <div class="nav-title wb">我所喜爱的手机款式评选投票</div>
  <a href="#" class="home"></a>
</nav>


<div class="div_global w">
   <div class="div_report">
     <div class="div_report_up">
       <div id="title" class="title blue_t">我来投票</div>
     </div>
     <div class="div_report_middle">   
       <div class="div_q">
         <div class="q_bar">
            <div id="bar_0" class="col" style="width:34px;">序号</div>
            <div id="bar_1" class="col" style="width:80px;">手机品牌 </div> 
            <div id="bar_2" class="col" style="width:195px;border-right-width:0px;"> 
                得票比例
            </div>
        </div>
           <div class="q_table">
             <ol>
             <c:forEach var="vote" items="${requestScope.votelist}">  
             <li id="i_31761" onMouseOver="this.style.background=&#39;#dbecfc&#39;;" 
                           onMouseOut="this.style.background=&#39;&#39;;">
               <div class="cell" style="width:27px ;">
                 <div id="c_0" class="num_order">${vote.goodsId}</div>
               </div>
               <div id="c_1" class="cell" style="width:73px ;text-align: center;"> 
                   <a href="">${vote.brandName}</a>
               </div>
               <div id="c_2" class="cell" style="width:190px ;"> 
                 <div class="beam_bg" style="width:130px ;">
                   <div id="c_2_0" class="beam"  style="width:${requestScope.votemax*vote.goodsNumber}px;">
                   </div>
                 </div>
                 <div id="c_2_1" class="perc">
                 <fmt:formatNumber value="${vote.goodsNumber/requestScope.votetotal}"  
                     type="percent" pattern="#0.00%"/>
                 </div>
               </div>   
               <div class="clearit"></div>
             </li>
             </c:forEach>
             </ol>
           </div>
      </div>
     </div>
     <div class="div_report_bottom">
       <div id="bar" class="bar">
             <div class="gray_t">
               共有 <b class="red_t">${requestScope.votetotal}</b> 票
             </div>
             <div class="clearit"></div>
         </div>
     </div>
   </div>
</div>
</body>

</html>