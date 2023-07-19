package org.example;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

public class Reflection {

  public static void main(String[] args) {
    Method[] methods = Object.class.getMethods();
    for(Method m: methods){
      System.out.print(m.getName() + "(");
      for(Parameter p: m.getParameters()){
        System.out.print(p.getName() + " ");
      }
      System.out.println(")");
    }
  }
}
