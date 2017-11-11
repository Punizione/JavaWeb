package project04;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;;
@SuppressWarnings("serial")
public class GoodsServlet extends HttpServlet {
  Connection conn = null;             // ����Connection�����ʵ��
  ResultSet rs = null;                // ����ResultSet�����ʵ��  
  PreparedStatement pstat = null;      // ����PreparedStatement�����ʵ��
  String sql = null;
  public void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
  conn = ConnDB.getConnection(); 
  String operate = request.getParameter("action");   //��ȡaction����ֵ  
  //����Ʒ���빺�ﳵ
  if (operate.equals("add")){
    //����Ʒ����ȡ����ѡ����Ʒ������
    String goodsCode = request.getParameter("code");    
    sql="select ��Ʒ����,�۸�,��������  from ���ﳵ�� where ��Ʒ����=?";
    try {
      String name=null , price=null , num=null , preferentialPrice=null , address=null;  
      pstat = conn.prepareStatement(sql);
      pstat.setString(1,goodsCode);
      rs = pstat.executeQuery();
      if (rs.next()){
num=rs.getString("��������").trim();
        price = rs.getString("�۸�").trim();
        sql = "update ���ﳵ��  set �������� = ?, ��� = ? where ��Ʒ����=?";
        pstat = conn.prepareStatement(sql);
        pstat.setInt(1,new Integer(num)+1);
        pstat.setDouble(2,(new Integer(num)+1)*new Double(price));
        pstat.setString(3,goodsCode);
        pstat.executeUpdate();
        pstat.close();    
        conn.close();            //�ر����ݿ�����
      }else{
        sql="select ��Ʒ����,��Ʒ����,�۸�,�Żݼ۸�,ͼƬ��ַ "  
            + " from ��Ʒ���ݱ� where ��Ʒ����=?";
        pstat = conn.prepareStatement(sql);
        pstat.setString(1,goodsCode);
        rs = pstat.executeQuery();
        if (rs.next()){
          name = rs.getString("��Ʒ����").trim();
          price = rs.getString("�۸�").trim();
          preferentialPrice=rs.getString("�Żݼ۸�").trim();
          address=rs.getString("ͼƬ��ַ").trim();
        }
        Date buyDate = new Date();
        SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd");
                String strDate=sdf.format(buyDate);//        
        //����ѡ����Ʒ���뵽���ﳵ��
        sql = "insert into ���ﳵ��(��Ʒ����,��Ʒ����,�۸�,�Żݼ۸�,��������" 
             + ",���,��������,ͼƬ��ַ) values(?,?,?,?,?,?,?,?)";
        pstat = conn.prepareStatement(sql);
        pstat.setString(1,goodsCode);
        pstat.setString(2,name);
        pstat.setString(3,price);
        pstat.setString(4,preferentialPrice);
        pstat.setInt(5,1);
        pstat.setDouble(6,new Double(price)*1);
        pstat.setString(7, strDate);
        pstat.setString(8,address);
        pstat.executeUpdate();
        pstat.close();    
        conn.close();                   //�ر����ݿ�����
      }      
    } catch (SQLException e1) {
     e1.printStackTrace();
    }
    response.sendRedirect("cartServlet");    //�ض��򵽹��ﳵҳ��
  } 
  //������Ʒ������
  if (operate.equals("update")){
    String id = request.getParameter("code");
    int num = Integer.parseInt(request.getParameter("num"));
double price=Double.parseDouble(request.getParameter("price"));
    sql = "update ���ﳵ��  set �������� = ?, ��� = ? where ��Ʒ����=?";
    try {
      pstat = conn.prepareStatement(sql);
      pstat.setInt(1,num);
      pstat.setDouble(2,new Double(price*num));
      pstat.setString(3,id);
      pstat.executeUpdate();
      pstat.close();    
      conn.close();                        //�ر����ݿ�����
      response.sendRedirect("cartServlet");    //�ض��򵽹��ﳵҳ��
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }  
  //����Ʒ�˻ص���Ʒ��(����Ʒ�ӹ��ﳵ��ɾ��)
  if (operate.equals("del")){
    String id = request.getParameter("code");
    sql = "delete from ���ﳵ�� where ��Ʒ����=?";
    try {
      pstat = conn.prepareStatement(sql);
      pstat.setString(1,id);
      pstat.executeUpdate();
      pstat.close();    
      conn.close();                         //�ر����ݿ�����  
      response.sendRedirect("cartServlet");     //�ض��򵽹��ﳵҳ��
    } catch (SQLException e) {
       e.printStackTrace();
    }
  }
  //��չ��ﳵ
  if (operate.equals("clear")){
    String sql=null;
    sql = "delete from ���ﳵ��";
    try {
      pstat = conn.prepareStatement(sql);
      pstat.executeUpdate();
      pstat.close();    
      conn.close();                        //�ر����ݿ�����
      response.sendRedirect("cart4-1.jsp");     //�ض��򵽹��ﳵҳ��
    } catch (SQLException e) {
       e.printStackTrace();
    }
  }
  }
}

