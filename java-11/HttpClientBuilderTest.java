
import java.net.http.HttpClient;
import java.time.Duration;

public class HttpClientBuilderTest {
          public static HttpClient createHttpClient() {
                    return HttpClient.newBuilder()
                              .version(HttpClient.Version.HTTP_2)
                              .followRedirects(HttpClient.Redirect.NORMAL)
                              .connectTimeout(Duration.ofSeconds(20))
                              .build();
          }
          
}
