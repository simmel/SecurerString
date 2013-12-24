import org.junit.*;
import se.soy.securerstring.*;

public class AnonymousCharErased extends SearchInHeap {
  @Test public void anonymousCharErased() {
    SecurerString.secureErase(new char[] {'r', 'e', 'a', 'l', 'l', 'y', '_', 'u', 'n', 'i', 'q', 'u', 'e', '_', 's', 't', 'r', 'i', 'n', 'g'});
    System.out.println(getClass().getName());
  }
}
