package project03;


	public class GoodsInfo {
	    // ��Ʒ����
	    private String goodsCode="";
	    public String getGoodsCode() {
	      return goodsCode;
	    }
	    public void setGoodsCode(String code) {
	      this.goodsCode = code;
	    }
	    // ��Ʒ����
	    private String goodsName="";
	    public String getGoodsName() {
	      return goodsName;
	    }
	    public void setGoodsName(String name) {
	      this.goodsName = name;
	    }
	    // �ͺŲ���
	    private String goodsParameter="";
	    public String getGoodsParameter() {
	      return goodsParameter;
	    }
	    public void setGoodsParameter(String para) {
	      this.goodsParameter = para;
	    }    
	    // �۸�
	    private double goodsPrice=0.0;
	    public double getGoodsPrice() {
	      return goodsPrice;
	    }
	    public void setGoodsPrice(double price) {
	      this.goodsPrice = price;
	    }
	    // ͼƬ��ַ
	    private String goodsImageAddress;
	    public String getGoodsImageAddress() {
	      return goodsImageAddress;
	    }
	    public void setGoodsImageAddress(String address) {
	      this.goodsImageAddress = address;
	    }
	}


