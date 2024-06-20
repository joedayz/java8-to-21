package pe.joedayz;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;

/**
 * Fibonacci
 F(0) =0
 F(1) = 1
 F(n) = F(n-1) + F(n-2) para n>=2

 */
public class Fibonacci {


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
