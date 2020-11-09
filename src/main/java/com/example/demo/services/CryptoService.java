package com.example.demo.services;

import com.example.demo.json.Coin;
import com.example.demo.json.Global;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.util.List;

@Service
public class CryptoService {
    private WebClient client;

    CryptoService(WebClient.Builder builder) {
        client = builder.baseUrl("https://api.coinpaprika.com/v1").build();
    }

    public String getGlobal() {
        String path = "/global";
        return client.get()
                .uri(uriBuilder -> uriBuilder.path(path)
                        .build())
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(Global.class)
                .map(response -> response.toString())
                .block(Duration.ofSeconds(2));
    }

    public Mono<List<Coin>> getAllCoins() { //tu chcialbym zwracac jakas tablice albo arrayliste?
        String path = "/coins";
        return client.get()
                .uri(uriBuilder -> uriBuilder.path(path)
                        .build())
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToFlux(Coin.class)
                .collectList(); //tutaj zle i na tym zakonczylem :D
//                .map(response -> response.toString())
//                .flatMap(Flux::fromIterable);
//                .map(response -> response.toString())
//                .block(Duration.ofSeconds(2));
    }
}
