package com.crypto.investment.CryptoInvestment.data.entity;

import lombok.Builder;
import lombok.Data;
import lombok.Setter;

import javax.persistence.*;


@Data
@MappedSuperclass
public abstract class BaseEntity {

//    @Id
//    @Column(name = "id", updatable = false)
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    private Long id;
//
//    @Column(name = "isdeleted", nullable = false, columnDefinition = "boolean default false")
//    private Boolean isDeleted = false;
//
//    @Column(name = "isactive", nullable = false, columnDefinition = "boolean default true")
//    private Boolean isActive = true;

}
