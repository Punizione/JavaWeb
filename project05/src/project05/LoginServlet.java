package project05;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

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
	  //��ȡ������
	  String userName=request.getParameter("login_username");
	  String userPassword=request.getParameter("login_password");
	  UserManage userm=new UserManage();
	  UserInfo user=new UserInfo();
	  user=userm.userLogin(userName, userPassword);  
	  if(user!=null){
	    request.getSession().setAttribute("loginUser", user);
	    request.setAttribute("info", "�û���¼�ɹ���");
	  }
	  else{
	    request.setAttribute("info", "�û���¼ʧ�ܣ�");
	  }
	  //ת��message.jspҳ��
	  request.getRequestDispatcher("message.jsp").forward(request,response);
	}

}
