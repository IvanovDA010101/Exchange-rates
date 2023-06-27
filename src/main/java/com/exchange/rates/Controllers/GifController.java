package com.exchange.rates.Controllers;

import java.util.Map;

import com.exchange.rates.Endpoints.RandomGifGetter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GifController {
    private RandomGifGetter randomGifGetter;

    @Value("${giphy.api.key}")
    private String apiKey;
    @Value("${giphy.rich}")
    private String tag;
    public GifController(RandomGifGetter randomGifGetter) {
        this.randomGifGetter = randomGifGetter;
    }


    @GetMapping("/random")
    public Object getGifTest() {
        ResponseEntity<Map> randomGif = randomGifGetter.getRandomGif(apiKey, tag);
        return randomGif.getBody().get("data");
    }
}
