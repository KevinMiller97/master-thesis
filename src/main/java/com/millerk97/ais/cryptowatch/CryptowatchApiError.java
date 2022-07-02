package com.millerk97.ais.cryptowatch;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class CryptowatchApiError {
    @JsonProperty("code")
    private int code;
    @JsonProperty("error")
    private String message;

}