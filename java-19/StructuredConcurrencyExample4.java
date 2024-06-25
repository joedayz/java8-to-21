import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import jdk.incubator.concurrent.StructuredTaskScope;
import java.util.concurrent.ExecutionException;

public class StructuredConcurrencyExample4  {
          public static void main(String[] args) {

                    //creando un scope para manejar las tareas concurrentes
                    try (var scope = new StructuredTaskScope.ShutdownOnFailure()) {
                              
                              Callable<String> task1 = () -> {
                                        Thread.sleep(1000);
                                        return "Task 1";
                              };

                              Callable<String> task2 = () -> {
                                        Thread.sleep(2000);
                                        return "Task 2";
                              };

                              Callable<String> task3 = () -> {
                                        Thread.sleep(3000);
                                        return "Task 3";
                              };

                              //Enviar las tareas al scope
                              Future<String> future1 = scope.fork(task1);
                              Future<String> future2 = scope.fork(task2);
                              Future<String> future3 = scope.fork(task3);

                              //iniciar y esperar a que las tareas se completen
                              scope.join();
                              scope.throwIfFailed();

                              //Obtener los resultados

                                        System.out.println(future1.get());
                                        System.out.println(future2.get());
                                        System.out.println(future3.get());

                    } catch (InterruptedException | ExecutionException e){
                       e.printStackTrace();        
                    } 
          }
}
