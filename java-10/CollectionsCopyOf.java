import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.Map;

public class CollectionsCopyOf {

          public static void main(String[] args) {
                    List<String> muttableList = Arrays.asList("New", "Method", "To", "Copy");

                    // muttableList.set(0, "pepe");
                    // System.out.println(muttableList);

                    // muttableList.add("joedayz");
                    // System.out.println(muttableList);

                    List<String> immutableList = List.copyOf(muttableList);
                    //immutableList.set(0, "pepe");
                    immutableList.forEach(System.out::println);

                    Set<String> immutableSet = Set.copyOf(muttableList);
                    immutableSet.forEach(System.out::println);

                    Map<String, Integer> immutableMap = Map.copyOf(Map.of("One", 1, "Two", 2, "Three", 3));
                    immutableMap.forEach((k, v) -> System.out.println(k + " : " + v));
                    
          }

}