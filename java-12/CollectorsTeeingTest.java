import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CollectorsTeeingTest {
          public static void main(String[] args) {
                    Range range = Stream.of(1, 8, 2, 5)
                              .collect(Collectors.teeing(
                                        Collectors.minBy(Integer::compareTo),
                                        Collectors.maxBy(Integer::compareTo),
                                        Range::ofOptional)
                              );

                    System.out.println("Range: " + range.getRange());
          }
}

class Range {

          private String range;

          public Range(String range){
                   this.range = range;           
          }

          public static Range ofOptional(Optional<Integer> min, Optional<Integer> max) {
                    if(min.isEmpty() || max.isEmpty()){
                              return new Range("EMPTY");
                    }
                    return new Range(String.format("from %d to %d", min.get(), max.get()));
                    
          }

          public String getRange() {
                    return range;
          }

}