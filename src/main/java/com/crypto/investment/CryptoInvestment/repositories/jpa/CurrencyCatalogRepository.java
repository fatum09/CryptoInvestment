package com.crypto.investment.CryptoInvestment.repositories.jpa;

import com.crypto.investment.CryptoInvestment.data.entity.CurrencyCatalogEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CurrencyCatalogRepository extends JpaRepository<CurrencyCatalogEntity, Long> {

    @Query("select c from CurrencyCatalogEntity c where c.isDeleted = false and c.isActive = true")
    List<CurrencyCatalogEntity> findAll();

    CurrencyCatalogEntity findByCurrencySymbolIgnoreCase(String currencySymbol);


}