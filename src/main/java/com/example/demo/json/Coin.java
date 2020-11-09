package com.example.demo.json;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Coin {
    @JsonProperty("id")
    private String id;
    @JsonProperty("name")
    private String name;

    @Override
    public String toString() {
        return String.format("$s $s", id, name);
    }
}
