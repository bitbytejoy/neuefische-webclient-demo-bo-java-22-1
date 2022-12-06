package de.neuefische.neuefischewebclientdemo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

@SpringBootTest
class NeuefischeWebclientDemoApplicationTests {

    @Test
    void contextLoads() {
    }

    @Test
    void tryingCodeOut () {
        WebClient webClient = WebClient.create("https://rickandmortyapi.com");

        Character character = webClient.get()
            .uri("/api/character/2")
            .retrieve()
            .toEntity(Character.class)
            .block()
            .getBody();

        System.out.println(character);

        webClient.post()
            .uri("/api/orders/1")
            .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
            .bodyValue(List.of(2,2,2,1))
            .retrieve()
            .toEntity(Order.class)
            .block()
            .getBody();

        webClient.delete()
            .uri("/api/orders/1")
            .retrieve()
            .toBodilessEntity()
            .block();

        webClient.put()
            .uri("/api/orders/1")
            .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
            .bodyValue(List.of(2,2,2,1))
            .retrieve()
            .toEntity(Order.class)
            .block()
            .getBody();

        Assertions.assertTrue(true);
    }

}
