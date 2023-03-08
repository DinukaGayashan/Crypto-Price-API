package com.dinukagayashan.cryptopriceapi.domain.entities.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

import java.util.Date;

@Data
public class CryptocurrencyPriceDto {

    @NotEmpty
    private String currencyId;

    @NotEmpty
    private Date date;

    private Double openPrice;
    private Double highestPrice;
    private Double lowestPrice;
    private Double closePrice;
}
