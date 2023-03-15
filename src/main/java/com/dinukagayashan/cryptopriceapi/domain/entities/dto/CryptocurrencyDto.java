package com.dinukagayashan.cryptopriceapi.domain.entities.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CryptocurrencyDto {

    @NotBlank(message = "id must not be null or empty")
    private String id;

    @NotBlank(message = "name must not be null or empty")
    private String name;

}
