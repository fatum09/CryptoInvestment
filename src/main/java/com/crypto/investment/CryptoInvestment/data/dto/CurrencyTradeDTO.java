package com.crypto.investment.CryptoInvestment.data.dto;

import com.crypto.investment.CryptoInvestment.data.entity.CurrencyTradeEntity;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * A DTO for the {@link CurrencyTradeEntity} entity
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class CurrencyTradeDTO extends BaseDTO  implements Serializable {

    private Long id;

    private Boolean isDeleted = false;

    private Boolean isActive = true;

    private long timestampPrice;

    @JsonProperty("currency_symbol_id")
    public Long currencySymbolId;

    private float price;

}