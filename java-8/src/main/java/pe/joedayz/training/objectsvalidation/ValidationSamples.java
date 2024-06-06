package pe.joedayz.training.objectsvalidation;

import java.util.Objects;

public class ValidationSamples {

    public static void doFoo(String aVar){
        Objects.requireNonNull(aVar, "aVar must not be null");

        System.out.println("Requires non-null value: " + aVar);
    }

    public static void doBar(String anotherVar){
        if(Objects.isNull(anotherVar)){
            System.out.println("Got a null");
        }else{
            System.out.println("Got a non-null value: " + anotherVar);
        }
    }
}
