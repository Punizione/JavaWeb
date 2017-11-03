package project05;


import java.io.IOException;


import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class RegisterServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException,IOException{
		doPost(request,response);
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)   
		        throws ServletException, IOException {
		  // ����request��response�ı���
		  response.setContentType("text/html");
		  request.setCharacterEncoding("UTF-8");
		  response.setCharacterEncoding("UTF-8");
		  String strName=request.getParameter("username");
		  String strPassword=request.getParameter("password");
		  UserManage userm=new UserManage();
		  if(strName!=null && !strName.isEmpty()){
		    if(userm.getUser(strName)){
		      request.setAttribute("info", "���û����Ѿ�ע���");
		    }
		    else{
		       UserInfo user=new UserInfo();
		       //���û��������Ը�ֵ
		       user.setName(strName);
		       user.setPassword(strPassword);
		       //�����û�ע����Ϣ
		       if (userm.insertUser(user)){
		         request.setAttribute("info", "�û�ע��ɹ���");
		       }
		       else{
		         request.setAttribute("info", "�û�ע��ʧ�ܣ�");
		       }
		    }
		  }
		  else{
		    request.setAttribute("info", "�û������ע����Ϣ����");
		   }
		  request.getRequestDispatcher("message.jsp").forward(request,response);
		}

	
}
