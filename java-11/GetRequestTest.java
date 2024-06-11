import java.io.IOException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class GetRequestTest {

          public static void main(String[] args) throws IOException, InterruptedException {
                    HttpRequest request = HttpBinRequestBuilder.createGetRequest();

                    HttpClient httpClient = HttpClientBuilderTest.createHttpClient();
                    //Es una llamada bloqueante: el body es mantenido en memmoria para ser procesado                    
                    HttpResponse<String> httpResponse = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
                    System.out.println("Response: " + httpResponse.body());
          }
}
