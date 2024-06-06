package pe.joedayz.training.collections.collections;

import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.filtering;
import static java.util.stream.Collectors.toList;

public class StreamTest {

    public static void main(String[] args) {
        Stream streamEmpty = Stream.ofNullable(null);

        streamEmpty.forEach(System.out::println);

        IntStream.range(0, 10)
                .mapToObj(i -> Integer.valueOf(i))
                .collect(filtering(i -> i.intValue()>5, toList()))
                .forEach(System.out::println);
    }
}
