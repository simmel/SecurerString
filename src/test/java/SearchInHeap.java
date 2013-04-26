import org.junit.After;
import java.lang.management.*;
import java.io.*;

public class SearchInHeap {
  @After public void searchInHeap() throws IOException, InterruptedException {
    String pid = ManagementFactory.getRuntimeMXBean().getName().replaceAll("@.*", "");
    System.out.println(pid);

    String tmp = System.getProperty("temporaryDir");
    String hprof = tmp + "/" + pid + ".hprof";
    System.out.println(hprof);
    String jhatPort = Integer.toString(7000 + Integer.parseInt(System.getProperty("org.gradle.test.worker")));
    System.out.println(jhatPort);

    Runtime.getRuntime().exec(new String[] {"jmap", String.format("-dump:format=b,file=%s", hprof), pid}).waitFor();

    new File(hprof).delete();
  }
}
