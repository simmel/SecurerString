package se.soy.securerstring;
import java.lang.reflect.*;
import java.security.SecureRandom;

public class SecurerString implements AutoCloseable {

  public char[] chars;

  @Override
  public void close() {
    secureErase(this.chars);
  }

  public void secureErase(char extinct[]) {
    byte bytes[] = new byte[extinct.length];
    SecureRandom random = new SecureRandom();
    random.nextBytes(bytes);
    for (int i = 0; i < extinct.length; i = i + 1) {
      extinct[i] = (char)(bytes[i]);
    }
  }

  public int nearestInt(int minLength) {
    int length = 0;
    while (length < minLength) {
      length += 1024;
    }
    return length;
  }

  public SecurerString(String str) {
    Field valueField = null;
    try {
      valueField = String.class.getDeclaredField("value");
    }
    catch (NoSuchFieldException e) {
      e.printStackTrace();
    }
    valueField.setAccessible(true);

    try {
      this.chars = new char[nearestInt(((char[])valueField.get(str)).length)];
      System.arraycopy((char[])valueField.get(str), 0, this.chars, 0, ((char[])valueField.get(str)).length);
      secureErase((char[])valueField.get(str));
    }
    catch (IllegalAccessException e) {
      e.printStackTrace();
    }
  }

  public SecurerString(char[] chr) {
    this.chars = new char[nearestInt(chr.length)];
    System.arraycopy(chr, 0, this.chars, 0, chr.length);
    secureErase(chr);
  }
}
