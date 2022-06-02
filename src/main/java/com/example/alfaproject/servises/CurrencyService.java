package com.example.alfaproject.servises;

import com.example.alfaproject.DTO.CurrenciesDTO;
import com.example.alfaproject.parsers.CurrencyParser;
import com.example.alfaproject.repositories.FeignCurrencyRepo;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@Slf4j
@RequiredArgsConstructor
@Service
public class CurrencyService {

    private final FeignCurrencyRepo feignCurrencyRepo;
    private final CurrencyParser currencyParser;

    public boolean getCurrencyGrow(String neededCurrency) throws JsonProcessingException {
        CurrenciesDTO latestData = currencyParser.getCurrDataFromJSON(feignCurrencyRepo.getLatestCurrency());
        CurrenciesDTO pastData = currencyParser.getCurrDataFromJSON(feignCurrencyRepo.getCurrencyByDate(LocalDate.now().minusDays(1).toString()));

        double latest = latestData.getRates().get(neededCurrency);
        double past = pastData.getRates().get(neededCurrency);
        log.info("searched currency: {}", neededCurrency);
        log.info("previous value: {}", past);
        log.info("latest value: {}", latest);

        return latest <= past;
    }

    public List<String> getRatesNames() throws JsonProcessingException {
        Map<String, Double> rates = currencyParser.getCurrDataFromJSON(feignCurrencyRepo.getLatestCurrency()).getRates();
        return rates.keySet().stream().toList();
    }
}
