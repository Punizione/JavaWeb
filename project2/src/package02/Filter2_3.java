package package02;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

public class Filter2_3 implements Filter{
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) 
		      throws IOException, ServletException {
		    HttpServletRequest req = (HttpServletRequest)request;
		    ServletContext sc = req.getSession().getServletContext();  //获取ServletContext对象
		    if(sc.getAttribute("count3") != null){
		        Long num = (Long) sc.getAttribute("count3");
		        sc.setAttribute("count3", ++num);
		    }else{
		        sc.setAttribute("count3", new Long(1));
		    }
		    chain.doFilter(req, response);
		  }

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
