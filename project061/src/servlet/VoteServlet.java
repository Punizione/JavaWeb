package servlet;

import java.awt.Font;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartRenderingInfo;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.StandardChartTheme;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.CategoryLabelPositions;
import org.jfree.chart.entity.StandardEntityCollection;
import org.jfree.chart.labels.StandardCategoryToolTipGenerator;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.labels.StandardPieToolTipGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;

import model.GoodsInfo;
import dao.GetDataDao;

public class VoteServlet extends HttpServlet{
	
	static int width = 0;
	static int height = 0;
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)  
	        throws ServletException, IOException{
		doPost(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request , HttpServletResponse response)  throws ServletException, IOException {
		String servletPath = request.getServletPath();
	  if ("/vote".equals(servletPath))
	    vote(request, response);
	  else if ("/viewresult".equals(servletPath))
	    showresult(request, response);
	}
	private void vote(HttpServletRequest request, HttpServletResponse response)
		    throws ServletException, IOException {
		  String message = "";
		  String showpage = "";
		  String[] optionid = request.getParameterValues("commodity");
		  int i =new GetDataDao().vote(optionid);
		  if (i <= 0) {
		    message = "投票失败！";
		  } else {
		    HttpSession session = request.getSession();
		    session.setMaxInactiveInterval(3600);
		    session.setAttribute("ido", "yes");
		    showpage = "index.jsp";
		  }

		  request.setAttribute("message", message);
		  RequestDispatcher rd = request.getRequestDispatcher(showpage);
		  rd.forward(request, response);
		}
	
protected void showresult(HttpServletRequest request,
	    HttpServletResponse response) throws ServletException, IOException {
	  String forward = "";
	  String showmode = request.getParameter("showmode"); 
	  JFreeChart chart = null;
	  if ("pie".equals(showmode))     // 绘制饼型图
	    chart = getChartForPie();
	  else
	    // 绘制柱型图
	    chart = getChartForBar();
	  if (chart != null) {
	    myplot(showmode, chart);                         // 设置各标签的显示样式
	    String webName = getServletContext().getRealPath("/img");
	    String picpath = webName + "/" + showmode + ".jpg";    // 图片文件路径
	    FileOutputStream plot_fos = new FileOutputStream(picpath);
	    ChartRenderingInfo info = new ChartRenderingInfo( new StandardEntityCollection());
	    ChartUtilities.writeChartAsJPEG(plot_fos, 0.8f, chart, width, height, info);  //生成图片文件
	    plot_fos.close();
	    request.setAttribute("path", showmode);   
	    forward = "/showResult.jsp";
	  } else {
	    request.setAttribute("message", "所查看的时间段中没有数据！");
	    forward = "/fail.jsp";
	  }
	  RequestDispatcher rd = request.getRequestDispatcher(forward);
	  rd.forward(request, response);
	}
/** @功能：获取柱型图的JFreeChart */
private JFreeChart getChartForBar() {
  CategoryDataset dataset = null;
  JFreeChart chart = null;
  String title1 = "";
  String title2 = "";
  String subtitle = "";
  PlotOrientation way = null;
  // 处理查看"各选项得票数"的请求
  dataset = getDataSetForBarAndOption() ; // 获取数据集
  title1 = "各个手机品牌所得票数";
  title2 = "手机品牌";
  way = PlotOrientation.VERTICAL;
  width = 80 + 50 * dataset.getColumnCount();
  height = 400;
  setCN();    //设置字体解决中文乱码
  if (dataset != null && dataset.getColumnCount() > 0) {
    chart = ChartFactory.createBarChart3D(title1, title2, "票数",
        dataset, way, false, true, false);
    chart.addSubtitle(new TextTitle(subtitle));
  }
  return chart;
}
/** @功能：获取饼型图的JFreeChart */
private JFreeChart getChartForPie() {
  DefaultPieDataset dataset = null;
  JFreeChart chart = null;
  String title = "";
  String subtitle = "";
  width = 550;
  height = 430;
  setCN();    //设置字体解决中文乱码
    // 处理查看"各选项得票数"的请求
    dataset = getDataSetForPieAndOption()  ;     // 获取数据集
    title = "各个手机品牌所得票数";
  if (dataset != null && dataset.getItemCount() > 0) {
    chart = ChartFactory.createPieChart3D(title , dataset , true, true , false);
    chart.addSubtitle(new TextTitle(subtitle)) ;     ///设置图例类别字体
  }    
  return chart;
}  
private void myplot(String showmode, JFreeChart chart) {
	  if ("pie".equals(showmode)) {
	    PiePlot pieplot = (PiePlot) chart.getPlot();
	    // 设置普通标签样式
	    pieplot.setLabelGenerator(new StandardPieSectionLabelGenerator("{0} 票数:{1}")) ; 
	    // 设置热区标签样式
	    pieplot.setToolTipGenerator(new StandardPieToolTipGenerator("{0} 比例:{2}")) ; 
	  } else {
	    CategoryPlot barplot = (CategoryPlot) chart.getCategoryPlot();
	    BarRenderer br = (BarRenderer) barplot.getRenderer();
	    // 设置鼠标提示
	    br.setBaseToolTipGenerator(new StandardCategoryToolTipGenerator( "{1} 票数:{2}",   
	                           new DecimalFormat("#,###")));
	    // 设置标签显示样式
	    br.setItemLabelAnchorOffset(10) ;
	    CategoryAxis categoryaxis = barplot.getDomainAxis() ;
	    categoryaxis.setCategoryLabelPositions(CategoryLabelPositions.UP_45) ;
	  }
	}


@SuppressWarnings("rawtypes")
private CategoryDataset getDataSetForBarAndOption() {
GetDataDao optionDao = new GetDataDao();
  List<GoodsInfo> options = null;
  options = optionDao.getOptions();
  optionDao.closed();
  DefaultCategoryDataset dataset = new DefaultCategoryDataset();
  for (int i = 0 ; i < options.size() ; i++) {
    GoodsInfo single = (GoodsInfo) options.get(i);
    dataset.addValue(single.getGoodsNumber() , "" , single.getBrandName());
  }
  return dataset;
}


@SuppressWarnings("rawtypes")
private DefaultPieDataset getDataSetForPieAndOption() {
  DefaultPieDataset dataset = null;
  GetDataDao optionDao = new GetDataDao();
  List options = null;
  options = optionDao.getOptions();
  optionDao.closed();
  if (options != null && options.size() != 0) {
    dataset = new DefaultPieDataset();
    for (int i = 0 ; i < options.size() ; i++) {
      GoodsInfo single = (GoodsInfo) options.get(i);
      if (single.getGoodsNumber() > 0)
        dataset.setValue(single.getBrandName() , single.getGoodsNumber());
    }
  }
  return dataset;
}

//解决中文乱码的方法
private void setCN() {
  // 创建主题样式
  StandardChartTheme standardChartTheme = new StandardChartTheme("CN");
  // 设置标题字体
  standardChartTheme.setExtraLargeFont(new Font("隶书", Font.BOLD, 20));
  // 设置图例的字体
  standardChartTheme.setRegularFont(new Font("宋体", Font.PLAIN, 15));
  // 设置轴向的字体
  standardChartTheme.setLargeFont(new Font("宋体", Font.PLAIN, 15));
// 应用主题样式
  ChartFactory.setChartTheme(standardChartTheme);
}







	
}
