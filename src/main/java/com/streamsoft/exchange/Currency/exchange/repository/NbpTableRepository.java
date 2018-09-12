package com.streamsoft.exchange.Currency.exchange.repository;

import com.streamsoft.exchange.Currency.exchange.domain.NbpTable;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDate;
import java.util.Optional;

public interface NbpTableRepository extends CrudRepository<NbpTable, Long> {

    Optional<NbpTable> findByEffectiveDate(LocalDate date);

    NbpTable save(NbpTable nbpTable);
}
