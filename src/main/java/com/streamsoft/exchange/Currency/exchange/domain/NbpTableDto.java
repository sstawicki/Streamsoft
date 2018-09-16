package com.streamsoft.exchange.Currency.exchange.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class NbpTableDto {
    @JsonProperty("table")
    private String table;
    @JsonProperty("no")
    private String no;
    @JsonProperty("tradingDate")
    private LocalDate tradingDate;
    @JsonProperty("effectiveDate")
    private LocalDate effectiveDate;
    @JsonProperty("rates")
    private List<RatesDto> rates;

}
