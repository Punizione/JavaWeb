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
		      request.setAttribute("info", "���û����Ѿ�ע���");
		      request.getRequestDispatcher("message.jsp").forward(request,response);
		    }else{*/
	  
		  // �ռ��˵ĵ����ʼ� ID
	      String to = request.getParameter("username");
	 
	
	      // �����˵ĵ����ʼ� ID
	      String from = "1273435147@qq.com";
	 
	      // �������Ǵӱ����������͵����ʼ�
	      String host = "localhost";
	
	 
	      // ��ȡϵͳ������
	      Properties properties = new Properties();
	    //  properties.setProperty("","");
	    //  properties.setProperty("mail.password",PWD);
	    // properties.setProperty("mail.user",USR);
	      
	 
	      // �����ʼ�������
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
	      
	 
	      // ��ȡĬ�ϵ� Session ����
	     // Session session = Session.getInstance(properties);
	      
	      // ������Ӧ��������
	      response.setContentType("text/html;charset=UTF-8");
	      PrintWriter out = response.getWriter();
	      String link = "http://localhost:8080/project05/registerEmailServlet?user="+user+"&password="+pass;
	
	      try{
	         // ����һ��Ĭ�ϵ� MimeMessage ����
	         MimeMessage message = new MimeMessage(session);
	         // ���� From: header field of the header.
	         message.setFrom(new InternetAddress(FROM));
	         // ���� To: header field of the header.
	         message.addRecipient(Message.RecipientType.TO,
	                                  new InternetAddress(to));
	         // ���� Subject: header field
	         message.setSubject("ע�ἤ��");
	         // ��������ʵ����Ϣ
	         message.setText("����һ�⼤���ʼ�,������վע���˻�:"+user+",�����ȷ��ע��,�뵥����������:"+link);
	         // ������Ϣ
	         Transport transport = session.getTransport();
	         transport.connect(USR, PW);
	         transport.send(message);
	         String title = "��ǰ������ȷ��ע��";
	         String res = "�ʼ��ѷ���"+to+",��ȷ��ע��";
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
		    request.setAttribute("info", "�û������ע����Ϣ����");
		    request.getRequestDispatcher("message.jsp").forward(request,response);
	}
		 
  }

} 
