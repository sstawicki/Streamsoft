package com.streamsoft.exchange.Currency.exchange.mapper;

import com.streamsoft.exchange.Currency.exchange.domain.NbpTable;
import com.streamsoft.exchange.Currency.exchange.domain.NbpTableDto;
import com.streamsoft.exchange.Currency.exchange.domain.Rates;
import com.streamsoft.exchange.Currency.exchange.domain.RatesDto;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class NbpMapper {
    public Rates mapToRates(final RatesDto ratesDto) {
            return new Rates(ratesDto.getCurrency(), ratesDto.getCode(), ratesDto.getBid(), ratesDto.getAsk());
    }
    public RatesDto mapToRatesDto(final Rates rates) {
        return new RatesDto(rates.getCurrency(), rates.getCode(), rates.getBid(), rates.getAsk());
    }
    public List<Rates> mapToListRates(final List<RatesDto> ratesDto) {
        return ratesDto.stream()
                .map(t -> new Rates(t.getCurrency(), t.getCode(), t.getBid(), t.getAsk()))
                .collect(Collectors.toList());
    }

    public List<RatesDto> mapToRatesDtoList(final List<Rates> rates) {
        return rates.stream()
                .map(t -> new RatesDto(t.getCurrency(), t.getCode(), t.getBid(), t.getAsk()))
                .collect(Collectors.toList());
    }

    public List<NbpTable> mapToNbpTable(final List<NbpTableDto> nbpTableDto) {
        return nbpTableDto.stream()
                .map(t -> new NbpTable(t.getTable(), t.getNo(), t.getTradingDate(), t.getEffectiveDate(), mapToListRates(t.getRates())))
                .collect(Collectors.toList());
    }

    public NbpTableDto mapToNbpTableDto(final NbpTable nbpTable) {
        return new NbpTableDto(nbpTable.getTable(), nbpTable.getNo(), nbpTable.getTradingDate(), nbpTable.getEffectiveDate(), mapToRatesDtoList(nbpTable.getRates()));
    }

    public NbpTable mapToNbpTable(final NbpTableDto nbpTableDto) {
        return new NbpTable(nbpTableDto.getTable(), nbpTableDto.getNo(), nbpTableDto.getTradingDate(), nbpTableDto.getEffectiveDate(), mapToListRates(nbpTableDto.getRates()));
    }

}
