package com.example.demo.json;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Global {
    @JsonProperty("market_cap_usd")
    private String marketCapUsd;

    @JsonProperty("volume_24h_usd")
    private String volumeUsd;

    @JsonProperty("market_cap_ath_date")
    private String marketCapAthDate;

    @Override
    public String toString() {
        return String.format("%s %s %s", marketCapUsd, volumeUsd, marketCapAthDate);
    }
}
