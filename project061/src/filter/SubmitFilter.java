package filter;
import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
public class SubmitFilter implements Filter {
  @SuppressWarnings("unused")
private FilterConfig fc;
  public void doFilter(ServletRequest sRequest, ServletResponse sResponse,FilterChain chain)  
        throws IOException, ServletException {
    HttpServletRequest request=(HttpServletRequest)sRequest;
    String method=request.getMethod();    
    if(method.equalsIgnoreCase("POST"))
      chain.doFilter(sRequest,sResponse);  
    else{
      request.setAttribute("message","不是以POST方式进行的请求！<br />");   
      RequestDispatcher rd=request.getRequestDispatcher("fail.jsp");
      rd.forward(request,sResponse);
    }      
  }
  
  public void init(FilterConfig fc) throws ServletException {
    this.fc=fc;    
  }  

  public void destroy() {
    this.fc=null;
  }
}
