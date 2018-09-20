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

    public List<NbpTable> mapToListNbpTable(final List<NbpTableDto> nbpTableDto) {
        return nbpTableDto.stream()
                .map(t -> new NbpTable(t.getTable(), t.getNo(), t.getTradingDate(), t.getEffectiveDate(), mapToListRates(t.getRates())))
                .collect(Collectors.toList());
    }

    public List<NbpTableDto> mapToListNbpTableDto(final List<NbpTable> nbpTables){
        return nbpTables.stream()
                .map(t -> new NbpTableDto(t.getTable(), t.getNo(), t.getTradingDate(), t.getEffectiveDate(), mapToRatesDtoList(t.getRates())))
                .collect(Collectors.toList());
    }


    public NbpTable mapToNbpTable(final NbpTableDto nbpTableDto) {
        return new NbpTable(nbpTableDto.getTable(), nbpTableDto.getNo(), nbpTableDto.getTradingDate(), nbpTableDto.getEffectiveDate(), mapToListRates(nbpTableDto.getRates()));
    }

    public NbpTableDto mapToNbpTableDto(final NbpTable nbpTable) {
        return new NbpTableDto(nbpTable.getTable(), nbpTable.getNo(), nbpTable.getTradingDate(), nbpTable.getEffectiveDate(), mapToRatesDtoList(nbpTable.getRates()));
    }
}
