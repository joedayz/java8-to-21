public class SwitchExpressionExample {
          public static void main(String[] args) {
                    compatibleWithOldVersion();

                    longVersion();

                    shortVersion();

                    inferringType();
          }

          public static void compatibleWithOldVersion() {
                    int luckNumber = 7;
                    var wasLucky = switch (luckNumber) {
                              // here the fall-through happens (if there is no break or return the next case
                              // will be executed)
                              case 7:
                                        yield false; // antes en java 12 era asi --> break false; // break was changed
                                                     // to yield in Java 13
                              case 13:
                                        yield true;
                              // here we must provide a default case (compiler checks exhaustiveness)
                              default:
                                        throw new IllegalArgumentException("Wrong number");
                    };
                    System.out.println("Was lucky: " + wasLucky);
          }

          public static void shortVersion() {
                    var mood = Incomes.Good;

                    // arrow syntax with no fall-through (only the arrow block will be executed)
                    switch (mood) {
                              case Good -> {
				var easy = true;
				System.out.println("\nKeep working");
			}
			case Regular, Bad -> {
				// we can now declare vars with same name (each arrow has its own scope)
				var easy = true;
				System.out.println("\nGo home");
				/*
				 * we can only return inside a block and when switch
				 * is used as statement
				 */
				return;
			}
                    }

          }

          public static void longVersion() {
                    var mood = Incomes.Bad;

                    // arrow syntax with no fall-through (only the arrow block will be executed)
                    var shouldIGo = switch (mood) {
                              // accepts multiple case labels
                              case Good, Regular -> {
                                        yield true;
                              }
                              case Bad -> {
                                        yield false;
                              }
                              // there is no need to use default (we covered all possible cases)
                    };

                    System.out.println("\nShould I go? " + shouldIGo);
          }

          public static void inferringType() {
		var mood = Incomes.Good;
                    var shouldIGo = switch (mood) {
                              case Good -> 
                                        "All right";
                              
                              default-> 
                                        new IllegalArgumentException("Not right");
                              
                    };
                    System.out.println("\nShould I go? " + shouldIGo);
          }
}

enum Incomes {
          Good, Regular, Bad
}