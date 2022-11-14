package com.crypto.investment.CryptoInvestment.services;

import com.crypto.investment.CryptoInvestment.data.dto.CurrencyTradeDTO;
import com.crypto.investment.CryptoInvestment.data.entity.CurrencyTradeEntity;
import com.crypto.investment.CryptoInvestment.data.response.ResponseCryptoInfo;
import com.crypto.investment.CryptoInvestment.mapper.mapstruct.CurrencyTradeEntityDTOMapper;
import com.crypto.investment.CryptoInvestment.repositories.jpa.CurrencyCatalogRepository;
import com.crypto.investment.CryptoInvestment.repositories.jpa.CurrencyTradeRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Data
@Service
public class AdviceService {

    @Autowired
    private CurrencyTradeRepository repository;
    @Autowired
    private CurrencyCatalogRepository catalogRepository;

    @Autowired
//    @Qualifier(value = "currencyTradeEntityDTOMapper")
    private CurrencyTradeEntityDTOMapper mapper;

    public List<ResponseCryptoInfo> getCryptoInfo() {
//        repository.f
        List<CurrencyTradeEntity> currencyTradeEntities = repository.findAll();
        List<CurrencyTradeDTO> currencyTradeDTOs = mapper.mapEntityToDTO(currencyTradeEntities);
        Map<Integer, Map<String, List<CurrencyTradeDTO>>> currencyTradeDTOGroupedByMonth = new HashMap<>();

        for (CurrencyTradeDTO currencyTradeDTO : currencyTradeDTOs) {
            Calendar calendar = Calendar.getInstance();
            calendar.setTimeInMillis(currencyTradeDTO.getTimestampPrice());
            int month = calendar.get(Calendar.MONTH) + 1;

            if (currencyTradeDTOGroupedByMonth.get(month) == null) {
                currencyTradeDTOGroupedByMonth.put(month, new HashMap<>());
            }

            String currencySymbol = catalogRepository.getReferenceById(currencyTradeDTO.currencySymbolId).getCurrencySymbol();
            if (currencyTradeDTOGroupedByMonth.get(month).get(currencySymbol) == null) {
                currencyTradeDTOGroupedByMonth.get(month).put(currencySymbol, new ArrayList<>());
            }

            currencyTradeDTOGroupedByMonth.get(month).get(currencySymbol).add(currencyTradeDTO);

        }


        List<ResponseCryptoInfo> responseCryptoInfos = new ArrayList<>();
        for (Integer keyMonth : currencyTradeDTOGroupedByMonth.keySet()) {
//            Map<String, List<CurrencyTradeDTO>
            for (String symbolKey : currencyTradeDTOGroupedByMonth.get(keyMonth).keySet()) {
                ResponseCryptoInfo responseCryptoInfo = new ResponseCryptoInfo();
                responseCryptoInfo.setMonth(keyMonth);
                responseCryptoInfo.setSymbol(symbolKey);
                responseCryptoInfo.setMin(
                        currencyTradeDTOGroupedByMonth.get(keyMonth).get(symbolKey).stream()
                                .min((o1, o2) -> Float.compare(o1.getPrice(), o2.getPrice()))
                                .get().getPrice());
                responseCryptoInfo.setMax(
                        currencyTradeDTOGroupedByMonth.get(keyMonth).get(symbolKey).stream()
                                .max((o1, o2) -> Float.compare(o1.getPrice(), o2.getPrice()))
                                .get().getPrice()
                );
                responseCryptoInfos.add(responseCryptoInfo);
            }
        }

        return responseCryptoInfos;
    }
}
