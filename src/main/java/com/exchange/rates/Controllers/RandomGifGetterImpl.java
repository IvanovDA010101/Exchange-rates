package com.exchange.rates.Controllers;

import java.util.Map;

import com.exchange.rates.Endpoints.GifGetter;
import com.exchange.rates.Endpoints.RandomGifGetter;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class RandomGifGetterImpl implements RandomGifGetter, GifGetter {


    private RandomGifGetter randomGifGetter;
    private GifGetter gifGetter;

    public RandomGifGetterImpl(RandomGifGetter randomGifGetter, GifGetter gifGetter) {
        this.randomGifGetter = randomGifGetter;
        this.gifGetter = gifGetter;
    }


    @Override
    public ResponseEntity<Map> getRandomGif(String apiKey, String tag) {
        return randomGifGetter.getRandomGif(apiKey, tag);
    }

    @Override
    public ResponseEntity<String> getGif(String code) {
        return gifGetter.getGif(code);
    }
}
