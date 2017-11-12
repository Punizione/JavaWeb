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
  /** ���췽�����ڸ÷����м������ݿ�����  */
  public DbManage(){
    try{
      Class.forName(className);
    }catch(ClassNotFoundException e){
      System.out.println("�������ݿ�����ʧ�ܣ�");
      e.printStackTrace();
    }
  }
  /**�������ݿ�����*/
  public Connection getConnn(){
    if(conn==null){
      try {
        conn=DriverManager.getConnection(url,user,password);
      } catch (SQLException e) {
        System.out.println("�������ݿ�����ʧ�ܣ�");
        conn=null;
        e.printStackTrace();
      }      
    }
    return conn;
  } 
  /**
   *@���ܣ������ݿ���в顢����ɾ���Ĳ���
   *@������sqlΪSQL��䣻paramsΪObject���飬
   *������洢����SQL�����"?"ռλ����ֵ������ 
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
          System.out.println("doPs()��������");
          e.printStackTrace();
        }        
      }      
    }
  }  
  /**
   * @���ܣ���ȡ����doPs()����ִ�в�ѯ�����󷵻ص�ResultSet�����
   * @����ֵ��ResultSet
   * @throws SQLException
   */
  public ResultSet getRs() throws SQLException{
    return ps.getResultSet();  
  }
  /**
   * @���ܣ���ȡ����doPs()����ִ�и��²����󷵻�Ӱ��ļ�¼��
   * @����ֵ��int
   * @throws SQLException
   */
  public int getCount() throws SQLException{
    return ps.getUpdateCount();    
  }
  /**
   * @���ܣ��ͷ�PrepareStatement������Connection����
   */
  public void closed(){
    try{
      if(ps!=null)
        ps.close();      
    }catch(SQLException e){
      System.out.println("�ر�ps����ʧ�ܣ�");
      e.printStackTrace();
    }
    try{
      if(conn!=null){
        conn.close();
      }
    }catch(SQLException e){
      System.out.println("�ر�conn����ʧ�ܣ�");
      e.printStackTrace();
    }
  }
}
