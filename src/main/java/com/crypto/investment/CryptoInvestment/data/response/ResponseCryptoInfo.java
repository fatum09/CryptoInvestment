package com.crypto.investment.CryptoInvestment.data.response;

import lombok.Data;

@Data
public class ResponseCryptoInfo {
    private int month;
    private String symbol;
    private float min;
    private float max;
}
