package filter;
import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import dao.VoterDao;

public class VoteLimitFilter implements Filter {
  @SuppressWarnings("unused")
  private FilterConfig fc=null;

  public void doFilter(ServletRequest srequest , ServletResponse sresponse,FilterChain chain) 
           throws IOException, ServletException {
    HttpServletRequest request=(HttpServletRequest)srequest;
    HttpServletResponse response=(HttpServletResponse)sresponse;
    HttpSession session=request.getSession();    
    //查询服务器端该IP上次投票的时间
    String ip=request.getRemoteAddr();     //获取客户端IP
    long ipnum=getIpNum(ip);
    try {        
      VoterDao voterDao=new VoterDao();
      Date now=new Date();          //获取当前时间
      Date last = voterDao.getLastVoteTime(ipnum);//获取该IP的上次投票时间  
      if(last==null){              //数据库中没有记录该IP，则该IP地址没有投过票
        addCookie(request,response);   //在客户端的cookie中记录该用户已经投过票  
        Object[] params={ipnum,timeTostr(now)};
        voterDao.saveVoteTime(params);   //在数据库中记录该IP、选项ID和投票时间
        chain.doFilter(request,response);
      }
           //该IP地址投过票，则接着判断客户端cookie中是否记录了用户投票情况
      else{  //用来解决局域网中某个IP投票后，其他IP不能再进行投票的问题
        //判断当前使用该IP的用户的客户端cookie中是否记录了投票标记
        boolean voteincookie=getCookie(request);  
        if(voteincookie){              //如果记录了该用户已经投过票
          request.setAttribute("message","已经投过票了，1小时内不允许重复投票！");
          RequestDispatcher rd=request.getRequestDispatcher("fail.jsp");
          rd.forward(request,response);
        }
      //没有记录该用户是否投过票，则接着判断当前session中是否记录了用户投票的情况
        else{    //用来解决用户投票后，删除本地cookie实现重复投票
          String ido=(String)session.getAttribute("ido");
          if("yes".equals(ido)){                //当前用户已投过票
            request.setAttribute("message","已经投过票了，1小时内不允许重复投票！");
            RequestDispatcher rd=request.getRequestDispatcher("fail.jsp");
            rd.forward(request,response);
          }
          else{
            addCookie(request,response);  //在客户端的cookie中记录该用户已经投过票 
            Object[] params={ipnum,timeTostr(now)};
            voterDao.saveVoteTime(params);  //记录使用该IP的用户的投票时间
            chain.doFilter(request,response);
          }
        }
      }
    } catch (SQLException e) {
      e.printStackTrace();
}    
} 

	  public void init(FilterConfig fc) throws ServletException {
	    this.fc=fc;
	}
	
	  public void destroy() {
	    this.fc=null;
	  }
	  
	  public static long getIpNum(String ip){
		    long ipNum=0;
		    if(ip!=null&&!ip.equals("")){
		      String[] subips=ip.split("\\.");      
		      for(int i=0;i<subips.length;i++){
		        ipNum+=Integer.parseInt(subips[i]);
		        if(i<subips.length-1)
		          ipNum=ipNum<<8;
		      }
		    }
		    return ipNum;
		  }
	  
	  public static String timeTostr(Date date){
		    String strDate="";
		    if(date!=null){
		      SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		      strDate=format.format(date);    
		    }
		    return strDate;
		  } 
	  
	  
	  private void addCookie(HttpServletRequest request,HttpServletResponse response){
	      String webname=request.getContextPath();
	      webname=webname.substring(1);
	      Cookie cookie=new Cookie(webname+".voter","I Have Vote");   //创建一个cookie
	      cookie.setPath("/");
	      cookie.setMaxAge(60*60*1);    //设置cookie在客户端保存的有效时间为1小时  
	      response.addCookie(cookie);     //向客户端写入cookie
	    }

	  
	  private boolean getCookie(HttpServletRequest request){
		    boolean hasvote=false;
		    String webName=request.getContextPath();
		    webName=webName.substring(1);
		    String cookiename=webName+".voter";
		    Cookie[] cookies=request.getCookies();
		    if(cookies!=null&&cookies.length!=0){
		      for(int i=0;i<cookies.length;i++){
		        Cookie single=cookies[i];
		        if(single.getName().equals(cookiename) && single.getValue().equals("I Have Vote")){
		          hasvote=true;
		          break;
		        }  
		      }
		    }    
		    return hasvote;  
		  }



}
