package pe.joedayz.consumer;

import java.util.Iterator;
import java.util.ServiceLoader;
import pe.joedayz.provider.Calculator;

public class MadScientist {

    private static Calculator getImplementation(){
        Iterator<Calculator> impls = ServiceLoader.load(Calculator.class).iterator();
        if(impls.hasNext()){
            return impls.next();
        }
        throw new RuntimeException("No implementation provided.");
    }

    public static void main(String[] args) {
        Calculator calculator = getImplementation();
        System.out.println("The answer to the universe is: " + calculator.calculateUniverseMeaning());
    }

}