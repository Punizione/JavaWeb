package package02;


import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
public class CounterListener2_4 implements HttpSessionListener {
  private static long onlineNumber = 0;

  public static long getOnlineNumber() {
    return onlineNumber;
  }
@Override
  public void sessionCreated(HttpSessionEvent se) {
    onlineNumber++;
    System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
  }
@Override
  public void sessionDestroyed(HttpSessionEvent se) {
	System.out.println("--------------------------------------------------------");
    onlineNumber--;
  }
}

