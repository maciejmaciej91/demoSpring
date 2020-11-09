package com.example.demo.services;

import com.example.demo.Coin;
import com.example.demo.Global;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

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
                .map(Global::toString)
                .block(Duration.ofSeconds(2));
    }

    public List<Coin> getAllCoins() {
        String path = "/coins";
        return client.get()
                .uri(uriBuilder -> uriBuilder.path(path)
                        .build())
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<List<Coin>>() {
                })
                .block(Duration.ofSeconds(2));
    }
}
