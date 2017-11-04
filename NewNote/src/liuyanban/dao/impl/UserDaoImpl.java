package liuyanban.dao.impl;
import liuyanban.dao.UserDao;
import liuyanban.model.Users;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;
public class UserDaoImpl extends BaseDao implements UserDao
{
	private Connection conn=null;
	private PreparedStatement pstmt=null;
	private ResultSet rs=null;
	public int addUser(Users user)
	{
		String sql="insert into users(userName,password,gender,head,regTime) value(?,?,"+user.getgender()+",?,?)";
		String time=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
		String[] param={user.getuserName(),user.getpassword(),user.gethead(),time};
		return this.executeSQL(sql, param);
	}
	public Users findUser(int userId)
	{
		String sql="select * from users where userId=?";
		Users user=null;
		try{
			conn=this.getConn();
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, userId);
			rs=pstmt.executeQuery();
			while(rs.next()){
				user=new Users();
				user.setuserId(rs.getInt("userId"));
				user.setuserName(rs.getString("userName"));
				user.setpassword(rs.getString("password"));
				user.setgender(rs.getInt("gender"));
				user.sethead(rs.getString("head"));
				user.setregTime(rs.getDate("regTime"));
			}
		}catch(Exception e){e.printStackTrace();}
		finally{this.closeAll(conn, pstmt, rs);}
		return user;
	}
	public Users findUser(String userName,String password)
	{
		String sql="select * from users where userName=? and password=?";
		Users user=null;
		try{
			conn=this.getConn();
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, userName);
			pstmt.setString(2, password);
			rs=pstmt.executeQuery();
			while(rs.next())
			{
				user=new Users();
				user.setuserId(rs.getInt("userId"));
				user.setuserName(rs.getString("userName"));
				user.setpassword(rs.getString("password"));
				user.setgender(rs.getInt("gender"));
				user.sethead(rs.getString("head"));
				user.setregTime(rs.getDate("regTime"));
			}
		}catch(Exception e){e.printStackTrace();}
		finally{this.closeAll(conn, pstmt, rs);}
		return user;
	}
}
