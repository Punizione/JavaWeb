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
		  // 设置request与response的编码
		  response.setContentType("text/html");
		  request.setCharacterEncoding("UTF-8");
		  response.setCharacterEncoding("UTF-8");
		  String strName=request.getParameter("username");
		  String strPassword=request.getParameter("password");
		  UserManage userm=new UserManage();
		  if(strName!=null && !strName.isEmpty()){
		    if(userm.getUser(strName)){
		      request.setAttribute("info", "该用户名已经注册过");
		    }
		    else{
		       UserInfo user=new UserInfo();
		       //对用户对象属性赋值
		       user.setName(strName);
		       user.setPassword(strPassword);
		       //保存用户注册信息
		       if (userm.insertUser(user)){
		         request.setAttribute("info", "用户注册成功！");
		       }
		       else{
		         request.setAttribute("info", "用户注册失败！");
		       }
		    }
		  }
		  else{
		    request.setAttribute("info", "用户输入的注册信息有误！");
		   }
		  request.getRequestDispatcher("message.jsp").forward(request,response);
		}

	
}
