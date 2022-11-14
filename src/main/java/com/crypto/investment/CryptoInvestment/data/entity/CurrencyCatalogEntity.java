package com.crypto.investment.CryptoInvestment.data.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "currency_catalog", uniqueConstraints = {
        @UniqueConstraint(name = "uc_currencycatalog_symbol", columnNames = {"symbol"})
})
@NamedQueries({
        @NamedQuery(name = "CurrencyCatalog.findByIsDeletedFalseAndIsActiveTrue", query = "select c from CurrencyCatalogEntity c where c.isDeleted = false and c.isActive = true")
})
public class CurrencyCatalogEntity extends BaseEntity {

    @Id
    @Column(name = "id", updatable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "isdeleted", nullable = false, columnDefinition = "boolean default false")
    private Boolean isDeleted = false;

    @Column(name = "isactive", nullable = false, columnDefinition = "boolean default true")
    private Boolean isActive = true;

    @Column(name = "currency_name")
    private String CurrencyName;

    @Column(name = "symbol", length = 5, nullable = false)
    private String currencySymbol;

    @Column(name = "description")
    private String description;

}
