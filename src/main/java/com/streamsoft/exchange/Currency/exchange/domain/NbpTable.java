package com.streamsoft.exchange.Currency.exchange.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "nbp_table")
public class NbpTable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "table_cur")
    private String table;
    @Column(name = "no_cur")
    private String no;
    @Column(name = "tradingDate")
    private LocalDate tradingDate;
    @Column(name = "effectiveDate")
    private LocalDate effectiveDate;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "nbpTable", targetEntity = Rates.class)
    private List<Rates> rates;

    public NbpTable(String table, String no, LocalDate tradingDate, LocalDate effectiveDate, List<Rates> rates) {
        this.table = table;
        this.no = no;
        this.tradingDate = tradingDate;
        this.effectiveDate = effectiveDate;
        this.rates = rates;
    }
}
