import org.junit.After;
import java.lang.management.*;
import java.io.*;
import java.net.*;

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
    String jhat = "jhat -port " + jhatPort + " " + hprof;
    Process p=Runtime.getRuntime().exec(jhat);

    BufferedReader reader=new BufferedReader(new InputStreamReader(p.getInputStream()));
    String line=reader.readLine();
    while(!line.matches("Server is ready."))
    {
      line=reader.readLine();
    }
    Thread.sleep(1000);

    Runtime.getRuntime().exec(new String[] {"pkill", "-f", jhat}).waitFor();
    new File(hprof).delete();
  }
}
