package com.dinukagayashan.cryptopriceapi.domain.entities.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CryptocurrencyDto {

    @NotEmpty
    private String id;

    @NotEmpty
    private String name;

}
