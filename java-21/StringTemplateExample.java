
import java.time.*;
import java.time.format.DateTimeFormatter;



public class StringTemplateExample {
          static Type type = Type.HACKER;
	static String firstName = "Thomas";
	static String lastName = "Anderson";
	static String hackerName = "Neo";
          
          public static void main(String[] args) {
                   rawTemplateProcessor(); 
                   rawTemplateProcessor2(); 
                   simpleTemplate();
                   allowedExpressionsInsideEmbeddedTemplate();
          }

          public static void rawTemplateProcessor() {
                   String template = "Hello, ${name}! You are learning ${language}!";
                   String result = template.replace("${name}", "John").replace("${language}", "Java");
                   System.out.println(result);
          }

          public static void rawTemplateProcessor2() {
                   StringTemplate st = StringTemplate.RAW."String template build from RAW template processor: \{firstName}";
                   String message = StringTemplate.STR.process(st);

                   message = STR."String template build from RAW template processor: \{firstName}";
                   System.out.println(message);
          }

          public static void simpleTemplate() {
                    String str = STR."Simple string template without embedded expression";
                   
                    System.out.println(STR."Wake up \{hackerName}...");

                    System.out.println(STR."""
                                        Mr. \{lastName}! Welcome back, we missed you!
                                        """);

                    System.out.println(STR."The time is \{
                              DateTimeFormatter.ofPattern("HH:mm:ss").format(LocalTime.now())} right now");
                     

                    System.out.println(STR."Follow the white \{"rabbit"}...");
          }


          public static void allowedExpressionsInsideEmbeddedTemplate() {
                   
                    boolean isCaptured = true;

                    var counter = 0;

                    System.out.println(STR."Counting...\{++counter}...\{++counter}...\{++counter}...");
                    System.out.println(STR."How long has been arrested? \{4 + 2} hours");
                    System.out.println(STR."How long is his name? \{firstName.length() + lastName.length()}");


                    System.out.println(STR."What is the name of the Academy? \{grettings()}");

                    System.out.println(STR."Is he captured? \{isCaptured ? lastName : hackerName}");

		System.out.println(STR."What is he? \{
			switch (type) {
				case HACKER -> "hackerman";
				case PERSON -> "bot";
			}
		}");

          }


          static String grettings(){
                    return  "JoeDayz Perú";
          }

}



enum Type {
	HACKER,
	PERSON
}