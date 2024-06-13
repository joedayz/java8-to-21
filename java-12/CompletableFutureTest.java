import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

public class CompletableFutureTest {
          // public static void main(String[] args) {
          // CompletableFuture.runAsync(CompletableFutureTest::workMethod)
          // .exceptionallyCompose(ex -> {
          // return CompletableFuture.runAsync(() -> System.out.println("Got some error
          // but now I can keep going"));
          // });
          // try {
          // Thread.sleep(1000);
          // } catch (InterruptedException ex) {}
          // }

          public static void main(String[] args) {
                    CompletableFuture.runAsync(CompletableFutureTest::workMethod)
                                        .orTimeout(500, TimeUnit.MILLISECONDS) // Nuevo en Java 12
                                        .handle((result, ex) -> {
                                                  if (ex != null) {
                                                            System.out.println("Got some error but now I can keep going");
                                                            return CompletableFuture.runAsync(() -> System.out.println(
                                                                                "Continuing after handling the error"));
                                                  }
                                                  return CompletableFuture.completedFuture(result);
                                        });

                    try {
                              Thread.sleep(1000);
                    } catch (InterruptedException ex) {
                              Thread.currentThread().interrupt();
                    }
          }

          public static void workMethod() {
                    System.out.println("Working...");
                    throw new IllegalStateException();
          }
}
