
import java.net.URI;
import java.net.http.HttpRequest;


public class HttpBinRequestBuilder {

          public static HttpRequest createGetRequest() {
                    return HttpRequest.newBuilder()
                              .uri(URI.create("https://httpbin.org/get"))
                              .GET()
                              .build();
          }
}