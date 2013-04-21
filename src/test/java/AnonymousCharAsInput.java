import org.junit.*;
import se.soy.securerstring.*;

public class AnonymousCharAsInput extends SearchInHeap {
  @Test public void anonymousCharAsInput() {
    try (SecurerString c = new SecurerString(new char[] {'h', 'e', 'j'})) {
      System.out.println(getClass().getName());
    }
  }
}
