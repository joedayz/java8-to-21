import java.util.concurrent.*;

public class StructuredConcurrencyExample2 {
          public static void main(String[] args) throws InterruptedException, ExecutionException {
                    
                    //Crear 3 tareas que se ejecutan de forma asincrona
                    CompletableFuture<String> future1 = CompletableFuture.supplyAsync(() -> {
                              try{
                                        Thread.sleep(1000);
                              }catch(InterruptedException e){
                                        e.printStackTrace();
                              }
                              return "Result of Task1";
                    });

                    CompletableFuture<String> future2 = CompletableFuture.supplyAsync(() -> {
                              try{
                                        Thread.sleep(2000);
                              }catch(InterruptedException e){
                                        e.printStackTrace();
                              }
                              return "Result of Task2";
                    });

                    CompletableFuture<String> future3 = CompletableFuture.supplyAsync(() -> {
                              try{
                                        Thread.sleep(3000);
                              }catch(InterruptedException e){
                                        e.printStackTrace();
                              }
                              return "Result of Task3";
                    });

                    //Combinar todas las tareas para esperar que todas se completen
                    CompletableFuture<Void> combinedFuture = CompletableFuture.allOf(future1, future2, future3);

                    //Ejecutar una acción una vez que todas las tareas se hayan completado
                    combinedFuture.thenRun(() -> {
                              try{
                                        System.out.println(future1.get());
                                        System.out.println(future2.get());
                                        System.out.println(future3.get());
                              }catch(InterruptedException | ExecutionException e){
                                        e.printStackTrace();
                              }
                    }).join();
          }
}
