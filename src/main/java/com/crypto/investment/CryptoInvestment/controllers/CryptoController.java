package com.crypto.investment.CryptoInvestment.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;

@RestController
public class CryptoController {

    public ResponseEntity<?> getCryptoCatalog(){

        return null;
    }

    public ResponseEntity<?>  deleteCrypto(){

        return null;
    }

    public ResponseEntity<?>  deactivateCrypto(@PathParam("cryptoSymbol") String cryptoSymbol){

        return null;
    }

    public ResponseEntity<?>  updateCrypto(@PathParam("cryptoSymbol") String cryptoSymbol){

        return null;
    }

}
