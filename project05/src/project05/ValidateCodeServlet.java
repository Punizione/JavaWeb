package project05;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.*;

public class ValidateCodeServlet extends HttpServlet{

	public static int WIDTH = 63;
	public static int HEIGHT = 29;
	protected void doGet(HttpServletRequest request, HttpServletResponse response)  
	        throws ServletException, IOException {
	  HttpSession session = request.getSession();   
	  response.setContentType("image/jpeg");   
	  ServletOutputStream sos = response.getOutputStream();   
	  response.setHeader("Pragma", "No-cache");   
	  response.setHeader("Cache-Control", "no-cache");   
	  response.setDateHeader("Expires", 0);   
	  BufferedImage image = new BufferedImage(WIDTH, 
	                          HEIGHT,BufferedImage.TYPE_INT_RGB);   
	  Graphics g = image.getGraphics();   
	  char[] rands = generateCheckCode();   
	  drawBackground(g);   
	  drawRands(g, rands);   
	  g.dispose();   
	  ByteArrayOutputStream bos = new ByteArrayOutputStream();   
	  ImageIO.write(image, "JPEG", bos);   
	  byte[] buf = bos.toByteArray();   
	  response.setContentLength(buf.length);   
	  sos.write(buf);   
	  bos.close();   
	  sos.close();   
	  session.setAttribute("randomCode", new String(rands));   
	  }   
	   private void drawBackground(Graphics g) {   
	  g.setColor(new Color(0xDCDCDC));   
	  g.fillRect(0, 0, WIDTH, HEIGHT);   
	  for (int i = 0; i < 120; i++) {   
	   int x = (int) (Math.random() * WIDTH);   
	   int y = (int) (Math.random() * HEIGHT);   
	   int red = (int) (Math.random() * 255);   
	   int green = (int) (Math.random() * 255);   
	   int blue = (int) (Math.random() * 255);   
	   g.setColor(new Color(red, green, blue));   
	   g.drawOval(x, y, 1, 0);   
	  }   
	   }  
	 private void drawRands(Graphics g, char[] rands) {   
	  Random random = new Random();   
	  int red = random.nextInt(110);   
int green = random.nextInt(50);   
	  int blue = random.nextInt(50);   
	  g.setColor(new Color(red, green, blue));   
	  g.setFont(new Font(null, Font.ITALIC | Font.BOLD, 18));   
	  g.drawString("" + rands[0], 1, 17);   
	  g.drawString("" + rands[1], 16, 15);   
	  g.drawString("" + rands[2], 31, 18);   
	  g.drawString("" + rands[3], 46, 16);   
	   }   
	   private char[] generateCheckCode() {   
	  String chars = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";   
	  char[] rands = new char[4];   
	  for (int i = 0; i < 4; i++) {   
	   int rand = (int) (Math.random() * 36);   
	   rands[i] = chars.charAt(rand);   
	  }   
	  return rands;   
	}
	   
	   


}
