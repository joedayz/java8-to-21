package pe.joedayz.training.interfaces;

public class InterfaceTest implements B/*, C*/ {
    @Override
    public void abstractMethod() {
        System.out.println("En la clase concreta");
    }
    public void go(){
        concreteMethod();
        A.staticMethod();
        B.staticMethod();
        // staticMethod(); No se heredan
    }

    public static void main(String[] args) {
        new InterfaceTest().go();
    }

}


interface A{


    void abstractMethod();

    default void concreteMethod(){
        System.out.println("En la interfaz A - Método concreto");
    }

    static void staticMethod() {
        System.out.println("En la interfaz A - Método estático");
    }
}

interface B extends A{

    default void concreteMethod(){
        System.out.println("En la interfaz B - Método concreto");
    }

    static void staticMethod() {
        System.out.println("En la interfaz B - Método estático");
    }
}

interface C{
    default void concreteMethod(){
        System.out.println("En la interfaz C - Método concreto");
    }
}
