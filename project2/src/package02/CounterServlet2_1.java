package package02;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import javax.servlet.ServletContext;
public class CounterServlet2_1 extends HttpServlet {
    public CounterServlet2_1() {
        super();
    }
    //初始化方法
    public void init(ServletConfig config) throws ServletException {
    	super.init(config);
      }
    //处理HTTP GET请求
    protected void doGet(HttpServletRequest request, HttpServletResponse response)  
            throws ServletException, IOException {
      //获得ServletContext对象

      ServletContext context =getServletContext();

      //从ServletContext中获得计数器对象
      Long num = (Long)context.getAttribute("count1");
      if(num==null){     //如果为空，则在ServletContext中设置一个计数器的属性
        num=(long) 1;
        context.setAttribute("count1", num);
      }else{           //如果不为空，则设置该计数器的属性值加1
        context.setAttribute("count1", num+1);
      }
      response.setContentType("text/html");       //响应正文的MIME类型
      response.setCharacterEncoding("UTF-8");    //响应的编码格式
      PrintWriter out = response.getWriter();
      out.println("<!DOCTYPE HTML>");
      out.println("<html>");
      out.println("  <head><title>统计网站的访问量</title>");
      out.println("  <link rel='stylesheet' type='text/css' href='css/base.css'>");
      out.println("  <link rel='stylesheet' type='text/css' href='css/view.css'>");
      out.println("  </head>");
      out.println("  <body>");
      out.println("    <footer class='footer w'>");
      out.println("     <div class='layout fix user-info'>");
      out.println("      <div class='user-name fl'>");
      out.println("       <span>您是第  "+context.getAttribute("count1")+"位访问者。</span>");
      out.println("      </div>");
      out.println("     </div>");
      out.println("    </footer>");
      out.println("  </body>");
      out.println("</html>");
      out.flush();  
      out.close();  
    }

    

    //处理HTTP POST请求
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
    }
    //实例销毁
    public void destroy() {
     }
}
