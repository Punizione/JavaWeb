package package02;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
public class CountFileHandler2_5 {
  //保存访问量数据到特定文本文件中
  public static void writeFile(String filename, long count) {
    try {
      PrintWriter out = new PrintWriter(new FileWriter(filename));
      out.println(count);  //将访问量写入文件
      out.close();
    } catch (IOException e) {
        e.printStackTrace();
      }
    }

    public static long readFile(String filename) {
      long count = 0;               //定义一个变量存放访问量
      try {
        File f = new File(filename);   //创建一个File类型对象
        if (!f.exists()) {
          writeFile(filename, 0);     //创建特定文本文件，并写入访问量的值为0
        }
        BufferedReader in = new BufferedReader(new FileReader(f));
        count = Long.parseLong(in.readLine());    //将读取的字符转换类型
        in.close();
      } catch (IOException e) {
        e.printStackTrace();
      }
      return count;
    }
  }

