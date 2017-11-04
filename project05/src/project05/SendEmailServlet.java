package project05;

import java.io.*;
import java.util.*;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;
 
public class SendEmailServlet extends HttpServlet{
    static final String FROM = "1273435147@qq.com";
    static final int PORT = 465;
    static final String PROTOCOL = "smtp";
    static final String HOST = "smtp.qq.com";
    static final String USR = "1273435147@qq.com";
    static final String PWD = "onspeed00";
    static final String PW = "rnutfdzvpisqjejh";
  public void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
	  doPost(request, response);
   }

  public void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
      String user = request.getParameter("username");
      String pass = request.getParameter("password");
      UserManage userm=new UserManage();
	  if(user!=null && !user.isEmpty()){
		   /* if(userm.getUser(user)){
		      request.setAttribute("info", "该用户名已经注册过");
		      request.getRequestDispatcher("message.jsp").forward(request,response);
		    }else{*/
	  
		  // 收件人的电子邮件 ID
	      String to = request.getParameter("username");
	 
	
	      // 发件人的电子邮件 ID
	      String from = "1273435147@qq.com";
	 
	      // 假设您是从本地主机发送电子邮件
	      String host = "localhost";
	
	 
	      // 获取系统的属性
	      Properties properties = new Properties();
	    //  properties.setProperty("","");
	    //  properties.setProperty("mail.password",PWD);
	    // properties.setProperty("mail.user",USR);
	      
	 
	      // 设置邮件服务器
	      properties.setProperty("mail.smtp.host", HOST);
	      properties.put("mail.transport.protocol" , PROTOCOL);
	      
	      properties.put("mail.smtp.port", PORT);
	      properties.put("mail.smtp.ssl.enable", "true");
	      properties.put("mail.smtp.auth" , true);
	      properties.put("mail.debug", "true");
	        Session session = Session.getInstance(properties,new Authenticator() {
                @Override
                protected PasswordAuthentication getPasswordAuthentication(){
                    return new PasswordAuthentication(USR, PW);
                }
            });
	      
	 
	      // 获取默认的 Session 对象
	     // Session session = Session.getInstance(properties);
	      
	      // 设置响应内容类型
	      response.setContentType("text/html;charset=UTF-8");
	      PrintWriter out = response.getWriter();
	      String link = "http://localhost:8080/project05/registerEmailServlet?user="+user+"&password="+pass;
	
	      try{
	         // 创建一个默认的 MimeMessage 对象
	         MimeMessage message = new MimeMessage(session);
	         // 设置 From: header field of the header.
	         message.setFrom(new InternetAddress(FROM));
	         // 设置 To: header field of the header.
	         message.addRecipient(Message.RecipientType.TO,
	                                  new InternetAddress(to));
	         // 设置 Subject: header field
	         message.setSubject("注册激活");
	         // 现在设置实际消息
	         message.setText("这是一封激活邮件,您在网站注册账户:"+user+",如果您确认注册,请单击如下链接:"+link);
	         // 发送消息
	         Transport transport = session.getTransport();
	         transport.connect(USR, PW);
	         transport.send(message);
	         String title = "请前往邮箱确认注册";
	         String res = "邮件已发往"+to+",请确认注册";
	         String docType = "<!DOCTYPE html> \n";
	         out.println(docType +
	         "<html>\n" +
	         "<head><title>" + title + "</title></head>\n" +
	         "<body bgcolor=\"#f0f0f0\">\n" +
	         "<h1 align=\"center\">" + title + "</h1>\n" +
	         "<p align=\"center\">" + res + "</p>\n" +
	         "</body></html>");
	      }catch (MessagingException mex) {
	         mex.printStackTrace();
	      }		
		 /*}*/
	  }else{
		    request.setAttribute("info", "用户输入的注册信息有误！");
		    request.getRequestDispatcher("message.jsp").forward(request,response);
	}
		 
  }

} 
