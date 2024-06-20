package pe.joedayz;

import java.util.concurrent.Executors;
import java.util.stream.IntStream;

public class StressPlatformThread {

    public static void main(String[] args) {
        var executor = Executors.newCachedThreadPool();

        //10_000 threads y duration 500ms, se va a reiniciar tu maquina
        //prueba con 1000 y no tendras problemas
        IntStream.range(0, 1_000).forEach(i -> {
            executor.submit(() -> {
                System.out.printf("Thread %d - %s%n", i, Thread.currentThread().getName());
                try{
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        });
    }
}
