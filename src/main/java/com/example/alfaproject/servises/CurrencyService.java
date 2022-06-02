package com.example.alfaproject.servises;

import com.example.alfaproject.DTO.CurrenciesDTO;
import com.example.alfaproject.parsers.CurrencyParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

@Slf4j
@RequiredArgsConstructor
@Service
public class CurrencyService {

    private final FeignCurrencyService feignCurrencyService;
    private final CurrencyParser currencyParser;

    public boolean getCurrencyGrow(String neededCurrency) throws JsonProcessingException {
        CurrenciesDTO latestData = currencyParser.getCurrDataFromJSON(feignCurrencyService.getLatestCurrency());
        CurrenciesDTO pastData = currencyParser.getCurrDataFromJSON(feignCurrencyService.getCurrencyByDate(LocalDate.now().minusDays(1).toString()));

        double latest = latestData.getRates().get(neededCurrency);
        double past = pastData.getRates().get(neededCurrency);

        log.info("previous value: {}", past);
        log.info("latest value: {}", latest);

        if (latest <= past)
            return true;
        else return false;
    }

    public List<String> getRatesNames() throws JsonProcessingException {
        Map<String, Double> rates = currencyParser.getCurrDataFromJSON(feignCurrencyService.getLatestCurrency()).getRates();
        return rates.keySet().stream().toList();
    }
}
