package com.exchange.rates.Endpoints;


import com.exchange.rates.ExchangeRates;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "ratesClient", url = "${openexchangerates.url.general}")
public interface RatesGetter {

    @GetMapping("/latest.json")
    ExchangeRates getExchangeData(
            @RequestParam("app_id") String app_id);
}
