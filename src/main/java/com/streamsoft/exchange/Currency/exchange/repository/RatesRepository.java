package com.streamsoft.exchange.Currency.exchange.repository;

import com.streamsoft.exchange.Currency.exchange.domain.Rates;

import org.springframework.data.repository.CrudRepository;

import java.time.LocalDate;

public interface RatesRepository extends CrudRepository<Rates, LocalDate> {

    @Override
    Rates save(Rates rates);
}
