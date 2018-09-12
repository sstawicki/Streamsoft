package com.streamsoft.exchange.Currency.exchange.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity(name = "rates")
public class Rates {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "currency")
    private String currency;
    @Column(name = "code")
    private String code;
    @Column(name = "bid")
    private BigDecimal bid;
    @Column(name = "ask")
    private BigDecimal ask;
    @ManyToOne
    @JoinColumn(name = "table_Id")
    private NbpTable nbpTable;

    public Rates(String currency, String code, BigDecimal bid, BigDecimal ask) {
        this.currency = currency;
        this.code = code;
        this.bid = bid;
        this.ask = ask;
    }

    public Rates(String currency, String code, BigDecimal bid, BigDecimal ask, NbpTable nbpTable) {
        this.currency = currency;
        this.code = code;
        this.bid = bid;
        this.ask = ask;
    }
}
