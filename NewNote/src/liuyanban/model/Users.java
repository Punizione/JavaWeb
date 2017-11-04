package liuyanban.model;
import java.util.Date;
public class Users 
{
	public Integer userId;
	public String userName;
	public String password;
	public String head;
	public Date regTime;
	public String email;
	public int gender;
	public void setuserId(Integer userId)
	{
		this.userId=userId;
	}
	public Integer getuserId()
	{
		return userId;
	}
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
	public void setregTime(Date regTime)
	{
		this.regTime=regTime;
	}
	public Date getregTime()
	{
		return regTime;
	}
	public void setemail(String email)
	{
		this.email=email;
	}
	public String getemail()
	{
		return email;
	}
	public void setgender(int gender)
	{
		this.gender=gender;
	}
	public int getgender()
	{
		return gender;
	}
}
