package com.example.demo.services;

import com.example.demo.cryptocoins.model.Coin;
import com.example.demo.cryptocoins.service.CryptoService;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import reactor.core.publisher.Mono;

import java.util.List;

@SpringBootTest
public class CryptoServiceTest {
    private Logger logger = LoggerFactory.getLogger(CryptoService.class);

    @Autowired
    private CryptoService service;

    @Test
    public void getGlobalTest() {
        String global = service.getGlobal();
        logger.info(global);
    }

    @Test
    public void getAllCoinsTest() {
        List<Coin> coins = service.getAllCoins();
        for (Coin coin : coins) {
            logger.info(coin.toString());
        }
    }
}
