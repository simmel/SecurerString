import org.junit.*;
import se.soy.securerstring.*;

public class NamedStringAsInput extends SearchInHeap {
  @Test public void namedStringAsInput() {
    String namedString = "really_unique_string";
    try (SecurerString c = new SecurerString(namedString)) {
      System.out.println(getClass().getName());
    }
  }
}
