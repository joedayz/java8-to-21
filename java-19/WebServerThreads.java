package pe.joedayz;

import com.sun.net.httpserver.Headers;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpHandlers;
import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.concurrent.Executors;

public class WebServerThreads {

    public static void main(String[] args) throws IOException {
        var server = HttpServer.create(new InetSocketAddress(8000), 0);
        server.createContext("/", HttpHandlers.of(200, new Headers(), "Handled!"));

        server.setExecutor(Executors.newThreadPerTaskExecutor(Thread.ofVirtual().factory()));

        server.start();

        System.out.println("Server started at" + server.getAddress());
    }
}
