package de.neuefische.neuefischewebclientdemo;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/rick-and-morty/characters")
@RequiredArgsConstructor
public class RickAndMortyController {
    private final RickAndMortyClient rickAndMortyClient;

    @GetMapping
    public Character getCharacter2 () {
        return rickAndMortyClient.getChar2();
    }
}
