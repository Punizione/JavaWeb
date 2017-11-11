<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@taglib prefix="s" uri="/struts-tags"  %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><s:text name="title1"></s:text></title>
<link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
<body>
<div class="div_global w">
    <div class="div_report">
        <div class="div_report_up">
          <div id="title" class="title blue_t"><s:text name="title2"></s:text></div>
        </div>
        <div class="div_report_middle">  
          <div class="div_q">
            <div class="q_bar">
                <div id="bar_0" class="col" style="width:110px;">
                <span><s:text name="number"></s:text></span>
                </div>
                <div id="bar_1" class="col" style="width:150px;">
                <span><s:text name="brand"></s:text></span>
                </div>                
                <div id="bar_2" class="col" style="width:210px;border-right-width:0px;">
                <span><s:text name="scale"></s:text></span>
                </div>
            </div>
              <div class="q_table">
                <ol>
                <li id="i_31761">
                  <div class="cell" style="width:105px;">
                    <div id="c_0" class="num_order">1</div>
                  </div>
                  <div id="c_1" class="cell" style="width:140px ;">
                      <s:text name="mobile"></s:text></div>
                  <div id="c_2" class="cell" style="width:205px ;"> 
                    <div class="beam_bg">
                      <div id="c_2_0" class="beam" style="width:150px;"></div>
                    </div>
                    <div id="c_2_1" class="perc">9.58%</div>
                  </div>                  
                  <div class="clearit"></div>
                </li>
                </ol>
              </div>
      </div>
        </div>
        <div class="div_report_bottom">
          <div id="bar" class="bar">
                <div class="gray_t">
                  <s:text name="total"></s:text>
                  <b class="red_t">&nbsp;24,63&nbsp;</b> 
                  <s:text name="vote"></s:text>
                </div>
<div class="clearit"></div>
            </div>
            <div id="bar" class="bar">
              <s:url action="localeAction" id="urla">   
                <s:param name="lan" value="1"></s:param>   
              </s:url>   
              <s:url action="localeAction" id="urlb">   
                <s:param name="lan" value="2"></s:param>   
              </s:url>   
              <a href="<s:property value="#urla"/>"><s:text name="China"></s:text></a> 
              <a href="<s:property value="#urlb"/>"><s:text name="US"></s:text></a> 
            </div>
        </div>
    </div>
</div>
</body>

</body>
</html>