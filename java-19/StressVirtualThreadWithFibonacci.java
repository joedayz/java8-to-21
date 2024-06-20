package pe.joedayz;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

public class StressVirtualThreadWithFibonacci {
    public static void main(String[] args) {
        var executor = Executors.newThreadPerTaskExecutor(Thread.ofVirtual().factory());

        IntStream.range(0, 50).forEach(i -> {
            executor.submit(() -> {
                Fibonacci2.parallelFib(47, executor)
                        .thenAccept(result -> {
                            System.out.printf("Virtual Thread %d - %d%n", i, result);
                        });
            });
        });

        while (!executor.isTerminated()) {
            ;
        }
    }
}

 class Fibonacci2 {


    public static long fib(int n) {
        if (n <= 2)
            return 1;
        return fib(n - 1) + fib(n - 2);
    }

    public static CompletableFuture<Long> parallelFib(int n, Executor executor) {
        CompletableFuture<Long> partOne = CompletableFuture.supplyAsync(() -> fib(n - 1), executor);
        CompletableFuture<Long> partTwo = CompletableFuture.supplyAsync(() -> fib(n - 2), executor);
        return partOne.thenCombineAsync(partTwo, (resultOne, resultTwo) -> resultOne + resultTwo, executor);
    }
}