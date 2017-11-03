package project05;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServlet;

public class ValidateServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException,IOException{
		doPost(request,response);
	}
	   protected void doPost(HttpServletRequest request, HttpServletResponse response) 
		        throws ServletException, IOException {
		  //识别验证码，获取表单数据
		  request.setCharacterEncoding("GB18030");
		  response.setCharacterEncoding("GB18030");
		  String name=request.getParameter("username");
		  String password=request.getParameter("password");
		  HttpSession session =request.getSession();
		  PrintWriter out = response.getWriter();
		  String rand = (String)session.getAttribute("randomCode"); 
		  String input = request.getParameter("verifyCode");     
		  if(rand.equals(input)){ 
		    out.print("<script>alert('验证通过！');</script>"); 
		  response.sendRedirect("registerServlet?username="+name+"&password="+password);  
		  } else{ 
		    out.print("<script>alert('请输入正确的验证码！');location.href='login05.jsp';</script>"); 
		  }
		}
}
