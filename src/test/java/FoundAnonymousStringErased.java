import org.junit.*;
import se.soy.insecurerstring.*;

public class FoundAnonymousStringErased extends FoundInHeap {
  @Test public void foundAnonymousStringErased() {
    InSecurerString.secureErase("really_unique_string");
    System.out.println(getClass().getName());
  }
}
