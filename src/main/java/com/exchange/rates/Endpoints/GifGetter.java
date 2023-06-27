package com.exchange.rates.Endpoints;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="gif",url ="${giphy.url.general}")
public interface GifGetter {
    @GetMapping("/{code}")
    ResponseEntity<String> getGif(@PathVariable String code);
}
