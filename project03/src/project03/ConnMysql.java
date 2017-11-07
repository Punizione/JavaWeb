package project03;
import java.sql.*;               //����java.sql���е�������
public class ConnMysql {
  public Connection conn = null;   // ����Connection�����ʵ��
  public Statement stmt = null;    // ����Statement�����ʵ��
  public ResultSet rs = null;      // ����ResultSet�����ʵ��
  public static Connection getConnection() {
    String driverClass = "com.mysql.jdbc.Driver";
    String url = "jdbc:mysql://localhost:3306/eshop";
    String user = "root";
    String password = "";
    Connection conn = null;
    try {                      //�������ݿ�ʱ���ܷ����쳣�����Ҫ��׽���쳣
      Class.forName(driverClass);
      conn = DriverManager.getConnection(url, user, password);
    } catch (Exception ex) {
      ex.printStackTrace();                  //����쳣��Ϣ
    }
    if (conn == null) {
      System.err.println("����: ������ݿ�����ʧ��");    //�ڿ���̨�������ʾ��Ϣ
    }
    return conn;                                     //�������ݿ����Ӷ���
  }
  /*
   * ���ܣ�ִ�в�ѯ���
   */
  public ResultSet executeQuery(String sql) {
    try {                         // ��׽�쳣
      conn = getConnection();       // ����getConnection()��������һ��ʵ��conn
      stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                             ResultSet.CONCUR_READ_ONLY);
      rs = stmt.executeQuery(sql);       //ִ��SQL��䣬������һ��ResultSet����rs
    } catch (SQLException ex) {
      System.err.println(ex.getMessage()); // ����쳣��Ϣ
    }
    return rs; // ���ؽ��������
  }
  /*
   * ����:�ر����ݿ������
   */
  public void close() {
    try { // ��׽�쳣
      if (rs != null) {            // ��ResultSet�����ʵ��rs��Ϊ��ʱ
        rs.close();              // �ر�ResultSet����
      }
      if (stmt != null) {          // ��Statement�����ʵ��stmt��Ϊ��ʱ
        stmt.close();            // �ر�Statement����
      }
      if (conn != null) {          // ��Connection�����ʵ��conn��Ϊ��ʱ
 
	        conn.close();            // �ر�Connection����
      }
    } catch (Exception e) {
      e.printStackTrace(System.err);   // ����쳣��Ϣ
    }
  }
}
