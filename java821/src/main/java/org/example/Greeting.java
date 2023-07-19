package org.example;

public interface Greeting {

  void hello();

  static Greeting createGreeting(){
    return new GreetingImplementation();
  }

  default void goodbye(){
    System.out.println("Goodbye");
  }

}
