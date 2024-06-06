package pe.joedayz.training.collections.httpclient;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class HttpClientTest {

    public static void main(String[] args) throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("http://httpbin.org/uuid"))
                .GET()
                .build();

        String syncResponse = HttpClient.newHttpClient()
                .send(request, HttpResponse.BodyHandlers.ofString()).body();

        System.out.println("Respuesta sincrónica: " + syncResponse);

        HttpClient.newHttpClient()
                .sendAsync(request, HttpResponse.BodyHandlers.ofString())
                .thenApply(HttpResponse::body)
                .thenAccept(r -> System.out.println("Respuesta asíncrona: " + r));

        Thread.sleep(5000);
    }
}
