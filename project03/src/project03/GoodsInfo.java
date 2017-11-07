package project03;


	public class GoodsInfo {
	    // 商品编码
	    private String goodsCode="";
	    public String getGoodsCode() {
	      return goodsCode;
	    }
	    public void setGoodsCode(String code) {
	      this.goodsCode = code;
	    }
	    // 商品名称
	    private String goodsName="";
	    public String getGoodsName() {
	      return goodsName;
	    }
	    public void setGoodsName(String name) {
	      this.goodsName = name;
	    }
	    // 型号参数
	    private String goodsParameter="";
	    public String getGoodsParameter() {
	      return goodsParameter;
	    }
	    public void setGoodsParameter(String para) {
	      this.goodsParameter = para;
	    }    
	    // 价格
	    private double goodsPrice=0.0;
	    public double getGoodsPrice() {
	      return goodsPrice;
	    }
	    public void setGoodsPrice(double price) {
	      this.goodsPrice = price;
	    }
	    // 图片地址
	    private String goodsImageAddress;
	    public String getGoodsImageAddress() {
	      return goodsImageAddress;
	    }
	    public void setGoodsImageAddress(String address) {
	      this.goodsImageAddress = address;
	    }
	}


