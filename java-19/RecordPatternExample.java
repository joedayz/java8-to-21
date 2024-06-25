


public class RecordPatternExample {
         
          public static void main(String[] args) {
                    Person person  = new Person("Bob", 14);

                    //usando pattern matching para extraer los valores del record
                    if(person instanceof Person(String name, int age)){
                              System.out.println("Name: " + name + " Age: " + age);
                    }

                    System.out.println(describePerson(person));
          }


          public static String describePerson(Object obj){
                    return switch (obj) {
                              case Person(String name, int age) when age>18 -> "Adult " + name;
                              case Person(String name, int age) -> "Young " + name;                              
                              default -> "Unknown";
                    };
          }
}

record Person(String name, int age) {}