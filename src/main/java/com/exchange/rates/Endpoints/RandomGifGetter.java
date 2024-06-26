package com.exchange.rates.Endpoints;

import java.util.Map;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "giphyClient", url = "${giphy.url.general}")
public interface RandomGifGetter {

    @GetMapping("/random")
    ResponseEntity<Map> getRandomGif(
            @RequestParam("api_key") String apiKey,
            @RequestParam("tag") String tag);


}
