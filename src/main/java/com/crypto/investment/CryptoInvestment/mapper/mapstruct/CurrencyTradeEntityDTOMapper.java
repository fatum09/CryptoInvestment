package com.crypto.investment.CryptoInvestment.mapper.mapstruct;

import com.crypto.investment.CryptoInvestment.data.dto.CurrencyTradeDTO;
import com.crypto.investment.CryptoInvestment.data.entity.CurrencyTradeEntity;
import com.crypto.investment.CryptoInvestment.repositories.jpa.CurrencyCatalogRepository;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.springframework.beans.factory.annotation.Autowired;

@Named("currencyTradeEntityDTOMapper")
@Mapper(componentModel = "spring")
public abstract class CurrencyTradeEntityDTOMapper implements BaseEntityDTOMapper<CurrencyTradeEntity, CurrencyTradeDTO> {

    @Autowired
    public CurrencyCatalogRepository repositoy;

    @Mapping(target = "currencySymbol", expression = "java(repositoy.findById(source.getCurrencySymbolId()).get())")
    public abstract CurrencyTradeEntity mapDTOToEntity(CurrencyTradeDTO source);

    @Mapping(source = "source.currencySymbol.id", target = "currencySymbolId")
    public abstract CurrencyTradeDTO mapEntityToDTO(CurrencyTradeEntity source);


}
