import org.junit.*;
import se.soy.insecurerstring.*;

public class FoundNamedStringAsInput extends FoundInHeap {
  @Test public void foundNamedStringAsInput() {
    String namedString = "really_unique_string";
    try (InSecurerString c = new InSecurerString(namedString)) {
      System.out.println(getClass().getName());
    }
  }
}
