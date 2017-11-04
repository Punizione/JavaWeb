package liuyanban.action;
import java.util.Map;
import liuyanban.dao.UserDao;
import liuyanban.dao.impl.UserDaoImpl;
import liuyanban.model.Users;
import com.opensymphony.xwork2.*;
public class LoginAction extends ActionSupport
{
	private String userName;
	private String password;
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String execute()throws Exception
	{
		UserDao userDao=new UserDaoImpl();
		Users user=userDao.findUser(userName,password);
		if(null==user)
		{
			this.addActionError("用户名或密码错误！");
			return LOGIN;
		}
		else{
			ActionContext context=ActionContext.getContext();
			Map session=context.getSession();
			session.put("user",user);
			return SUCCESS;
		}
	}
	public String logout()
	{
		ActionContext context=ActionContext.getContext();
		Map session=context.getSession();
		session.clear();
		return LOGIN;
	}
}
