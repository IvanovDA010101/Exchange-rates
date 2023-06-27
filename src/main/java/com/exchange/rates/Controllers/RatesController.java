package com.exchange.rates.Controllers;

import java.io.File;
import java.util.Map;

import com.exchange.rates.Endpoints.RatesGetter;
import com.exchange.rates.ExchangeRates;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.scheduling.annotation.Schedules;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.exchange.rates.Test.req;

@RestController
public class RatesController {
    private req req;

    @GetMapping("/req")
    public void getReq(){
        File file = new File("test.txt");
        req.put("test.txt",file);
    }

    private ExchangeRates exchangeRates;
    private RatesGetter ratesGetter;
    @Value("${openexchangerates.app.id}")
    private String app_id;

    private boolean isRich;
    @Value("${openexchangerates.check}")
    private String rate;
    public RatesController(RatesGetter ratesGetter,req req) {
        this.ratesGetter = ratesGetter;
        this.req=req;
    }

    @GetMapping("/lastRates")
    public ExchangeRates getExchangeRates(){
        if(exchangeRates==null){
           getExchangeData();
        }
        return this.exchangeRates;
    }

    @GetMapping("/rates")
    public Map<String, Double> getExchangeData() {
        exchangeRates = ratesGetter.getExchangeData(app_id);
        return exchangeRates.getRates();
    }

    @Scheduled(cron = "0 * * * * *")
    private void refreshFlag(){
        Double oldRate=this.exchangeRates.getRates().get(rate);
        getExchangeData();
        Double newRate=this.exchangeRates.getRates().get(rate);
        isRich=oldRate<newRate ? true : false;
    }
}
