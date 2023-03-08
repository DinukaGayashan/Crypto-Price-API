package com.dinukagayashan.cryptopriceapi.domain.entities.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class CryptocurrencyDto {

    @NotEmpty
    private String id;

    @NotEmpty
    private String name;
}
