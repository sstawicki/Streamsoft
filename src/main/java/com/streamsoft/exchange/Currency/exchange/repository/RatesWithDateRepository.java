package com.streamsoft.exchange.Currency.exchange.repository;

import com.streamsoft.exchange.Currency.exchange.domain.RatesWithDate;
import org.springframework.data.repository.CrudRepository;

public interface RatesWithDateRepository extends CrudRepository<RatesWithDate,Long> {

    RatesWithDate save(RatesWithDate ratesWithDate);

}
