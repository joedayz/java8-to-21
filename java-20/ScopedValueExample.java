public class ScopedValueExample {
          

          //Definicion de un scoped value
          private static final ScopedValue<String> USERNAME = ScopedValue.newInstance();

          public static void main(String[] args) {
                    //inicializacion del scoped value en un ambito controlado
                    ScopedValue.where(USERNAME, "Joe").run(()-> {

                              System.out.println("Username: " + USERNAME.get());
                              doSomething();
                    });
          }

          public static void doSomething(){
                    //acceso al scoped value en otro metodo
                    System.out.println("Username: " + USERNAME.get());
          }
}
