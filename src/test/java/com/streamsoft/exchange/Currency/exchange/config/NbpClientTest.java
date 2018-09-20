package com.streamsoft.exchange.Currency.exchange.config;

import com.streamsoft.exchange.Currency.exchange.domain.NbpTableDto;
import com.streamsoft.exchange.Currency.exchange.domain.RatesDto;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class NbpClientTest {

    @InjectMocks
    private NbpClient nbpClient;
    @Mock
    private RestTemplate restTemplate;
    @Mock
    private CoreConfiguration coreConfiguration;

    @Before
    public void init() {
        when(coreConfiguration.getNbpApiEndpoint()).thenReturn("http://test.com");
    }


    @Test
    public void testGetNbpBoards() throws URISyntaxException{
        //Given
        NbpTableDto nbpTableDto = new NbpTableDto("Test", "1",  LocalDate.parse("2018-09-06"), LocalDate.parse("2018-09-07"), new ArrayList<RatesDto>());
        NbpTableDto[] nbpTableDtos = new NbpTableDto[1];
        nbpTableDtos[0]= (nbpTableDto);
        URI uri = new URI("http://test.com");
        when(restTemplate.getForObject(uri, NbpTableDto[].class)).thenReturn(nbpTableDtos);
        //When
        List<NbpTableDto> nbpTableDto1 = nbpClient.getNbpBoards();
        //Then
        assertEquals("Test", nbpTableDto1.get(0).getTable());
        assertEquals("1", nbpTableDto1.get(0).getNo());
        assertEquals(LocalDate.parse("2018-09-07"), nbpTableDto1.get(0).getEffectiveDate());
        assertEquals(LocalDate.parse("2018-09-06"), nbpTableDto1.get(0).getTradingDate());
        assertEquals(0, nbpTableDto1.get(0).getRates().size());
    }
}