package com.crypto.investment.CryptoInvestment.controllers;

import com.crypto.investment.CryptoInvestment.services.CSVService;
import com.crypto.investment.CryptoInvestment.utils.CSVHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@CrossOrigin("*")
@Controller
@RequestMapping("/api/csv")
public class CSVController {
    @Autowired
    CSVService fileService;

    //    TODO defaultValue get from config
    @PostMapping("/upload")
    public ResponseEntity<?> uploadFile(@RequestParam("file") MultipartFile file, @RequestParam(required = true) String tableName) {
        String message = "";
        if (tableName.isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("You should set table name");
        }
        if (CSVHelper.hasCSVFormat(file)) {
            try {
                fileService.save(file, tableName);

                message = "Uploaded the file successfully: " + file.getOriginalFilename();
                return ResponseEntity.status(HttpStatus.OK).body(message);
            } catch (Exception e) {
                message = "Could not upload the file: " + file.getOriginalFilename() + "!";
                message += "\n" + e.getCause().toString();
                return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(message);
            }
        }

        message = "Please upload a csv file!";
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(message);
    }

}
