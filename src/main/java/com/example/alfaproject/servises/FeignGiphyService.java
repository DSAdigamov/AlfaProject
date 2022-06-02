package com.example.alfaproject.servises;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "giphyApi", url = "${giphyUrl}")
public interface FeignGiphyService {

    @GetMapping(value = "random?api_key=${giphyToken}&tag={tag}&rating=g")
    String getGifByTag(@PathVariable("tag") String tag);
}
