import org.junit.*;
import se.soy.insecurerstring.*;

public class FoundAnonymousStringAsInput extends FoundInHeap {
  @Test public void foundAnonymousStringAsInput() {
    try (InSecurerString c = new InSecurerString("really_unique_string")) {
      System.out.println(getClass().getName());
    }
  }
}
