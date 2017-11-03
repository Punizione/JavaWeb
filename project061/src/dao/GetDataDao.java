package dao;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.DbManage;
import model.GoodsInfo;
public class GetDataDao {
  private DbManage mydb=null;
  public GetDataDao(){
    mydb=new DbManage();
  }
  public List<GoodsInfo> getOptions(){
    String sql="select 商品ID,商品名称,品牌名称,图片地址,投票数量,排列顺序  from 商品投票  order by 排列顺序";
    List<GoodsInfo> options=getList1(sql,null);    
    return options;
  }
  

  private List<GoodsInfo> getList1(String sql,Object[] params){
    List<GoodsInfo> options=null;
    DbManage mydb=new DbManage();
    mydb.doPs(sql,params);
    try {
      ResultSet rs = mydb.getRs();
      if(rs!=null){
        options=new ArrayList<>();
        while(rs.next()){
          GoodsInfo info=new GoodsInfo();
          info.setGoodsId(rs.getInt(1));
          info.setGoodsName(rs.getString(2));
          info.setBrandName(rs.getString(3));
          info.setGoodsImageAddress(rs.getString(4));
          info.setGoodsNumber(rs.getInt(5));
          info.setGoodsOrder(rs.getInt(6));
          options.add(info);
        }
        rs.close();
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
 return options;
  }
  
  public long getTotal(){
    long total=0;
    String sql="select sum(投票数量) as 总计  from 商品投票  ";
    DbManage mydb=new DbManage();
    mydb.doPs(sql,null);
    ResultSet rs;
    try {
      rs = mydb.getRs();
      if(rs!=null && rs.next()){
        total=rs.getLong(1);
        GoodsInfo info=new GoodsInfo();
        info.setVoteTotal(total);
        rs.close();
      }
      mydb.closed();
    } catch (SQLException e) {
      e.printStackTrace();
    }  
    return total;
  }
  
  public double getMaxNum(){
    double maxNum=0.0;
    String sql="select max(投票数量) as 最大数量  from 商品投票  ";
    DbManage mydb=new DbManage();
    mydb.doPs(sql,null);
    ResultSet rs;
    try {
      rs = mydb.getRs();
      if(rs!=null && rs.next()){
        maxNum=130.0/(double)rs.getLong(1);
        GoodsInfo info=new GoodsInfo();
        info.setVoteMax(maxNum);
        rs.close();
      }
      mydb.closed();
    } catch (SQLException e) {
      e.printStackTrace();
    }  
    return maxNum;
  }
  
  public int vote(String[] strId){
    int i=0;
    for(i=0;i<strId.length;i++){
    System.out.print(strId[i]);
         String sql="update 商品投票 set 投票数量=投票数量+1 where 商品ID=?";
Object[] params={strId[i]};
      DbManage mydb=new DbManage();
      mydb.doPs(sql, params);
    }    
    return i;
  }
  
  public void closed(){
    mydb.closed();
  }
}
