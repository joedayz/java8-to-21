package pe.joedayz.calculator;

import pe.joedayz.mathapi.*;
import pe.joedayz.mathlib.*;

public class SimpleCalculator {

    public static void main(String[] args) {
        MathIntegerOperations math = new MathIntegerOperations();
        System.out.println(math);

        Operation<Integer, Integer> add = math.getAdditionOperation();
        System.out.println(add);

        Operation<Integer, Integer> sub = math.getSubstractionOperation();
        System.out.println(sub);
    }
}