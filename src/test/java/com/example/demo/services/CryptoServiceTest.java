package com.example.demo.services;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

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

}
