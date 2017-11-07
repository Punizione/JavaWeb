package project03;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class GoodsMysqlServlet extends HttpServlet{
	protected void doPost(HttpServletRequest request, HttpServletResponse response)   
		         throws ServletException, IOException {
		  response.setContentType("text/html");
		  response.setCharacterEncoding("UTF-8");
		  request.setCharacterEncoding("UTF-8");
		  String name = request.getParameter("keywords").trim();  //获取action参数值
		  int num=5;
		  ConnMysql conn=new ConnMysql();                     //创建数据库连接对象
		  String sql=null;
		  if (name==null || name.isEmpty()) {  
		    sql="select top " + num  
		                 + " 商品编码,商品名称,型号参数,价格,图片地址 from 商品数据表 ";
		  }
		  else{
		     sql="select top " + num  + " 商品编码,商品名称,型号参数,价格,图片地址 " 
		                  + " from 商品数据表 where 商品名称 like '%" + name + "%'";
		  }
		  System.out.print(sql);
		  ResultSet rs=conn.executeQuery(sql);    //查询全部商品信息
		  List list=new ArrayList();
		  try {
		    while(rs.next()){
		      GoodsInfo goods=new GoodsInfo();        
		      goods.setGoodsCode(rs.getString("商品编码"));
		      goods.setGoodsName(rs.getString("商品名称"));
		      goods.setGoodsParameter(rs.getString("型号参数"));
		      goods.setGoodsPrice(rs.getDouble("价格"));
		      goods.setGoodsImageAddress(rs.getString("图片地址"));
		      list.add(goods);            //将商品信息保存到List集合中
		    }
		  } catch (SQLException e) {
		    e.printStackTrace();
		  }
		  if (name==null || name.isEmpty()) {  
		     sql="select count(*) from 商品数据表  ";
	request.setAttribute("searchName", "全部商品");
		  }
		  else{
		     sql="select count(*) from 商品数据表  where 商品名称  like '%" + name + "%'";
		     request.setAttribute("searchName", name);
		  }
		  rs=conn.executeQuery(sql);           //查询全部商品信息
		  try {
		    if(rs.next()){
		      request.setAttribute("goodsCount", rs.getInt(1));
		    }
		    else{
		      request.setAttribute("goodsCount",0);
		    }
		  } catch (SQLException e) {
		    e.printStackTrace();
		  }
		  request.setAttribute("goodsList", list);    //将商品信息保存到HttpServletRequest中
		  request.getRequestDispatcher("goodsSearch3-2.jsp").forward(request, response);  
		}
	protected void doGet(HttpServletRequest request, HttpServletResponse response)   
	         throws ServletException, IOException {
	  response.setContentType("text/html");
	  response.setCharacterEncoding("UTF-8");
	  request.setCharacterEncoding("UTF-8");
	  String name = request.getParameter("keywords").trim();  //获取action参数值
	  int num=5;
	  ConnDB conn=new ConnDB();                     //创建数据库连接对象
	  String sql=null;
	  if (name==null || name.isEmpty()) {  
	    sql="select top " + num  
	                 + " 商品编码,商品名称,型号参数,价格,图片地址 from 商品数据表 ";
	  }
	  else{
	     sql="select top " + num  + " 商品编码,商品名称,型号参数,价格,图片地址 " 
	                  + " from 商品数据表 where 商品名称 like '%" + name + "%'";
	  }
	  System.out.print(sql);
	  ResultSet rs=conn.executeQuery(sql);    //查询全部商品信息
	  List list=new ArrayList();
	  try {
	    while(rs.next()){
	      GoodsInfo goods=new GoodsInfo();        
	      goods.setGoodsCode(rs.getString("商品编码"));
	      goods.setGoodsName(rs.getString("商品名称"));
	      goods.setGoodsParameter(rs.getString("型号参数"));
	      goods.setGoodsPrice(rs.getDouble("价格"));
	      goods.setGoodsImageAddress(rs.getString("图片地址"));
	      list.add(goods);            //将商品信息保存到List集合中
	    }
	  } catch (SQLException e) {
	    e.printStackTrace();
	  }
	  if (name==null || name.isEmpty()) {  
	     sql="select count(*) from 商品数据表  ";
request.setAttribute("searchName", "全部商品");
	  }
	  else{
	     sql="select count(*) from 商品数据表  where 商品名称  like '%" + name + "%'";
	     request.setAttribute("searchName", name);
	  }
	  rs=conn.executeQuery(sql);           //查询全部商品信息
	  try {
	    if(rs.next()){
	      request.setAttribute("goodsCount", rs.getInt(1));
	    }
	    else{
	      request.setAttribute("goodsCount",0);
	    }
	  } catch (SQLException e) {
	    e.printStackTrace();
	  }
	  request.setAttribute("goodsList", list);    //将商品信息保存到HttpServletRequest中
	  request.getRequestDispatcher("goodsSearch3-2.jsp").forward(request, response);  
	}

}
