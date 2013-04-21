import org.junit.*;
import se.soy.securerstring.*;

public class NamedStringAsInput {
  @Test public void namedStringAsInput() {
    String namedString = "hej";
    try (SecurerString c = new SecurerString(namedString)) {
      System.out.println(getClass().getName());
    }
  }
}
