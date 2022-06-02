package com.example.alfaproject.servises;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(url = "${currencyUrl}", value = "currencyApi")
public interface FeignCurrencyService {

    @GetMapping(value = "latest.json?app_id=${openExchangeToken}&base=${baseCurr}")
    String getLatestCurrency();

    @GetMapping(value = "historical/{neededDate}.json?app_id=${openExchangeToken}&base=${baseCurr}")
    String getCurrencyByDate(@PathVariable String neededDate);
}
