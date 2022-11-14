package com.crypto.investment.CryptoInvestment.data.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * A DTO for the {@link com.crypto.investment.CryptoInvestment.data.entity.CurrencyCatalogEntity} entity
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class CurrencyCatalogDTO extends BaseDTO implements Serializable {

    private Long id;

    private Boolean isDeleted = false;

    private Boolean isActive = true;

    private String CurrencyName;

    private String currencySymbol;

    private String description;
}