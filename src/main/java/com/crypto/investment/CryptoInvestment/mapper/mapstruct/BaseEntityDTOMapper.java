package com.crypto.investment.CryptoInvestment.mapper.mapstruct;

import com.crypto.investment.CryptoInvestment.data.dto.BaseDTO;
import com.crypto.investment.CryptoInvestment.data.entity.BaseEntity;

import java.util.List;

public interface BaseEntityDTOMapper<ENTITY extends BaseEntity, DTO extends BaseDTO> {

    DTO mapEntityToDTO(ENTITY source);

    ENTITY mapDTOToEntity(DTO source);

    List<DTO> mapEntityToDTO(List<ENTITY> models);

    List<ENTITY> mapDTOToEntity(List<DTO> entityList);

}
