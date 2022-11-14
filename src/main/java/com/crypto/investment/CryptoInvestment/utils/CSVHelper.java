package com.crypto.investment.CryptoInvestment.utils;

import com.crypto.investment.CryptoInvestment.data.dto.CurrencyCatalogDTO;
import com.crypto.investment.CryptoInvestment.data.dto.CurrencyTradeDTO;
import com.crypto.investment.CryptoInvestment.repositories.jpa.CurrencyCatalogRepository;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class CSVHelper {

    public static String TYPE = "text/csv";
//    static String[] HEADER_CRYPTO_TRADEs = {"timestamp", "symbol", "price"};
//    static String[] HEADER_CRYPTO_CATALOGs = {"currency_name", "symbol", "description"};

    public static boolean hasCSVFormat(MultipartFile file) {

        if (!TYPE.equals(file.getContentType())) {
            return false;
        }
        return true;
    }

    public static List<CurrencyTradeDTO> csvCurrencyTradeDTO(InputStream is, CurrencyCatalogRepository repository) {
        try (BufferedReader fileReader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
             CSVParser csvParser = new CSVParser(fileReader,
                     CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim());) {

            List<CurrencyTradeDTO> currencyTradeDTOS = new ArrayList<>();

            Iterable<CSVRecord> csvRecords = csvParser.getRecords();

            for (CSVRecord csvRecord : csvRecords) {
                CurrencyTradeDTO currencyTradeDto = new CurrencyTradeDTO();
                currencyTradeDto
                        .setTimestampPrice(Long.parseLong(csvRecord.get("timestamp")))
                        .setCurrencySymbolId(
                                repository.findByCurrencySymbolIgnoreCase(csvRecord.get("symbol"))
                                        .getId()
                        )
                        .setPrice(Float.parseFloat(csvRecord.get("price")));

                currencyTradeDTOS.add(currencyTradeDto);
            }

            return currencyTradeDTOS;
        } catch (IOException e) {
            throw new RuntimeException("fail to parse CSV file: " + e.getMessage());
        }
    }

    public static List<CurrencyCatalogDTO> csvCurrencyCatalogDTO(InputStream is) {
        try (BufferedReader fileReader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
             CSVParser csvParser = new CSVParser(fileReader,
                     CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim());) {

            List<CurrencyCatalogDTO> currencyCatalogDTOS = new ArrayList<>();

            Iterable<CSVRecord> csvRecords = csvParser.getRecords();

            for (CSVRecord csvRecord : csvRecords) {
                CurrencyCatalogDTO currencyCatalogDTO = new CurrencyCatalogDTO();
                currencyCatalogDTO
                        .setCurrencyName(csvRecord.get("currency_name"))
                        .setCurrencySymbol(csvRecord.get("symbol"))
                        .setDescription(csvRecord.get("description"));

                currencyCatalogDTOS.add(currencyCatalogDTO);
            }

            return currencyCatalogDTOS;
        } catch (IOException e) {
            throw new RuntimeException("fail to parse CSV file: " + e.getMessage());
        }
    }

}
