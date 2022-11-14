package com.crypto.investment.CryptoInvestment.controllers;

import com.crypto.investment.CryptoInvestment.data.dto.CurrencyTradeDTO;
import com.crypto.investment.CryptoInvestment.data.response.ResponseCryptoInfo;
import com.crypto.investment.CryptoInvestment.services.AdviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;
import java.util.List;

@CrossOrigin("*")
@RequestMapping("/api/crypto")
@RestController
public class AdviceController {

    @Autowired
    AdviceService adviceService;

    @GetMapping(value = "/info")
    public ResponseEntity<?> getCalculationForAllCrypto(){
//        List<ResponseCryptoInfo> result;
        List<ResponseCryptoInfo> result;
        result = adviceService.getCryptoInfo();

         return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    public ResponseEntity<?>  getNormalizedRange(){

        return null;
    }

    public ResponseEntity<?>  getInfoForCrypto(@PathParam("cryptoSymbol") String cryptoSymbol){

        return null;
    }

    public ResponseEntity<?>  getInfoHighestNormalized(@PathParam("cryptoSymbol") String cryptoSymbol){

        return null;
    }

}
