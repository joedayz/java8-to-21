import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class GetRequestAsyncTest {

          public static void main(String[] args) {
                    HttpRequest request = HttpBinRequestBuilder.createGetRequest();

                    HttpClient httpClient = HttpClientBuilderTest.createHttpClient();

                    //Es una llamada no bloqueante: el body es procesado a medida que llega
                    httpClient.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                              .thenApply(HttpResponse::body)
                              .thenAccept(body -> System.out.println("Async Response: " + body))
                              .exceptionally(e -> {
                                        System.out.println("Error: " + e.getMessage());
                                        return null;
                              })
                              .join();
          }
          
}
