package com.streamsoft.exchange.Currency.exchange.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;


@NoArgsConstructor
@Getter
@Entity(name = "rates")
@Table(name = "rates")
public class Rates {
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
    @ManyToOne
    @JoinColumn(name = "nbp_table_id")
    private NbpTable nbpTable;

    public Rates(String currency, String code, BigDecimal bid, BigDecimal ask) {

        this.currency = currency;
        this.code = code;
        this.bid = bid;
        this.ask = ask;
    }
}
