package com.streamsoft.exchange.Currency.exchange.service;

import com.streamsoft.exchange.Currency.exchange.domain.NbpTable;
import com.streamsoft.exchange.Currency.exchange.domain.Rates;
import com.streamsoft.exchange.Currency.exchange.domain.RatesWithDate;
import com.streamsoft.exchange.Currency.exchange.repository.NbpTableRepository;
import com.streamsoft.exchange.Currency.exchange.repository.RatesRepository;
import com.streamsoft.exchange.Currency.exchange.repository.RatesWithDateRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;


import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.Silent.class)
public class DbServiceTest {
    @InjectMocks
    private DbService dbService;
    @Mock
    private NbpTableRepository nbpTableRepository;
    @Mock
    private RatesWithDateRepository ratesWithDateRepository;
    @Mock
    private RatesRepository ratesRepository;

    @Test
    public void testSaveNbpTable() throws Exception {
        //Given
        Rates rates = new Rates("Euro", "EUR", new BigDecimal(2.42), new BigDecimal(2.54));
        List<Rates> ratesList = new ArrayList<>();
        ratesList.add(rates);
        NbpTable nbpTable = new NbpTable("Test", "1",  LocalDate.parse("2018-09-06"), LocalDate.parse("2018-09-07"), ratesList);
        Optional<NbpTable> optionalNbpTable = Optional.empty();
        RatesWithDate ratesWithDate = new RatesWithDate("Euro", "EUR", new BigDecimal(2.42), new BigDecimal(2.54), LocalDate.parse("2018-09-07"));
        when(ratesRepository.save(rates)).thenReturn(rates);
        when(ratesWithDateRepository.save(ratesWithDate)).thenReturn(ratesWithDate);
        when(nbpTableRepository.save(nbpTable)).thenReturn(nbpTable);
        when(nbpTableRepository.findByEffectiveDate(nbpTable.getEffectiveDate())).thenReturn(optionalNbpTable);
        //When
        NbpTable result = dbService.saveNbpTable(nbpTable);
        Rates resultRates = dbService.saveRates(rates, nbpTable);
        //Then
        assertEquals("1", result.getNo());
        assertEquals("EUR", resultRates.getCode());
    }
}