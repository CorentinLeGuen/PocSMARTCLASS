package server.publisher;

import server.services.MainService;

import javax.xml.ws.Endpoint;

public class MainPublisher {
    public static void main(String[] args) {
        final String url = "http://localhost:8899/services";
        System.out.println("Publishing MainPublisher at endpoint " + url);
        Endpoint.publish(url, new MainService());
    }
}
