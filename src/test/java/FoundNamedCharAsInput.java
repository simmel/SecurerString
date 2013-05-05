import org.junit.*;
import se.soy.insecurerstring.*;

public class FoundNamedCharAsInput extends FoundInHeap {
  @Test public void foundNamedCharAsInput() {
    char[] namedChar = new char[] {'r', 'e', 'a', 'l', 'l', 'y', '_', 'u', 'n', 'i', 'q', 'u', 'e', '_', 's', 't', 'r', 'i', 'n', 'g'};
    try (InSecurerString c = new InSecurerString(namedChar)) {
      System.out.println(getClass().getName());
    }
  }
}
