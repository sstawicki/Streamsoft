package com.streamsoft.exchange.Currency.exchange.repository;

import com.streamsoft.exchange.Currency.exchange.domain.Rates;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.time.LocalDate;

//@Transactional
//@Repository
public interface RatesRepository extends CrudRepository<Rates, LocalDate> {

    @Override
    Rates save(Rates rates);
}
