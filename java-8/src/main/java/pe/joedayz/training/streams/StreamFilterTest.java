package pe.joedayz.training.streams;

import pe.joedayz.training.model.Person;

import java.util.List;
import java.util.stream.Stream;

public class StreamFilterTest {

    public static void main(String[] args) {
        List<Person> people = Person.getList();

        Stream<Person> peopleStream = people.stream();

        Stream<Person> filteredPeople = peopleStream.filter(p -> p.getAge() >=18 );

        //filteredPeople.forEach(System.out::println);
        filteredPeople.forEach(p -> System.out.println(p));
    }
}
