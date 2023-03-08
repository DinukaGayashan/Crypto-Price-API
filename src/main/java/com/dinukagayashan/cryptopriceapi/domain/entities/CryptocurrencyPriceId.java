package com.dinukagayashan.cryptopriceapi.domain.entities;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class CryptocurrencyPriceId implements Serializable {
    private String currencyId;
    private Date date;
}
