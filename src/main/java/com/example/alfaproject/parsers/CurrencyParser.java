package com.example.alfaproject.parsers;

import com.example.alfaproject.DTO.CurrenciesDTO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;

@Component
public class CurrencyParser {

    public CurrenciesDTO getCurrDataFromJSON(String jsonStr) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        CurrenciesDTO currenciesDTO = mapper.readValue(jsonStr, CurrenciesDTO.class);
        return currenciesDTO;
    }
}
