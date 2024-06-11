package pe.joedayz.mathapi;

public interface Operation<T, E>{
    public T apply(E x, E y);
}