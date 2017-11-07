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
		  String name = request.getParameter("keywords").trim();  //��ȡaction����ֵ
		  int num=5;
		  ConnMysql conn=new ConnMysql();                     //�������ݿ����Ӷ���
		  String sql=null;
		  if (name==null || name.isEmpty()) {  
		    sql="select top " + num  
		                 + " ��Ʒ����,��Ʒ����,�ͺŲ���,�۸�,ͼƬ��ַ from ��Ʒ���ݱ� ";
		  }
		  else{
		     sql="select top " + num  + " ��Ʒ����,��Ʒ����,�ͺŲ���,�۸�,ͼƬ��ַ " 
		                  + " from ��Ʒ���ݱ� where ��Ʒ���� like '%" + name + "%'";
		  }
		  System.out.print(sql);
		  ResultSet rs=conn.executeQuery(sql);    //��ѯȫ����Ʒ��Ϣ
		  List list=new ArrayList();
		  try {
		    while(rs.next()){
		      GoodsInfo goods=new GoodsInfo();        
		      goods.setGoodsCode(rs.getString("��Ʒ����"));
		      goods.setGoodsName(rs.getString("��Ʒ����"));
		      goods.setGoodsParameter(rs.getString("�ͺŲ���"));
		      goods.setGoodsPrice(rs.getDouble("�۸�"));
		      goods.setGoodsImageAddress(rs.getString("ͼƬ��ַ"));
		      list.add(goods);            //����Ʒ��Ϣ���浽List������
		    }
		  } catch (SQLException e) {
		    e.printStackTrace();
		  }
		  if (name==null || name.isEmpty()) {  
		     sql="select count(*) from ��Ʒ���ݱ�  ";
	request.setAttribute("searchName", "ȫ����Ʒ");
		  }
		  else{
		     sql="select count(*) from ��Ʒ���ݱ�  where ��Ʒ����  like '%" + name + "%'";
		     request.setAttribute("searchName", name);
		  }
		  rs=conn.executeQuery(sql);           //��ѯȫ����Ʒ��Ϣ
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
		  request.setAttribute("goodsList", list);    //����Ʒ��Ϣ���浽HttpServletRequest��
		  request.getRequestDispatcher("goodsSearch3-2.jsp").forward(request, response);  
		}
	protected void doGet(HttpServletRequest request, HttpServletResponse response)   
	         throws ServletException, IOException {
	  response.setContentType("text/html");
	  response.setCharacterEncoding("UTF-8");
	  request.setCharacterEncoding("UTF-8");
	  String name = request.getParameter("keywords").trim();  //��ȡaction����ֵ
	  int num=5;
	  ConnDB conn=new ConnDB();                     //�������ݿ����Ӷ���
	  String sql=null;
	  if (name==null || name.isEmpty()) {  
	    sql="select top " + num  
	                 + " ��Ʒ����,��Ʒ����,�ͺŲ���,�۸�,ͼƬ��ַ from ��Ʒ���ݱ� ";
	  }
	  else{
	     sql="select top " + num  + " ��Ʒ����,��Ʒ����,�ͺŲ���,�۸�,ͼƬ��ַ " 
	                  + " from ��Ʒ���ݱ� where ��Ʒ���� like '%" + name + "%'";
	  }
	  System.out.print(sql);
	  ResultSet rs=conn.executeQuery(sql);    //��ѯȫ����Ʒ��Ϣ
	  List list=new ArrayList();
	  try {
	    while(rs.next()){
	      GoodsInfo goods=new GoodsInfo();        
	      goods.setGoodsCode(rs.getString("��Ʒ����"));
	      goods.setGoodsName(rs.getString("��Ʒ����"));
	      goods.setGoodsParameter(rs.getString("�ͺŲ���"));
	      goods.setGoodsPrice(rs.getDouble("�۸�"));
	      goods.setGoodsImageAddress(rs.getString("ͼƬ��ַ"));
	      list.add(goods);            //����Ʒ��Ϣ���浽List������
	    }
	  } catch (SQLException e) {
	    e.printStackTrace();
	  }
	  if (name==null || name.isEmpty()) {  
	     sql="select count(*) from ��Ʒ���ݱ�  ";
request.setAttribute("searchName", "ȫ����Ʒ");
	  }
	  else{
	     sql="select count(*) from ��Ʒ���ݱ�  where ��Ʒ����  like '%" + name + "%'";
	     request.setAttribute("searchName", name);
	  }
	  rs=conn.executeQuery(sql);           //��ѯȫ����Ʒ��Ϣ
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
	  request.setAttribute("goodsList", list);    //����Ʒ��Ϣ���浽HttpServletRequest��
	  request.getRequestDispatcher("goodsSearch3-2.jsp").forward(request, response);  
	}

}
