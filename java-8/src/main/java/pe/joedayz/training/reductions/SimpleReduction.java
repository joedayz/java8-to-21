package pe.joedayz.training.reductions;

import java.util.stream.IntStream;

public class SimpleReduction {

    public static void main(String[] args) {
        int result = IntStream.range(0, 100)
                .filter(i -> i % 2 == 0)
                .reduce(0, Integer::sum);

        System.out.println("result = " + result);

        int result2 = IntStream.range(0, 100)
                .filter(i -> i % 2 == 0)
                .map(x -> x*x)
                .reduce(0, Integer::sum);
        System.out.println("Suma de los cuadrados = "+ result2);
    }
}
