import org.junit.*;
import se.soy.insecurerstring.*;

public class FoundAnonymousCharAsInput extends FoundInHeap {
  @Test public void foundAnonymousCharAsInput() {
    try (InSecurerString c = new InSecurerString(new char[] {'r', 'e', 'a', 'l', 'l', 'y', '_', 'u', 'n', 'i', 'q', 'u', 'e', '_', 's', 't', 'r', 'i', 'n', 'g'})) {
      System.out.println(getClass().getName());
    }
  }
}
