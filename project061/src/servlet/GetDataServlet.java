package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.GoodsInfo;
import dao.GetDataDao;

public class GetDataServlet extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)  
	        throws ServletException, IOException{
		doPost(request, response);
	}
	@Override

	protected void doPost(HttpServletRequest request, HttpServletResponse response)  
	        throws ServletException, IOException {
	    List<GoodsInfo> options=new GetDataDao().getOptions();
	    request.setAttribute("optionlist",options);    
	    RequestDispatcher rd=request.getRequestDispatcher("/task6-2.jsp");
	    rd.forward(request,response);    
	 }

}
