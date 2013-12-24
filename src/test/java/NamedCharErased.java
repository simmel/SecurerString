import org.junit.*;
import se.soy.securerstring.*;

public class NamedCharErased extends SearchInHeap {
  @Test public void namedCharErased() {
    char[] namedChar = new char[] {'r', 'e', 'a', 'l', 'l', 'y', '_', 'u', 'n', 'i', 'q', 'u', 'e', '_', 's', 't', 'r', 'i', 'n', 'g'};
    SecurerString.secureErase(namedChar);
    System.out.println(getClass().getName());
  }
}
