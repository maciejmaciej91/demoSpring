package com.example.demo.services;

import com.example.demo.Global;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.time.Duration;

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
}
