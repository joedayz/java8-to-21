package org.example;

import java.io.UnsupportedEncodingException;

public class Encoding {

  public static void main(String[] args) throws UnsupportedEncodingException {
    //Previo a Java 8 este método arrojaba una exception chequeada
    byte[] bytes = { 1, 2, 4, 8, 16, 32, 64, (byte) 128 };
    var str = new String(bytes, "UTF-8");

    //Post Java 8 esto aún sería UTF-8
    var str2 = new String(bytes);
  }
}
