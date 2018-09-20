package com.streamsoft.exchange.Currency.exchange.domain;

import com.fasterxml.jackson.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class RatesDto {
    @JsonProperty("id")
    private String id;
    @JsonProperty("currency")
    private String currency;
    @JsonProperty("code")
    private String code;
    @JsonProperty("bid")
    private BigDecimal bid;
    @JsonProperty("ask")
    private BigDecimal ask;

    public RatesDto(String currency, String code, BigDecimal bid, BigDecimal ask) {
        this.currency = currency;
        this.code = code;
        this.bid = bid;
        this.ask = ask;
    }
}
