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
	      //���ServletContext����

	      ServletContext context =getServletContext();

	      Date javaDate = new Date();
	    	
	      response.setContentType("text/html");       //��Ӧ���ĵ�MIME����
	      response.setCharacterEncoding("UTF-8");    //��Ӧ�ı����ʽ
	      PrintWriter out = response.getWriter();

	      out.println("<!DOCTYPE html>");
	      out.println("<html>");
	      out.println("<head>");
	      out.println("<title>��ǰʱ��ʱ��</title>");
	      out.println("<script type='text/javascript'>");
	      out.println("	var today = new Date('"+javaDate+"'); ");
	      out.println("function disptime(){");
	    
	      out.println("	var hh = today.getHours()+10; //���Сʱ�����ӡ���");
	      out.println("	var mm = today.getMinutes();");
	      out.println("	var ss = today.getSeconds();");
	      	
	      out.println("	document.getElementById('clock').innerHTML='<h1>�����ǣ�'+hh+':'+mm+':'+ss+'<h1>';");
	      	
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
