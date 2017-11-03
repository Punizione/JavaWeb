package model;
public class GoodsInfo {
  // 商品ID
  private int goodsId=0;
  public int getGoodsId() {
    return goodsId;
  }
  public void setGoodsId(int id) {
    this.goodsId = id;
  }
  // 商品名称
  private String goodsName="";
  public String getGoodsName() {
    return goodsName;
  }
  public void setGoodsName(String name) {
    this.goodsName = name;
  } 
  //品牌名称
  private String brandName="";
  public String getBrandName() {
    return brandName;
  }
  public void setBrandName(String name) {
    this.brandName = name;
  }
  // 图片地址
private String goodsImageAddress;
  public String getGoodsImageAddress() {
    return goodsImageAddress;
  }
  public void setGoodsImageAddress(String address) {
    this.goodsImageAddress = address;
  }
  // 投票数量
  private int goodsNumber=0;
  public int getGoodsNumber() {
    return goodsNumber;
  }
  public void setGoodsNumber(int num) {
    this.goodsNumber = num;
  }
  // 排列顺序
  private int goodsOrder=0;
  public int getGoodsOrder() {
    return goodsOrder;
  }
  public void setGoodsOrder(int order) {
    this.goodsOrder = order;
  } 
  // 投票总计
  private long voteTotal=0;
  public long getVoteTotal() {
    return voteTotal;
  }
  public void setVoteTotal(long num) {
    this.voteTotal = num;
  }  
  // 投票最多
  private double voteMax=0.0;
  public double getVoteMax() {
    return voteMax;
  }
  public void setVoteMax(double num) {
    this.voteMax = num;
  }  
}

