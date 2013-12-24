import org.junit.*;
import se.soy.securerstring.*;

public class AnonymousStringErased extends SearchInHeap {
  @Test public void anonymousStringErased() {
    SecurerString.secureErase("really_unique_string");
    System.out.println(getClass().getName());
  }
}
