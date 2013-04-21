import org.junit.*;
import se.soy.securerstring.*;

public class NamedCharAsInput extends SearchInHeap {
  @Test public void namedCharAsInput() {
    char[] namedChar = new char[] {'h', 'e', 'j'};
    try (SecurerString c = new SecurerString(namedChar)) {
      System.out.println(getClass().getName());
    }
  }
}
