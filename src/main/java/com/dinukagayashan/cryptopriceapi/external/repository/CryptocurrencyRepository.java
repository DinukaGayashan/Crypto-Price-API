package com.dinukagayashan.cryptopriceapi.external.repository;

import com.dinukagayashan.cryptopriceapi.domain.entities.Cryptocurrency;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CryptocurrencyRepository extends JpaRepository<Cryptocurrency, String> {
}
