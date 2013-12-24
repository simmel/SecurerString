import org.junit.*;
import se.soy.insecurerstring.*;

public class FoundNamedStringErased extends FoundInHeap {
  @Test public void foundNamedStringErased() {
    String namedString = "really_unique_string";
    InSecurerString.secureErase(namedString);
    System.out.println(getClass().getName());
  }
}
