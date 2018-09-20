package com.streamsoft.exchange.Currency.exchange.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@NoArgsConstructor
@Getter
@Entity(name = "rates_with_date")
public class RatesWithDate {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
    @Column(name = "currency")
    private String currency;
    @Column(name = "code")
    private String code;
    @Column(name = "bid")
    private BigDecimal bid;
    @Column(name = "ask")
    private BigDecimal ask;
    @Column(name = "effectiveDate")
    private LocalDate effectiveDate;

    public RatesWithDate(String currency, String code, BigDecimal bid, BigDecimal ask, LocalDate effectiveDate) {
        this.currency = currency;
        this.code = code;
        this.bid = bid;
        this.ask = ask;
        this.effectiveDate = effectiveDate;
    }
}
