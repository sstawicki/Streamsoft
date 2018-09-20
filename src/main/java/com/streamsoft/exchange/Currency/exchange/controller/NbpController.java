package com.streamsoft.exchange.Currency.exchange.controller;

import com.streamsoft.exchange.Currency.exchange.config.NbpClient;
import com.streamsoft.exchange.Currency.exchange.domain.NbpTable;
import com.streamsoft.exchange.Currency.exchange.domain.NbpTableDto;
import com.streamsoft.exchange.Currency.exchange.mapper.NbpMapper;
import com.streamsoft.exchange.Currency.exchange.service.DbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/")
@CrossOrigin(origins = "*")
public class NbpController {
    @Autowired
    private NbpClient nbpClient;
    @Autowired
    private NbpMapper nbpMapper;
    @Autowired
    private DbService dbService;

    @RequestMapping(method = RequestMethod.GET, value = "get-currencies")
    public List<NbpTableDto> getRates() {
        List<NbpTable> nbpTables = nbpMapper.mapToListNbpTable(nbpClient.getNbpBoards());
        return nbpMapper.mapToListNbpTableDto(nbpTables);
    }

    @RequestMapping(method = RequestMethod.POST, value = "save", consumes =  APPLICATION_JSON_VALUE)
    public ResponseEntity<?> saveCurrency(@RequestBody NbpTableDto nbpTableDto) {
        try {
            return new ResponseEntity<>(nbpMapper.mapToNbpTableDto(dbService.saveNbpTable(nbpMapper.mapToNbpTable(nbpTableDto))), HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>("Your scores are in databases", HttpStatus.BAD_REQUEST);
        }

    }
}
