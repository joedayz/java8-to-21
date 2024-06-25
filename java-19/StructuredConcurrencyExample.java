import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ExecutionException;

public class StructuredConcurrencyExample {
          

          public static void main(String[] args) throws InterruptedException, ExecutionException{
                    ExecutorService executorService = Executors.newFixedThreadPool(3);

                    Callable<String> task1 = () -> {
                              Thread.sleep(1000);
                              return "Result of Task1";
                    };

                    Callable<String> task2 = () -> {
                              Thread.sleep(2000);
                              return "Result of Task2";
                    };

                    Callable<String> task3 = () -> {
                              Thread.sleep(3000);
                              return "Result of Task3";
                    };

                    try{
                              Future<String> future1 = executorService.submit(task1);
                              
                              Future<String> future2 = executorService.submit(task2);

                              Future<String> future3 = executorService.submit(task3);

                              System.out.println(future1.get());
                              System.out.println(future2.get());
                              System.out.println(future3.get());
                    }finally{
                              executorService.shutdown();
                    }
          }
}
