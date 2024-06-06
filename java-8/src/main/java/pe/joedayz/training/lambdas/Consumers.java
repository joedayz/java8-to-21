package pe.joedayz.training.lambdas;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer; //interfaces funcionales

public class Consumers {

    public static void main(String[] args) {
        List<String> names = Arrays.asList("Joe", "John", "Jane", "Alice", "Bob");

        //clase anonima
        names.forEach(new Consumer<String>() {
            @Override
            public void accept(String name) {
                System.out.println(name);
            }
        });

        //version lambda
        names.forEach(n -> System.out.println(n));

        //usar metodo de referencia
        names.forEach(System.out::println);


        Consumer<String> consumer = System.out::println;

        //usando stream para mapear a otra clase
        names.stream()
                .map(Hero::new)
                .map(Hero::getSecretIdentity)
                .forEach(consumer);

    }
}

class Hero{
    private String secretIdentity;

    public Hero(String secretIdentity){
        this.secretIdentity = secretIdentity;
    }
    public String getSecretIdentity(){
        return secretIdentity;
    }
}
