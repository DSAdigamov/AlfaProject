package com.example.alfaproject.repositories;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "giphyApi", url = "${giphyUrl}")
public interface FeignGiphyRepo {

    @GetMapping(value = "random?api_key=${giphyToken}&tag={tag}&rating=g")
    String getGifByTag(@PathVariable("tag") String tag);
}
