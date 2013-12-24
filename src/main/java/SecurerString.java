/* Copyright (c) 2013-, Simon Lundström <simmel@soy.se>

Permission to use, copy, modify, and/or distribute this software for any
purpose with or without fee is hereby granted, provided that the above
copyright notice and this permission notice appear in all copies.

THE SOFTWARE IS PROVIDED "AS IS" AND THE AUTHOR DISCLAIMS ALL WARRANTIES WITH
REGARD TO THIS SOFTWARE INCLUDING ALL IMPLIED WARRANTIES OF MERCHANTABILITY AND
FITNESS. IN NO EVENT SHALL THE AUTHOR BE LIABLE FOR ANY SPECIAL, DIRECT,
INDIRECT, OR CONSEQUENTIAL DAMAGES OR ANY DAMAGES WHATSOEVER RESULTING FROM
LOSS OF USE, DATA OR PROFITS, WHETHER IN AN ACTION OF CONTRACT, NEGLIGENCE OR
OTHER TORTIOUS ACTION, ARISING OUT OF OR IN CONNECTION WITH THE USE OR
PERFORMANCE OF THIS SOFTWARE.
*/
package se.soy.securerstring;
import java.lang.reflect.*;
import java.security.SecureRandom;

public class SecurerString implements AutoCloseable {

  public char[] chars;

  @Override
  public void close() {
    secureEraseInstance(this.chars);
  }

  public static void secureErase(char extinct[]) {
    try (SecurerString c = new SecurerString(extinct)) {}
  }

  public static void secureErase(String extinct) {
    try (SecurerString c = new SecurerString(extinct)) {}
  }

  public void secureEraseInstance(char extinct[]) {
    byte bytes[] = new byte[extinct.length];
    SecureRandom random = new SecureRandom();
    random.nextBytes(bytes);
    for (int i = 0; i < extinct.length; i = i + 1) {
      extinct[i] = (char)(bytes[i]);
    }
  }

  public void secureEraseInstance(String extinct) {
    Field valueField = null;
    try {
      valueField = String.class.getDeclaredField("value");
    }
    catch (NoSuchFieldException e) {
      e.printStackTrace();
    }

    valueField.setAccessible(true);
    try {
      secureEraseInstance((char[])valueField.get(extinct));
    }
    catch (IllegalAccessException e) {
      e.printStackTrace();
    }
  }

  public int nearestInt(int minLength) {
    int length = 0;
    while (length < minLength) {
      length += 1024;
    }
    return length;
  }

  public SecurerString() {
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
      secureEraseInstance((char[])valueField.get(str));
    }
    catch (IllegalAccessException e) {
      e.printStackTrace();
    }
  }

  public SecurerString(char[] chr) {
    this.chars = new char[nearestInt(chr.length)];
    System.arraycopy(chr, 0, this.chars, 0, chr.length);
    secureEraseInstance(chr);
  }
}
