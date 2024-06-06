package pe.joedayz.training.streams;

import pe.joedayz.training.model.Person;
import pe.joedayz.training.model.Warrior;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Stream;

public class StreamMapTest {

    public static void main(String[] args) {
        List<Person> persons = Person.getList();

        System.out.println("Map operation using anonymous inner class: ");
        Stream<Warrior> warriors = persons.stream()
                .filter(p -> p.getAge() > 20 && p.getAge() < 40)
                // the Function uses two type arguments to use at apply() method:
                // the first is the type of argument and the second is the return type
                .map(new Function<Person, Warrior>() { // Person -> parameter type, Warrior -> return type
                    @Override
                    public Warrior apply(Person person) {
                        return new Warrior(person);
                    }
                });
        warriors.forEach((w) -> System.out.println(w));


        System.out.println("\nMap operation using lambda syntax: ");
        warriors = persons.stream()
                .filter(p -> p.getAge() > 20 && p.getAge() < 40)
                // a simple lambda that call the Warrior's constructor
                .map(person -> new Warrior(person)); // here the lambda expression (anonymous method) is passed as an argument
        warriors.forEach((w) -> System.out.println(w));


        System.out.println("\nMap operation using lambda syntax using the method reference: ");
        warriors = persons.stream()
                .filter(p -> p.getAge() > 20 && p.getAge() < 40)
                // the compiler will figure out which is the type of arg to construct and will use each element from the list
                .map(Warrior::new);  // <Class>:new is a method reference to constructor (used instead of a simple lambda to call the constructor)
        warriors.forEach((w) -> System.out.println(w));


    }
}
