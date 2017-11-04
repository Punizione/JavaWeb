package liuyanban.action;
import java.util.Date;
import java.util.Map;
import liuyanban.dao.UserDao;
import liuyanban.dao.impl.UserDaoImpl;
import liuyanban.model.Users;
import com.opensymphony.xwork2.*;
public class RegAction extends ActionSupport
{
	public Users user=new Users();
	public String userName;
	public String password;
	public String head;
	public int gender;
	public void setuserName(String userName)
	{
		this.userName=userName;
	}
	public String getuserName()
	{
		return userName;
	}
	public void setpassword(String password)
	{
		this.password=password;
	}
	public String getpassword()
	{
		return password;
	}
	public void sethead(String head)
	{
		this.head=head;
	}
	public String gethead()
	{
		return head;
	}
	public void setgender(int gender)
	{
		this.gender=gender;
	}
	public int getgender()
	{
		return gender;
	}
	public String execute()throws Exception
	{
		if((null==userName||userName.equals(""))||(null==password||password.equals("")))
			return INPUT;
		ActionContext context=ActionContext.getContext();
		Map session=context.getSession();
		user.gender=gender;
		user.head=head;
		user.userName=userName;
		user.password=password;
		session.put("user",user);
		UserDao userDao=new UserDaoImpl();
	    userDao.addUser(user);
	    return SUCCESS;
	}
}
