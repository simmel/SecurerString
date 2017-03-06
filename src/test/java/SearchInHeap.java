import static org.junit.Assert.*;
import org.junit.After;
import java.lang.management.*;
import java.io.*;
import java.net.*;
import javax.xml.xpath.*;
import org.xml.sax.InputSource;
import org.w3c.dom.NodeList;

public class SearchInHeap {
  @After public void searchInHeap() throws IOException, InterruptedException, XPathExpressionException {
    String pid = ManagementFactory.getRuntimeMXBean().getName().replaceAll("@.*", "");
    String tmp = System.getProperty("temporaryDir");
    String hprof = tmp + "/" + pid + ".hprof";
    String jhatPort = Integer.toString(7000 + Integer.parseInt(System.getProperty("org.gradle.test.worker")));
    String jhat = "jhat -port " + jhatPort + " " + hprof;
    try {
      System.out.println("Dumping heap with jmap");
      Runtime.getRuntime().exec(new String[] {"jmap", String.format("-dump:format=b,file=%s", hprof), pid}).waitFor();

      System.out.println("Starting jhat");
      Process p=Runtime.getRuntime().exec(jhat);

      BufferedReader reader=new BufferedReader(new InputStreamReader(p.getInputStream()));
      String line=reader.readLine();
      while(!line.matches("Server is ready."))
      {
        line=reader.readLine();
      }
      System.out.println("jhat ready!");
      Thread.sleep(1000);

      System.out.println("Running OQL query...");
      URL oqlUrl = new URL("http://localhost:" + jhatPort + "/oql/?query=" + URLEncoder.encode("select a.toString() from [C a where /really_unique_string/.test(a.toString())", "UTF-8"));
      URLConnection oql = oqlUrl.openConnection();
      BufferedReader in = new BufferedReader(new InputStreamReader(oql.getInputStream()));
      String inputLine;
      String xml = "";

      while ((inputLine = in.readLine()) != null)
        xml += inputLine;
      in.close();

      // What I don't do just not to add an external dependency...
      xml = xml.replaceAll("(\\w+)=([^'\"][^ ]+?)([^'\"])", "$1='$2'$3");
      xml = xml.replaceAll("\000", "");
      String xpath = "//table[@border=1]//td";
      XPath xPath = XPathFactory.newInstance().newXPath();
      NodeList nodeList = (NodeList) xPath.evaluate(xpath, new InputSource(new StringReader(xml)), XPathConstants.NODESET);
      theAssert(nodeList.getLength());
    }
    finally {
      Runtime.getRuntime().exec(new String[] {"pkill", "-f", jhat}).waitFor();
      new File(hprof).delete();
    }
  }

  void theAssert(int found) {
      assertEquals("Secret not found!", 0, found);
  }
}
