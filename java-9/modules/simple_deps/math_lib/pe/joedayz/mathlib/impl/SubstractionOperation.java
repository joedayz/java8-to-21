package pe.joedayz.mathlib.impl;

import pe.joedayz.mathapi.Operation;
import pe.joedayz.mathlib.*;

public class SubstractionOperation implements Operation<Integer, Integer>{

    public Integer apply(Integer x, Integer y){
        return x - y;
    }
}