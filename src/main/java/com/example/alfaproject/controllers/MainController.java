package com.example.alfaproject.controllers;

import com.example.alfaproject.parsers.GiphyParser;
import com.example.alfaproject.servises.CurrencyService;
import com.example.alfaproject.servises.FeignGiphyService;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Locale;

@RequiredArgsConstructor
@Controller
@RequestMapping
public class MainController {

    @Value("${giphyToken}")
    private String giphyToken;


    private final FeignGiphyService feignGiphyService;
    private final CurrencyService currencyService;

    private final GiphyParser giphyParser;

    @GetMapping("/")
    public String getHomePage(Model model) throws JsonProcessingException {
        model.addAttribute("currList", currencyService.getRatesNames());
        return "../static/index";
    }

    @PostMapping("/")
    public String redirectBySelectedCurr(@RequestParam("selectedCurr") String selectedCurr){
        System.out.println(selectedCurr);
        return "redirect:/currency/" + selectedCurr;
    }

    @GetMapping("/currency/{nameOfCurr}")
    public String getTestInfo(@PathVariable String nameOfCurr, Model model) throws JsonProcessingException {
        boolean grow = currencyService.getCurrencyGrow(nameOfCurr.toUpperCase(Locale.ROOT));

        String giffUrl;
        if (grow){
            giffUrl = giphyParser.getGiffUrl(feignGiphyService.getGifByTag("rich"));
            model.addAttribute("letter", "Поздравляю, валюта [" + nameOfCurr + "] выросла! ");
        } else {
            giffUrl = giphyParser.getGiffUrl(feignGiphyService.getGifByTag("broke"));
            model.addAttribute("letter", "К сожалению, валюта [" + nameOfCurr + "] упала.");
        }

        model.addAttribute("curr", nameOfCurr);
        model.addAttribute("giffUrl", giffUrl);
        return "/currencyResultPage";
    }
}
