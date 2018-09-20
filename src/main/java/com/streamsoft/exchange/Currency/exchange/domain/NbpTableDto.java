package com.streamsoft.exchange.Currency.exchange.domain;

import com.fasterxml.jackson.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class NbpTableDto {
    @JsonProperty("id")
    private String id;
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

    public NbpTableDto(String table, String no, LocalDate tradingDate, LocalDate effectiveDate, List<RatesDto> rates) {
        this.table = table;
        this.no = no;
        this.tradingDate = tradingDate;
        this.effectiveDate = effectiveDate;
        this.rates = rates;
    }
}
