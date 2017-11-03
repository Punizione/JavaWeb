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
    //��ѯ�������˸�IP�ϴ�ͶƱ��ʱ��
    String ip=request.getRemoteAddr();     //��ȡ�ͻ���IP
    long ipnum=getIpNum(ip);
    try {        
      VoterDao voterDao=new VoterDao();
      Date now=new Date();          //��ȡ��ǰʱ��
      Date last = voterDao.getLastVoteTime(ipnum);//��ȡ��IP���ϴ�ͶƱʱ��  
      if(last==null){              //���ݿ���û�м�¼��IP�����IP��ַû��Ͷ��Ʊ
        addCookie(request,response);   //�ڿͻ��˵�cookie�м�¼���û��Ѿ�Ͷ��Ʊ  
        Object[] params={ipnum,timeTostr(now)};
        voterDao.saveVoteTime(params);   //�����ݿ��м�¼��IP��ѡ��ID��ͶƱʱ��
        chain.doFilter(request,response);
      }
           //��IP��ַͶ��Ʊ��������жϿͻ���cookie���Ƿ��¼���û�ͶƱ���
      else{  //���������������ĳ��IPͶƱ������IP�����ٽ���ͶƱ������
        //�жϵ�ǰʹ�ø�IP���û��Ŀͻ���cookie���Ƿ��¼��ͶƱ���
        boolean voteincookie=getCookie(request);  
        if(voteincookie){              //�����¼�˸��û��Ѿ�Ͷ��Ʊ
          request.setAttribute("message","�Ѿ�Ͷ��Ʊ�ˣ�1Сʱ�ڲ������ظ�ͶƱ��");
          RequestDispatcher rd=request.getRequestDispatcher("fail.jsp");
          rd.forward(request,response);
        }
      //û�м�¼���û��Ƿ�Ͷ��Ʊ��������жϵ�ǰsession���Ƿ��¼���û�ͶƱ�����
        else{    //��������û�ͶƱ��ɾ������cookieʵ���ظ�ͶƱ
          String ido=(String)session.getAttribute("ido");
          if("yes".equals(ido)){                //��ǰ�û���Ͷ��Ʊ
            request.setAttribute("message","�Ѿ�Ͷ��Ʊ�ˣ�1Сʱ�ڲ������ظ�ͶƱ��");
            RequestDispatcher rd=request.getRequestDispatcher("fail.jsp");
            rd.forward(request,response);
          }
          else{
            addCookie(request,response);  //�ڿͻ��˵�cookie�м�¼���û��Ѿ�Ͷ��Ʊ 
            Object[] params={ipnum,timeTostr(now)};
            voterDao.saveVoteTime(params);  //��¼ʹ�ø�IP���û���ͶƱʱ��
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
	      Cookie cookie=new Cookie(webname+".voter","I Have Vote");   //����һ��cookie
	      cookie.setPath("/");
	      cookie.setMaxAge(60*60*1);    //����cookie�ڿͻ��˱������Чʱ��Ϊ1Сʱ  
	      response.addCookie(cookie);     //��ͻ���д��cookie
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
