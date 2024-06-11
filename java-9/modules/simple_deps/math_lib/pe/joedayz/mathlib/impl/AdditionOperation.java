package pe.joedayz.mathlib.impl;

import pe.joedayz.mathapi.Operation;
import pe.joedayz.mathlib.*;

public class AdditionOperation implements Operation<Integer, Integer>{

    public Integer apply(Integer x, Integer y){
        return x + y;
    }
}