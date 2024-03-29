package com.dinukagayashan.cryptopriceapi.domain.entities.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.Date;

@Data
public class CryptocurrencyPriceDto {

    @NotBlank(message = "id cannot be null or empty")
    private String currencyId;

    @NotNull(message = "date cannot be null or empty")
    private Date date;

    private Double openPrice;
    private Double highestPrice;
    private Double lowestPrice;
    private Double closePrice;
    private Double volume;

}
