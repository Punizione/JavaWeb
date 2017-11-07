<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="java.sql.Connection" %>
    <%@page import="java.sql.*" %>
    <%
  String driverClass = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
  String url = "jdbc:sqlserver://localhost:1433;DatabaseName=eshop";
  String user = "sa";
  String password = "888888";
  Connection conn;
  try {
    Class.forName(driverClass);
    conn = DriverManager.getConnection(url, user, password);
    Statement stmt = conn.createStatement();
    String sql = "select top 5  图片地址,商品编码,商品名称,型号参数,价格  "+
               "from 商品数据表 where 商品名称 like '__手机%' ";
    ResultSet rs = stmt.executeQuery(sql);
%>
    
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

<div class="search-list w">
    <ul class="my-order-list pro-list list-ui-c" id="productList">
    <%
    while (rs.next()) {  
    %>  
      <li>
        <a href="<%=rs.getString("商品编码")%>.html">
          <div class="wbox">
            <div class="pro-img"><img width="100" height="100"  
                src="<%=rs.getString("图片地址")%>" 
                alt="<%=rs.getString("商品名称")%>">
            </div>
            <div class="pro-info">
              <p class="pro-name"><%=rs.getString("商品编码")%></p>
              <p class="pro-name"><%=rs.getString("商品名称")%></p>
              <p class="pro-tip gray6 mt10"><%=rs.getString("型号参数")%></p>
              <p class="mt10">
                <span class="snPrice" style="font-size:14px;">¥ 
                                  <%=rs.getString("价格")%></span>
              </p>
            </div>
          </div>
        </a>
        <span class="arrow"></span>
      </li>
      <%
    }
       stmt.close();
       conn.close(); 
    } catch (Exception ex) {
      ex.printStackTrace();
    }
    %>
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