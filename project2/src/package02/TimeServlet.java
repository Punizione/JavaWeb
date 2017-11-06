package package02;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

public class TimeServlet extends HttpServlet{
	 protected void doGet(HttpServletRequest request, HttpServletResponse response)  
	            throws ServletException, IOException {
	      //获得ServletContext对象

	      ServletContext context =getServletContext();

	      Date javaDate = new Date();
	    	
	      response.setContentType("text/html");       //响应正文的MIME类型
	      response.setCharacterEncoding("UTF-8");    //响应的编码格式
	      PrintWriter out = response.getWriter();

	      out.println("<!DOCTYPE html>");
	      out.println("<html>");
	      out.println("<head>");
	      out.println("<title>当前时间时间</title>");
	      out.println("<script type='text/javascript'>");
	      out.println("	var today = new Date('"+javaDate+"'); ");
	      out.println("function disptime(){");
	    
	      out.println("	var hh = today.getHours()+10; //获得小时、分钟、秒");
	      out.println("	var mm = today.getMinutes();");
	      out.println("	var ss = today.getSeconds();");
	      	
	      out.println("	document.getElementById('clock').innerHTML='<h1>现在是：'+hh+':'+mm+':'+ss+'<h1>';");
	      	
	      out.println(" 	var Time=setTimeout('disptime()',1000);");
	      out.println("}");
	 out.println("</script>");
	 out.println(" </head>");
			 out.println("  <body onload='disptime()'>");
			 out.println(" <div id='clock'></div>");
			 out.println(" </body>");
			 out.println("  </html>");
		
			 out.close();
			 out.flush();
	    }
}
