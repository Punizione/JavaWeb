package package02;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
public class CountFileHandler2_5 {
  //������������ݵ��ض��ı��ļ���
  public static void writeFile(String filename, long count) {
    try {
      PrintWriter out = new PrintWriter(new FileWriter(filename));
      out.println(count);  //��������д���ļ�
      out.close();
    } catch (IOException e) {
        e.printStackTrace();
      }
    }

    public static long readFile(String filename) {
      long count = 0;               //����һ��������ŷ�����
      try {
        File f = new File(filename);   //����һ��File���Ͷ���
        if (!f.exists()) {
          writeFile(filename, 0);     //�����ض��ı��ļ�����д���������ֵΪ0
        }
        BufferedReader in = new BufferedReader(new FileReader(f));
        count = Long.parseLong(in.readLine());    //����ȡ���ַ�ת������
        in.close();
      } catch (IOException e) {
        e.printStackTrace();
      }
      return count;
    }
  }

