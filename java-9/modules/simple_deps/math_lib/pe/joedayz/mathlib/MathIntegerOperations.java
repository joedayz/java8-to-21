package pe.joedayz.mathlib;

import pe.joedayz.mathapi.Operation;
import pe.joedayz.mathlib.impl.*;

public class MathIntegerOperations {
    public static Operation<Integer, Integer> getAdditionOperation(){
        return new AdditionOperation();
    }

    public static Operation<Integer, Integer> getSubstractionOperation(){
        return new SubstractionOperation();
    }
}