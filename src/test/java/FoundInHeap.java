import static org.junit.Assert.*;
import org.junit.After;
import java.lang.management.*;
import java.io.*;
import java.net.*;
import javax.xml.xpath.*;
import org.xml.sax.InputSource;
import org.w3c.dom.NodeList;

public class FoundInHeap extends SearchInHeap {
  void theAssert(int found) {
      assertEquals("Secret not found!", 2, found);
  }
}
