package dao;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import model.DbManage;
public class VoterDao {
  public Date getLastVoteTime(long ip) throws SQLException{
    Date time=null;
    String sql="select max(�ϴ�ͶƱʱ��) from ͶƱ��Ϣ where ͶƱ��IP=?";
    Object[] params={ip};
    DbManage mydb=new DbManage();
    mydb.doPs(sql, params);
 ResultSet rs=mydb.getRs();
    if(rs!=null && rs.next()){
      time=rs.getTimestamp(1);
      rs.close();
    }
    mydb.closed();
    return time;
}

  @SuppressWarnings("unused")
  public void  saveVoteTime(Object[] params){
    String sql="insert into ͶƱ��Ϣ  values(?,?)";
    DbManage mydb=new DbManage();
    mydb.doPs(sql, params);
    try {
      int i=mydb.getCount();
    } catch (SQLException e) {
      e.printStackTrace();
    }
    mydb.closed();
  }
}
