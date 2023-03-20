package com.dinukagayashan.cryptopriceapi.external.repository;

import com.dinukagayashan.cryptopriceapi.domain.entities.CryptocurrencyPrice;
import com.dinukagayashan.cryptopriceapi.domain.entities.CryptocurrencyPriceId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CryptocurrencyPriceRepository extends JpaRepository<CryptocurrencyPrice, CryptocurrencyPriceId> {
}
