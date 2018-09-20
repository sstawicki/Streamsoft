package com.streamsoft.exchange.Currency.exchange.mapper;

import com.streamsoft.exchange.Currency.exchange.domain.NbpTable;
import com.streamsoft.exchange.Currency.exchange.domain.NbpTableDto;
import com.streamsoft.exchange.Currency.exchange.domain.Rates;
import com.streamsoft.exchange.Currency.exchange.domain.RatesDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
@RunWith(MockitoJUnitRunner.class)
public class NbpMapperTest {

    @InjectMocks
    private NbpMapper nbpMapper;

    @Test
    public void mapToListRates() {
        //Given
        List<RatesDto> ratesDtos = new ArrayList<>();
        ratesDtos.add(new RatesDto("Euro", "EUR", new BigDecimal(2.42), new BigDecimal(2.54)));
        //When
        List<Rates> rates = nbpMapper.mapToListRates(ratesDtos);
        //Then
        assertEquals("Euro", rates.get(0).getCurrency());
        assertEquals("EUR", rates.get(0).getCode());
        assertEquals(1, rates.size());
    }

    @Test
    public void mapToRatesDtoList() {
        //Given
        List<Rates> rates = new ArrayList<>();
        rates.add(new Rates("Euro", "EUR", new BigDecimal(2.42), new BigDecimal(2.54)));
        //When
        List<RatesDto> ratesDtos = nbpMapper.mapToRatesDtoList(rates);
        //Then
        assertEquals("Euro", ratesDtos.get(0).getCurrency());
        assertEquals("EUR", ratesDtos.get(0).getCode());
        assertEquals(1, ratesDtos.size());
    }

    @Test
    public void mapToListNbpTable() {
        //Given
        List<NbpTableDto> nbpTableDto = new ArrayList<>();
        nbpTableDto.add(new NbpTableDto("Test", "1",  LocalDate.parse("2018-09-06"), LocalDate.parse("2018-09-07"), new ArrayList<RatesDto>()));
        //When
        List<NbpTable> nbpTables = nbpMapper.mapToListNbpTable(nbpTableDto);
        //Given
        assertEquals("Test", nbpTables.get(0).getTable());
        assertEquals(LocalDate.parse("2018-09-07"), nbpTables.get(0).getEffectiveDate());
        assertEquals(1, nbpTables.size());
    }

    @Test
    public void mapToListNbpTableDto() {
        //Given
        List<NbpTable> nbpTable = new ArrayList<>();
        nbpTable.add(new NbpTable("Test", "1",  LocalDate.parse("2018-09-06"), LocalDate.parse("2018-09-07"), new ArrayList<Rates>()));
        //When
        List<NbpTableDto> nbpTablesDto = nbpMapper.mapToListNbpTableDto(nbpTable);
        //Given
        assertEquals("Test", nbpTablesDto.get(0).getTable());
        assertEquals(LocalDate.parse("2018-09-07"), nbpTablesDto.get(0).getEffectiveDate());
        assertEquals(1, nbpTablesDto.size());
    }

    @Test
    public void mapToNbpTable() {
        //Given
        NbpTableDto nbpTableDto = new NbpTableDto("Test", "1",  LocalDate.parse("2018-09-06"), LocalDate.parse("2018-09-07"), new ArrayList<RatesDto>());
        //When
        NbpTable nbpTables = nbpMapper.mapToNbpTable(nbpTableDto);
        //Given
        assertEquals("Test", nbpTables.getTable());
        assertEquals(LocalDate.parse("2018-09-07"), nbpTables.getEffectiveDate());
    }
}