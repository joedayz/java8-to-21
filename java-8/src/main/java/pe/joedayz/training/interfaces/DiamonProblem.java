package pe.joedayz.training.interfaces;

public class DiamonProblem {

    public static void main(String[] args) {
        new TooMuch().walk();
    }
}

class TooMuch implements Father, Mother{

    @Override
    public void walk() {
        System.out.println("Too much is walking");
    }

}


interface Father{

    default void walk(){
        System.out.println("Father is walking");
    }
}

interface Mother{
    default void walk(){
        System.out.println("Mother is walking");
    }
}
