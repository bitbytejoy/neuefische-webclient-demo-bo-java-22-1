package de.neuefische.neuefischewebclientdemo;

import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

@Component
public class RickAndMortyClient {
    WebClient webClient = WebClient.create("https://rickandmortyapi.com");

    public Character getChar2 () {
        Character character = webClient.get()
            .uri("/api/character/2")
            .header("Authorization", "Bearer lkjasdflkj")
            .retrieve()
            .toEntity(Character.class)
            .block()
            .getBody();

        return character;
    }
}
