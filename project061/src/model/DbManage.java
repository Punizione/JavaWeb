package model;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
public class DbManage {
  private Connection conn;
  private PreparedStatement ps;
  private String className="com.microsoft.sqlserver.jdbc.SQLServerDriver";
  private String url="jdbc:sqlserver://localhost:1433;DatabaseName=eshop";  
  private String user="sa";
  private String password="888888";
  /** 构造方法，在该方法中加载数据库驱动  */
  public DbManage(){
    try{
      Class.forName(className);
    }catch(ClassNotFoundException e){
      System.out.println("加载数据库驱动失败！");
      e.printStackTrace();
    }
  }
  /**创建数据库连接*/
  public Connection getConnn(){
    if(conn==null){
      try {
        conn=DriverManager.getConnection(url,user,password);
      } catch (SQLException e) {
        System.out.println("创建数据库连接失败！");
        conn=null;
        e.printStackTrace();
      }      
    }
    return conn;
  } 
  /**
   *@功能：对数据库进行查、增、删、改操作
   *@参数：sql为SQL语句；params为Object数组，
   *该数组存储的是SQL语句中"?"占位符赋值的数据 
   */
  public void doPs(String sql,Object[] params){
    if(sql!=null&&!sql.equals("")){
      if(params==null)
        params=new Object[0];      
      getConnn();
      if(conn!=null){
        try{    
          System.out.println(sql);
          ps=conn.prepareStatement(sql , ResultSet.TYPE_SCROLL_INSENSITIVE,  ResultSet.CONCUR_READ_ONLY);
          for(int i=0;i<params.length;i++){
            ps.setObject(i+1,params[i]);
          }
          ps.execute();
        }catch(SQLException e){
          System.out.println("doPs()方法出错！");
          e.printStackTrace();
        }        
      }      
    }
  }  
  /**
   * @功能：获取调用doPs()方法执行查询操作后返回的ResultSet结果集
   * @返回值：ResultSet
   * @throws SQLException
   */
  public ResultSet getRs() throws SQLException{
    return ps.getResultSet();  
  }
  /**
   * @功能：获取调用doPs()方法执行更新操作后返回影响的记录数
   * @返回值：int
   * @throws SQLException
   */
  public int getCount() throws SQLException{
    return ps.getUpdateCount();    
  }
  /**
   * @功能：释放PrepareStatement对象与Connection对象
   */
  public void closed(){
    try{
      if(ps!=null)
        ps.close();      
    }catch(SQLException e){
      System.out.println("关闭ps对象失败！");
      e.printStackTrace();
    }
    try{
      if(conn!=null){
        conn.close();
      }
    }catch(SQLException e){
      System.out.println("关闭conn对象失败！");
      e.printStackTrace();
    }
  }
}
