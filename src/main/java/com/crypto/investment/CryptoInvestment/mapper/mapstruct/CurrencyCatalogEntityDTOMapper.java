package com.crypto.investment.CryptoInvestment.mapper.mapstruct;

import com.crypto.investment.CryptoInvestment.data.dto.CurrencyCatalogDTO;
import com.crypto.investment.CryptoInvestment.data.dto.CurrencyTradeDTO;
import com.crypto.investment.CryptoInvestment.data.entity.CurrencyCatalogEntity;
import com.crypto.investment.CryptoInvestment.data.entity.CurrencyTradeEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CurrencyCatalogEntityDTOMapper extends BaseEntityDTOMapper<CurrencyCatalogEntity, CurrencyCatalogDTO> {

    //    CurrencyTradeDTO currencyTradeEntityToDTO(CurrencyTradeEntity source);
//    @Mapping(source = "currencySymbolId", target = "currencySymbol")
//    @Override
//    CurrencyCatalogEntity mapDTOToEntity(CurrencyCatalogDTO source);

//    @Mapping(source = "currencySymbol", target = "currencySymbolId")
//    @Override
//    CurrencyCatalogDTO mapEntityToDTO(CurrencyCatalogEntity source);

    //    CurrencyTradeEntity currencyTradeDTOToEntity(CurrencyTradeDTO source);

//    CurrencyCatalogEntity mapLongToEntity(Long value);

//    Long mapEntityToLong(CurrencyCatalogEntity value);

}
