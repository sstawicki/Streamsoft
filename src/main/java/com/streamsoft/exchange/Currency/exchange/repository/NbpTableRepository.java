package com.streamsoft.exchange.Currency.exchange.repository;

import com.streamsoft.exchange.Currency.exchange.domain.NbpTable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.Optional;

//@Transactional
//@Repository
public interface NbpTableRepository extends CrudRepository<NbpTable, Long> {

    Optional<NbpTable> findByEffectiveDate(LocalDate date);

    NbpTable save(NbpTable nbpTable);
}
