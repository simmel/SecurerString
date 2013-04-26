import org.junit.After;
import java.lang.management.*;

public class SearchInHeap {
  @After public void searchInHeap() {
    String pid = ManagementFactory.getRuntimeMXBean().getName().replaceAll("@.*", "");
    System.out.println(pid);

    String tmp = System.getProperty("temporaryDir");
    String hprof = tmp + "/" + pid + ".hprof";
    System.out.println(hprof);
    String jhatPort = Integer.toString(7000 + Integer.parseInt(System.getProperty("org.gradle.test.worker")));
    System.out.println(jhatPort);
  }
}
