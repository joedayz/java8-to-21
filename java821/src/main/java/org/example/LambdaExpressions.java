package org.example;

public class LambdaExpressions {

  public static void main(String[] args) {
    //Antes de Java 8
    Thread t1 = new Thread(new Runnable() {
      @Override
      public void run() {
        //Tarea que se ejecutará en otro thread
      }
    });

    //Post Java 8 usando Lambda
    Thread t2 = new Thread(()-> {
      //Tarea que se ejecutará en otro thread
    });

    Runnable r1 = new Runnable() {
      @Override
      public void run() {
        //task r1
      }
    };

    Runnable r2 = () -> {
      //task r2
    };

    Task obj = new Task();
    Thread thread = new Thread(obj::runThisMethodOnAnotherThread);

  }


}

class Task {
  void runThisMethodOnAnotherThread(){
    //task
  }
}

