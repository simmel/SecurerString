Securer"String"
===============
A "string", really a char, class inspired by
[SecureString](http://msdn.microsoft.com/en-us/library/system.security.securestring.aspx)
from .NET to be used for properly sanitising sensitive data such as passwords.
Both input Strings and chars and the char that is created will be overwritten
with random data after used.

The char created is also size in a multiple of 1024 to make it
more difficult to guess the length of the sensitive "string", e.g. a password.

*Note: The size of the input char/string can never be changed, so create a
larger char that you are using otherwise you'll leak the length of the
password.* This is sadly not possible when using e.g.
`java.io.Console.readPassword`, see the example below.

The class is possible because of the Java 7 feature [try-with-resources](http://docs.oracle.com/javase/tutorial/essential/exceptions/tryResourceClose.html) and by implementing [AutoCloseable](http://docs.oracle.com/javase/7/docs/api/java/lang/AutoCloseable.html).

You can also just use `SecurerString.secureErase()` to securely erase an char
or a String. It's to be used sort of like `free()` in C and probably as easy to
forget as it too. The recommendation is to use the try-with-resources version
below.

TODO
----

* Make byte arrays eraseable


Usage/Example
-------------
```java
import se.soy.securerstring.*;
import java.io.Console;

public class SecureStringur {
  public static void main(String[] args) throws Exception {
    Console cnsl = System.console();
    if (cnsl == null) {
      throw new Exception("No console");
    }
    char[] password = cnsl.readPassword("Password: ");

    try (SecurerString p = new SecurerString(password)) {
      System.out.print("SecurerString is: ");
      System.out.println(p.value);
    }
    System.out.print("Password was: ");
    System.out.println(password);
  }
}
```
