import org.junit.*;
import se.soy.securerstring.*;

public class AnonymousCharAsInput extends SearchInHeap {
  @Test public void anonymousCharAsInput() {
    try (SecurerString c = new SecurerString(new char[] {'r', 'e', 'a', 'l', 'l', 'y', '_', 'u', 'n', 'i', 'q', 'u', 'e', '_', 's', 't', 'r', 'i', 'n', 'g'})) {
      System.out.println(getClass().getName());
    }
  }
}
