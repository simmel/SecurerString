import org.junit.*;
import se.soy.securerstring.*;

public class NamedCharAsInput extends SearchInHeap {
  @Test public void namedCharAsInput() {
    char[] namedChar = new char[] {'r', 'e', 'a', 'l', 'l', 'y', '_', 'u', 'n', 'i', 'q', 'u', 'e', '_', 's', 't', 'r', 'i', 'n', 'g'};
    try (SecurerString c = new SecurerString(namedChar)) {
      System.out.println(getClass().getName());
    }
  }
}
