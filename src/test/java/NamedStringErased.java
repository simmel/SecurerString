import org.junit.*;
import se.soy.securerstring.*;

public class NamedStringErased extends SearchInHeap {
  @Test public void namedStringErased() {
    String namedString = "really_unique_string";
    SecurerString.secureErase(namedString);
    System.out.println(getClass().getName());
  }
}
