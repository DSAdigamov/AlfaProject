package com.example.alfaproject.DTO;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Date;
import java.util.Map;

@Data
public class CurrenciesDTO {
    @JsonProperty("timestamp")
    private String unixTimestamp;
    private Date date;
    private String base;
    private Map<String, Double> rates;

    public void setDate() {
        this.date = new Date(Long.parseLong(this.unixTimestamp) * 1000);
    }

    public Date getDate() {
        if (date == null)
            setDate();
        return date;
    }
}
