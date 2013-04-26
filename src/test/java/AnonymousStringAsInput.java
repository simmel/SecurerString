import org.junit.*;
import se.soy.securerstring.*;

public class AnonymousStringAsInput extends SearchInHeap {
  @Test public void anonymousStringAsInput() {
    try (SecurerString c = new SecurerString("really_unique_string")) {
      System.out.println(getClass().getName());
    }
  }
}
