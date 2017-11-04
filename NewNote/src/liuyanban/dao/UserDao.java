package liuyanban.dao;
import liuyanban.model.Users;

public interface UserDao
{
	public Users findUser(int userId);
	public Users findUser(String userName,String password);
	public int addUser(Users user);
}
