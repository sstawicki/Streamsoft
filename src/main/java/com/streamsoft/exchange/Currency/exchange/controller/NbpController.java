package com.streamsoft.exchange.Currency.exchange.controller;

import com.streamsoft.exchange.Currency.exchange.config.NbpClient;
import com.streamsoft.exchange.Currency.exchange.domain.NbpTable;
import com.streamsoft.exchange.Currency.exchange.domain.NbpTableDto;
import com.streamsoft.exchange.Currency.exchange.domain.Rates;
import com.streamsoft.exchange.Currency.exchange.mapper.NbpMapper;
import com.streamsoft.exchange.Currency.exchange.service.DbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

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
        return nbpMapper.mapToListNbpTableDto(nbpTables);
    }

    @RequestMapping(method = RequestMethod.POST, value = "save", consumes =  APPLICATION_JSON_VALUE)
    public ResponseEntity<?> saveCurrency(@RequestBody NbpTableDto nbpTableDto) {
        try {
            NbpTable nbpTable = dbService.saveNbpTable(nbpMapper.mapToNbpTable(nbpTableDto));
            nbpTable.getRates().stream()
                    .forEach(t -> dbService.saveRates(t));
            nbpTable.getRates().stream()
                    .forEach(t -> dbService.saveRatesWithDate(t,nbpTable));
            return new ResponseEntity<>(nbpTable, HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>("Your scores are in databases", HttpStatus.BAD_REQUEST);
        }

    }
}
