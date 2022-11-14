drop table if exists public.currency_catalog CASCADE;
drop table if exists public.currency_trade CASCADE;

create table CURRENCY_CATALOG
(
    ID            BIGINT                not null primary key,
    CURRENCY_NAME CHARACTER VARYING(255),
    SYMBOL        CHARACTER VARYING(5)  not null
        constraint UC_CURRENCYCATALOG_SYMBOL unique,
    DESCRIPTION   CHARACTER VARYING(255),
    ISACTIVE      BOOLEAN default TRUE  not null,
    ISDELETED     BOOLEAN default FALSE not null
);



create table CURRENCY_TRADE
(
    ID                 BIGINT                not null
        primary key,
    ISACTIVE           BOOLEAN default TRUE  not null,
    ISDELETED          BOOLEAN default FALSE not null,
    PRICE              DOUBLE PRECISION,
    TIMESTAMP_PRICE    BIGINT,
    CURRENCY_SYMBOL_ID BIGINT                not null,
    constraint FKK45SMQ75TN313SS29RJC7BSIL
        foreign key (CURRENCY_SYMBOL_ID) references CURRENCY_CATALOG
);
