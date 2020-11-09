package com.example.demo.cryptocoins.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Coin {

    @JsonProperty
    private String id;
    @JsonProperty
    private String name;

    public String toString() {
        return String.format("%s %s", id, name);
    }
}
