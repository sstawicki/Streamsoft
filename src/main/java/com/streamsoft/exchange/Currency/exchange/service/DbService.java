package com.streamsoft.exchange.Currency.exchange.service;


import com.streamsoft.exchange.Currency.exchange.domain.NbpTable;
import com.streamsoft.exchange.Currency.exchange.domain.Rates;
import com.streamsoft.exchange.Currency.exchange.repository.NbpTableRepository;
import com.streamsoft.exchange.Currency.exchange.repository.RatesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DbService {
    @Autowired
    private RatesRepository ratesRepository;
    @Autowired
    private NbpTableRepository nbpTableRepository;

    public NbpTable saveRates(final NbpTable nbpTable) {
        Optional<NbpTable> nbpTableIsExist = nbpTableRepository.findByEffectiveDate(nbpTable.getEffectiveDate());
        if (nbpTableIsExist.isPresent()) {
            return null;
        } else {
            for (Rates rates : nbpTable.getRates()) {
                saveRates(new Rates(rates.getCurrency(), rates.getCode(), rates.getBid(), rates.getAsk(), nbpTable));
            }
            return nbpTableRepository.save(nbpTable);
        }
    }

    public Rates saveRates(final Rates rates) {
        return ratesRepository.save(rates);
    }
}
