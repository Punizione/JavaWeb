package model;
public class GoodsInfo {
  // ��ƷID
  private int goodsId=0;
  public int getGoodsId() {
    return goodsId;
  }
  public void setGoodsId(int id) {
    this.goodsId = id;
  }
  // ��Ʒ����
  private String goodsName="";
  public String getGoodsName() {
    return goodsName;
  }
  public void setGoodsName(String name) {
    this.goodsName = name;
  } 
  //Ʒ������
  private String brandName="";
  public String getBrandName() {
    return brandName;
  }
  public void setBrandName(String name) {
    this.brandName = name;
  }
  // ͼƬ��ַ
private String goodsImageAddress;
  public String getGoodsImageAddress() {
    return goodsImageAddress;
  }
  public void setGoodsImageAddress(String address) {
    this.goodsImageAddress = address;
  }
  // ͶƱ����
  private int goodsNumber=0;
  public int getGoodsNumber() {
    return goodsNumber;
  }
  public void setGoodsNumber(int num) {
    this.goodsNumber = num;
  }
  // ����˳��
  private int goodsOrder=0;
  public int getGoodsOrder() {
    return goodsOrder;
  }
  public void setGoodsOrder(int order) {
    this.goodsOrder = order;
  } 
  // ͶƱ�ܼ�
  private long voteTotal=0;
  public long getVoteTotal() {
    return voteTotal;
  }
  public void setVoteTotal(long num) {
    this.voteTotal = num;
  }  
  // ͶƱ���
  private double voteMax=0.0;
  public double getVoteMax() {
    return voteMax;
  }
  public void setVoteMax(double num) {
    this.voteMax = num;
  }  
}

