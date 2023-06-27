package com.exchange.rates.Controllers;

import com.exchange.rates.Endpoints.RatesGetter;
import com.exchange.rates.ExchangeRates;
import org.springframework.stereotype.Component;

@Component
public class ExchangeRatesImplGetter implements RatesGetter {
    private RatesGetter exchangeRates;

    public ExchangeRatesImplGetter(RatesGetter exchangeRates) {
        this.exchangeRates = exchangeRates;
    }

    @Override
    public ExchangeRates getExchangeData(String app_id) {
        return exchangeRates.getExchangeData(app_id);
    }
}
