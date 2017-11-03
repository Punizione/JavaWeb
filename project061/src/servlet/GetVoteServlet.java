package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.GoodsInfo;
import dao.GetDataDao;

public class GetVoteServlet extends HttpServlet {
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
	@SuppressWarnings({ })
	protected void doPost(HttpServletRequest request, HttpServletResponse response)  
	        throws ServletException, IOException {
	  List<GoodsInfo> vote=new GetDataDao().getOptions();
	  request.setAttribute("votelist",vote);  
	  long total=new GetDataDao().getTotal();
	  request.setAttribute("votetotal",total);
	  double max=new GetDataDao().getMaxNum();
	  request.setAttribute("votemax",max);
	  request.getRequestDispatcher("vote6-2.jsp").forward(request, response) ;  //�ض���ҳ��
	}

}
