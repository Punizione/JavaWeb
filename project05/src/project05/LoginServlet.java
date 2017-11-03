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
	  // 设置request与response的编码
	  response.setContentType("text/html");
	  request.setCharacterEncoding("UTF-8");
	  response.setCharacterEncoding("UTF-8");
	  //获取表单数据
	  String userName=request.getParameter("login_username");
	  String userPassword=request.getParameter("login_password");
	  UserManage userm=new UserManage();
	  UserInfo user=new UserInfo();
	  user=userm.userLogin(userName, userPassword);  
	  if(user!=null){
	    request.getSession().setAttribute("loginUser", user);
	    request.setAttribute("info", "用户登录成功！");
	  }
	  else{
	    request.setAttribute("info", "用户登录失败！");
	  }
	  //转发message.jsp页面
	  request.getRequestDispatcher("message.jsp").forward(request,response);
	}

}
