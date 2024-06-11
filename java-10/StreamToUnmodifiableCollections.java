import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StreamToUnmodifiableCollections {
          public static void main(String[] args) {
                    List<String> list = List.of("Testing", "Immutable", "List", "From", "Stream"); 

                    List<String> inmutablelist = list.stream()
                                                  .collect(Collectors.toUnmodifiableList());
                    inmutablelist.forEach(System.out::println);

                    Map<String, Integer> wordsLengths = list.stream()
                              .collect(Collectors.toUnmodifiableMap(Function.identity(), String::length));
                              wordsLengths.forEach((k, v) -> System.out.println(k + " -> " + v));
                              
          }
}
