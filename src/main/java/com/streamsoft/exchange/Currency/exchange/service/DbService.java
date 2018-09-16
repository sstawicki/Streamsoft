package com.streamsoft.exchange.Currency.exchange.service;


import com.streamsoft.exchange.Currency.exchange.domain.NbpTable;
import com.streamsoft.exchange.Currency.exchange.domain.Rates;
import com.streamsoft.exchange.Currency.exchange.domain.RatesWithDate;
import com.streamsoft.exchange.Currency.exchange.repository.NbpTableRepository;
import com.streamsoft.exchange.Currency.exchange.repository.RatesRepository;
import com.streamsoft.exchange.Currency.exchange.repository.RatesWithDateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DbService {
    @Autowired
    private RatesRepository ratesRepository;
    @Autowired
    private NbpTableRepository nbpTableRepository;
    @Autowired
    private RatesWithDateRepository ratesWithDateRepository;

    public NbpTable saveNbpTable (final NbpTable nbpTable) throws Exception {
        Optional<NbpTable> nbpTableIsExist = nbpTableRepository.findByEffectiveDate(nbpTable.getEffectiveDate());
        if (nbpTableIsExist.isPresent()) {
             throw new Exception("Your scores are in databases");
        } else {
            NbpTable nbpTable1Save = nbpTableRepository.save(nbpTable);
            nbpTable.getRates().stream()
                    .forEach(t -> saveRates(t));
            nbpTable.getRates().stream()
                    .forEach(t -> saveRatesWithDate(t,nbpTable));
            return nbpTable1Save;
        }
    }

    public Rates saveRates(final Rates rates) {
        return ratesRepository.save(rates);
    }

    public RatesWithDate saveRatesWithDate(final Rates rates, final NbpTable nbpTable){
        return ratesWithDateRepository.save(new RatesWithDate(rates.getCurrency(), rates.getCode(), rates.getBid(), rates.getAsk(), nbpTable.getEffectiveDate()));
    }
}
