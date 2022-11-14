package com.crypto.investment.CryptoInvestment.services;

import com.crypto.investment.CryptoInvestment.data.dto.CurrencyCatalogDTO;
import com.crypto.investment.CryptoInvestment.data.dto.CurrencyTradeDTO;
import com.crypto.investment.CryptoInvestment.mapper.mapstruct.CurrencyCatalogEntityDTOMapper;
import com.crypto.investment.CryptoInvestment.mapper.mapstruct.CurrencyCatalogEntityDTOMapperImpl;
import com.crypto.investment.CryptoInvestment.mapper.mapstruct.CurrencyTradeEntityDTOMapper;
import com.crypto.investment.CryptoInvestment.mapper.mapstruct.CurrencyTradeEntityDTOMapperImpl;
import com.crypto.investment.CryptoInvestment.repositories.jpa.CurrencyCatalogRepository;
import com.crypto.investment.CryptoInvestment.repositories.jpa.CurrencyTradeRepository;
import com.crypto.investment.CryptoInvestment.utils.CSVHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class CSVService {

    @Autowired
    private CurrencyTradeRepository repository;

    @Autowired
    private CurrencyCatalogRepository repositoryCurrencyCatalog;

    //    @Qualifier(value = "currencyTradeEntityDTOMapper")
    @Autowired
    private CurrencyTradeEntityDTOMapperImpl mapper;
    @Autowired
    private CurrencyCatalogEntityDTOMapperImpl catalogEntityDTOMapper;

    //TODO get table name from config
    public void save(MultipartFile file, String tableName) {
        try {
            if (tableName.equals("currency_trade")) {

                List<CurrencyTradeDTO> currencyTradeDTOS = CSVHelper.csvCurrencyTradeDTO(
                        file.getInputStream(), repositoryCurrencyCatalog);

                repository.saveAll(mapper.mapDTOToEntity(currencyTradeDTOS));
            }

            if (tableName.equals("currency_catalog")) {
                List<CurrencyCatalogDTO> currencyCatalogDTOS = CSVHelper.csvCurrencyCatalogDTO(file.getInputStream());

                repositoryCurrencyCatalog.saveAll(catalogEntityDTOMapper.mapDTOToEntity(currencyCatalogDTOS));
            }
        } catch (IOException e) {
            throw new RuntimeException("fail to store csv data: " + e.getMessage());
        }
    }


}
