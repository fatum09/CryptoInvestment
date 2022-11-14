package com.crypto.investment.CryptoInvestment.data.entity;

import lombok.*;

import javax.persistence.*;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "currency_trade")
@NamedQueries({
        @NamedQuery(name = "CurrencyTradeEntity.findByTimestampPriceBetweenAndIsDeletedFalseAndIsActiveTrue", query = "select c from CurrencyTradeEntity c where c.timestampPrice between :timestampPrice and :isDeleted and c.isDeleted = false and c.isActive = true")
})
public class CurrencyTradeEntity extends BaseEntity {

    @Id
    @Column(name = "id", updatable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "isdeleted", nullable = false, columnDefinition = "boolean default false")
    private Boolean isDeleted = false;

    @Column(name = "isactive", nullable = false, columnDefinition = "boolean default true")
    private Boolean isActive = true;

    @Basic
    @Column(name = "timestamp_price")
    private long timestampPrice;

    @OneToOne
    @JoinColumn(name = "currency_symbol_id", nullable = false)
    public CurrencyCatalogEntity currencySymbol;

    @Column(name = "price")
    private float price;

}
