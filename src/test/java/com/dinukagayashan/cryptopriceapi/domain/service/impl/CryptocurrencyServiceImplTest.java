package com.dinukagayashan.cryptopriceapi.domain.service.impl;

import com.dinukagayashan.cryptopriceapi.domain.entities.Cryptocurrency;
import com.dinukagayashan.cryptopriceapi.domain.entities.dto.CryptocurrencyDto;
import com.dinukagayashan.cryptopriceapi.domain.entities.dto.ExceptionDto;
import com.dinukagayashan.cryptopriceapi.external.repository.CryptocurrencyRepository;
import jakarta.persistence.EntityNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.Objects;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@RunWith(MockitoJUnitRunner.class)
class CryptocurrencyServiceImplTest {

    @Mock
    CryptocurrencyRepository cryptocurrencyRepository;

    @InjectMocks
    CryptocurrencyServiceImpl cryptocurrencyService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    private final String cryptocurrencyId = "BTC";

    @Test
    void addCryptocurrency_success() throws Exception {
        Mockito.when(cryptocurrencyRepository.save(getCryptocurrency(cryptocurrencyId))).thenReturn(getCryptocurrency(cryptocurrencyId));
        assertEquals(getCryptocurrencyDto(cryptocurrencyId), cryptocurrencyService.addCryptocurrency(getCryptocurrencyDto(cryptocurrencyId)));
    }

    @Test
    void addCryptocurrency_failure() {
        Mockito.when(cryptocurrencyRepository.save(getCryptocurrency(cryptocurrencyId))).thenThrow(RuntimeException.class);
        assertThrows(ExceptionDto.class, () -> this.cryptocurrencyService.addCryptocurrency(getCryptocurrencyDto(cryptocurrencyId)));
    }

    @Test
    void getCryptocurrency_success() throws Exception {
        Mockito.when(cryptocurrencyRepository.findById(cryptocurrencyId)).thenReturn(Optional.of(getCryptocurrency(cryptocurrencyId)));
        assertEquals(getCryptocurrencyDto(cryptocurrencyId), cryptocurrencyService.getCryptocurrency(cryptocurrencyId));
    }

    @Test
    void getCryptocurrency_failure() {
        Mockito.when(cryptocurrencyRepository.findById(cryptocurrencyId)).thenThrow(EntityNotFoundException.class);
        assertThrows(Exception.class,()->this.cryptocurrencyService.getCryptocurrency(cryptocurrencyId));
        //TODO: check Exception Class
    }

    @Test
    void getAllCryptocurrencies_success() throws Exception {
        Mockito.when(cryptocurrencyRepository.findAll()).thenReturn(Arrays.asList(getCryptocurrency(cryptocurrencyId), getCryptocurrency(cryptocurrencyId)));
        assertEquals(Arrays.asList(createCryptocurrencyDto(getCryptocurrency(cryptocurrencyId)), createCryptocurrencyDto(getCryptocurrency(cryptocurrencyId))), cryptocurrencyService.getAllCryptocurrencies());
    }

    @Test
    void getAllCryptocurrencies_failure() throws Exception {
        Mockito.when(cryptocurrencyRepository.findAll()).thenThrow(RuntimeException.class);
        assertThrows(ExceptionDto.class,()->this.cryptocurrencyService.getCryptocurrency(cryptocurrencyId));
    }

    @Test
    void updateCryptocurrency_success() throws Exception {
        Mockito.when(cryptocurrencyRepository.findById(cryptocurrencyId)).thenReturn(Optional.of(getCryptocurrency(cryptocurrencyId)));
        Mockito.when(cryptocurrencyRepository.save(getCryptocurrency(cryptocurrencyId))).thenReturn(getCryptocurrency(cryptocurrencyId));
        assertEquals(getCryptocurrencyDto(cryptocurrencyId), cryptocurrencyService.updateCryptocurrency(cryptocurrencyId, getCryptocurrencyDto(cryptocurrencyId)));
    }

    @Test
    void deleteCryptocurrency_success() throws Exception {
        Mockito.when(cryptocurrencyRepository.findById(cryptocurrencyId)).thenReturn(Optional.of(getCryptocurrency(cryptocurrencyId)));
        assertEquals(cryptocurrencyId, cryptocurrencyService.deleteCryptocurrency(cryptocurrencyId));
    }

    private Cryptocurrency getCryptocurrency(String id) {
        Cryptocurrency cryptocurrency = new Cryptocurrency();
        if (Objects.equals(id, "BTC")) {
            cryptocurrency.setId("BTC");
            cryptocurrency.setId("Bitcoin");
        }
        return cryptocurrency;
    }

    private CryptocurrencyDto getCryptocurrencyDto(String id) {
        CryptocurrencyDto cryptocurrencyDto = new CryptocurrencyDto();
        if (Objects.equals(id, "BTC")) {
            cryptocurrencyDto.setId("BTC");
            cryptocurrencyDto.setId("Bitcoin");
        }
        return cryptocurrencyDto;
    }

    private CryptocurrencyDto createCryptocurrencyDto(Cryptocurrency cryptocurrency) throws Exception {
        CryptocurrencyDto cryptocurrencyDto = new CryptocurrencyDto();
        cryptocurrencyDto.setId(cryptocurrency.getId());
        cryptocurrencyDto.setName(cryptocurrency.getName());
        return cryptocurrencyDto;
    }

}