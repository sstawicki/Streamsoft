package com.streamsoft.exchange.Currency.exchange.controller;

import com.streamsoft.exchange.Currency.exchange.config.NbpClient;
import com.streamsoft.exchange.Currency.exchange.domain.NbpTable;
import com.streamsoft.exchange.Currency.exchange.domain.NbpTableDto;
import com.streamsoft.exchange.Currency.exchange.domain.Rates;
import com.streamsoft.exchange.Currency.exchange.mapper.NbpMapper;
import com.streamsoft.exchange.Currency.exchange.service.DbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/")
public class NbpController {
    @Autowired
    private NbpClient nbpClient;
    @Autowired
    private NbpMapper nbpMapper;
    @Autowired
    private DbService dbService;

    @RequestMapping(method = RequestMethod.GET, value = "get-currencies")
    public List<NbpTableDto> getRates() {
        List<NbpTable> nbpTables = nbpMapper.mapToNbpTable(nbpClient.getNbpBoards());
        List<Rates> rates = nbpTables.get(0).getRates();
        dbService.saveRates(nbpTables.get(0));
        return nbpClient.getNbpBoards();
    }
}
