package com.crypto.investment.CryptoInvestment.repositories.jpa;

import com.crypto.investment.CryptoInvestment.data.entity.CurrencyCatalogEntity;
import com.crypto.investment.CryptoInvestment.data.entity.CurrencyTradeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CurrencyTradeRepository extends JpaRepository<CurrencyTradeEntity, Long> {

    List<CurrencyTradeEntity> findAll();

//    @Query("select c from CurrencyTradeEntity c " +
//            "where c.isDeleted = false and c.isActive = true and c.timestampPrice between ?1 and ?2")
//    List<CurrencyCatalogEntity> findByIsDeletedFalseAndIsActiveTrueAndTimestampPriceBetween();

//    SELECT month('TIMESTAMP'), SUM( electricity ) AS electricity,  `siteID`
//    FROM table
//    WHERE (
//            MONTH(  `TimeStamp` ) =10)
//    GROUP BY siteID, month('TIMESTAMP')
//    @NativeW@Query("select month()")
//    @Query("SELECT month('timestamp_price'), min(price ) AS min, max(price ) AS max, \n" +
//            "FROM currency_trade\n" +
//            "WHERE (\n" +
//            "MONTH(  `timestamp_price` ) =10)\n" +
//            "GROUP BY siteID, month('TIMESTAMP')", nativeQuery = true)
//    List<CurrencyTradeEntity> getCryptoInfo();
}