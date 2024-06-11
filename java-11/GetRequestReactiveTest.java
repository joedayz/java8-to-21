import java.net.http.HttpRequest;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.concurrent.Flow;
import java.util.concurrent.Flow.Subscriber;

public class GetRequestReactiveTest {

          public static void main(String[] args) {
                    HttpRequest request = HttpBinRequestBuilder.createGetRequest();

                    HttpClientBuilderTest.createHttpClient()
                    .sendAsync(request, BodyHandlers.fromLineSubscriber(new LinePrinter()))
                    .join();
          }
          
          public static class LinePrinter implements Subscriber<String> {
                    private Flow.Subscription subscription;
                    @Override
                    public void onSubscribe(Flow.Subscription subscription) {
                              this.subscription = subscription;
                              this.subscription.request(1);
                    }
                    @Override
                    public void onNext(String item) {
                              System.out.println("== [LinePrinter] Line received: " + item);
                              this.subscription.request(1);
                    }
                    @Override
                    public void onError(Throwable throwable) {
                              System.out.println("== [LinePrinter] Line received: " + throwable);
                    }
                    @Override
                    public void onComplete() {
                              System.out.println("== [LinePrinter] Completed");
                    }
          }
}
