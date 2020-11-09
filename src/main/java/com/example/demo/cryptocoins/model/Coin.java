package com.example.demo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Coin {

    @JsonProperty
    private String id;
    @JsonProperty
    private String name;
}
