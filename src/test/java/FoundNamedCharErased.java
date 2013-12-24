import org.junit.*;
import se.soy.insecurerstring.*;

public class FoundNamedCharErased extends FoundInHeap {
  @Test public void foundNamedCharErased() {
    char[] namedChar = new char[] {'r', 'e', 'a', 'l', 'l', 'y', '_', 'u', 'n', 'i', 'q', 'u', 'e', '_', 's', 't', 'r', 'i', 'n', 'g'};
    InSecurerString.secureErase(namedChar);
    System.out.println(getClass().getName());
  }
}
