package pe.joedayz.training.lambdas;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class One {

    public static void main(String[] args) {
        //Version fea de guardar en un arraylist
        List<Integer> numbers = new ArrayList<>();
        IntStream.range(0, 10)
                .filter(i -> i % 2 == 0)
                //.forEach(numbers::add);
                .forEach(i -> numbers.add(i));

        numbers.forEach(System.out::println);

        //version bonita: usando collector
        List<Integer> oddNumbers = IntStream.range(0, 10)
                .filter(i -> i % 2 == 0)
                .boxed()
                .collect(Collectors.toList());

        oddNumbers.forEach(System.out::println);

    }
}
