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
    //��ʼ������
    public void init(ServletConfig config) throws ServletException {
    	super.init(config);
      }
    //����HTTP GET����
    protected void doGet(HttpServletRequest request, HttpServletResponse response)  
            throws ServletException, IOException {
      //���ServletContext����

      ServletContext context =getServletContext();

      //��ServletContext�л�ü���������
      Long num = (Long)context.getAttribute("count1");
      if(num==null){     //���Ϊ�գ�����ServletContext������һ��������������
        num=(long) 1;
        context.setAttribute("count1", num);
      }else{           //�����Ϊ�գ������øü�����������ֵ��1
        context.setAttribute("count1", num+1);
      }
      response.setContentType("text/html");       //��Ӧ���ĵ�MIME����
      response.setCharacterEncoding("UTF-8");    //��Ӧ�ı����ʽ
      PrintWriter out = response.getWriter();
      out.println("<!DOCTYPE HTML>");
      out.println("<html>");
      out.println("  <head><title>ͳ����վ�ķ�����</title>");
      out.println("  <link rel='stylesheet' type='text/css' href='css/base.css'>");
      out.println("  <link rel='stylesheet' type='text/css' href='css/view.css'>");
      out.println("  </head>");
      out.println("  <body>");
      out.println("    <footer class='footer w'>");
      out.println("     <div class='layout fix user-info'>");
      out.println("      <div class='user-name fl'>");
      out.println("       <span>���ǵ�  "+context.getAttribute("count1")+"λ�����ߡ�</span>");
      out.println("      </div>");
      out.println("     </div>");
      out.println("    </footer>");
      out.println("  </body>");
      out.println("</html>");
      out.flush();  
      out.close();  
    }

    

    //����HTTP POST����
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
    }
    //ʵ������
    public void destroy() {
     }
}
