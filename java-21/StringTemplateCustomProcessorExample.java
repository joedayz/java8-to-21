public class StringTemplateCustomProcessorExample {


          public static void main(String[] args) {
		usingClass();
		usingLambda();
		usingStaticFactoryMethod();
	}

          public static void usingClass() {
                    class StringNullSanitizer implements StringTemplate.Processor<String, RuntimeException> {
                              @Override
                              public String process(StringTemplate st) {
                                        return interpolate(st);
                              }
                    }   
                    System.out.println(new StringNullSanitizer()."Test null: \{null}");      
          }

          public static void usingLambda() {
                    //StringTemplate.Processor<String, RuntimeException> STR_NULL_SATINIZER = st -> interpolate(st);
                    StringTemplate.Processor<String, RuntimeException> STR_NULL_SATINIZER = StringTemplateCustomProcessorExample::interpolate;
                    System.out.println(STR_NULL_SATINIZER."Test null: \{null}");
          }

          public static void usingStaticFactoryMethod() {
                    var STR_NULL_SATINIZER = StringTemplate.Processor.of(StringTemplateCustomProcessorExample::interpolate);
                    System.out.println(STR_NULL_SATINIZER."Test null: \{null}");
          }

          static String interpolate(StringTemplate st){
                    var sb = new StringBuilder();
                    var fragments = st.fragments().iterator();
                    for(Object value: st.values()){
                              sb.append(fragments.next());
                              if(value==null){
                                        sb.append("<NULL>");
                              } else{
                                        sb.append(value);
                              }  
                    }
                    sb.append(fragments.next());
                    return sb.toString();
          }
}
