import org.junit.After;
import java.lang.management.*;

public class SearchInHeap {
  @After public void searchInHeap() {
    String pid = ManagementFactory.getRuntimeMXBean().getName().replaceAll("@.*", "");
    System.out.println(pid);
  }
}
