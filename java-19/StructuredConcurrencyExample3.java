


public class StructuredConcurrencyExample3 {
        public static void main(String[] args)  throws InterruptedException {
                    
                    Thread.startVirtualThread(() -> {
                              try{
                                        Thread.sleep(1000);
                                        System.out.println("Result of Task1");
                              } catch(InterruptedException e){
                                        e.printStackTrace();
                              }
  
                    });

                    Thread.startVirtualThread(() -> {
                              try{
                                        Thread.sleep(2000);
                                        System.out.println("Result of Task2");
                              } catch(InterruptedException e){
                                        e.printStackTrace();
                              }
                    });

                    Thread.startVirtualThread(() -> {
                              try{
                                        Thread.sleep(3000);
                                        System.out.println("Result of Task3");
                              } catch(InterruptedException e){
                                        e.printStackTrace();
                              }
                    });

                    Thread.sleep(4000);
        }  
}
