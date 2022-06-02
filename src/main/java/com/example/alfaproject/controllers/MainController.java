package com.example.alfaproject.controllers;

import com.example.alfaproject.servises.CurrencyService;
import com.example.alfaproject.servises.FeignGiphyService;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;

@RequiredArgsConstructor
@RestController
@RequestMapping
public class MainController {

    @Value("${giphyToken}")
    private String giphyToken;


    private final FeignGiphyService feignGiphyService;
    private final CurrencyService currencyService;

    @GetMapping("/currency/{nameOfCurr}")
    public String getTestInfo(@PathVariable String nameOfCurr) throws JsonProcessingException {
        boolean grow = currencyService.getCurrencyGrow(nameOfCurr.toUpperCase(Locale.ROOT));

        return "hello";
    }

    @GetMapping("/giff")
    public String getTestGiff(){
        return feignGiphyService.getGifByTag("rich", giphyToken);
    }
}
