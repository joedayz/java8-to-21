package pe.joedayz.training.lambdas;

public class ShadowingTest {

    int x = 23;

    public void doStuff(int x){

        int z = 5;

        Thread t = new Thread( () -> {
            System.out.println("ShadowingTest.this.x = " + ShadowingTest.this.x);
            System.out.println("this.x = "+ this.x);
            System.out.println("x = " + x);
            int y = 530;
            System.out.println("y = " + y);
            System.out.println("z = " + z);
        });

        t.start();
        int y = 3;
        System.out.println("y = " + y);

    }

    public static void main(String[] args) {
        ShadowingTest st = new ShadowingTest();
        st.doStuff(30);
    }
}
