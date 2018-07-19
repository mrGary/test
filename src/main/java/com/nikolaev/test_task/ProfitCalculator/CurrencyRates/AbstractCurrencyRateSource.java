package com.nikolaev.test_task.ProfitCalculator.CurrencyRates;

import com.jsunsoft.http.HttpRequest;
import com.jsunsoft.http.HttpRequestBuilder;
import com.jsunsoft.http.ResponseDeserializer;

import java.util.Date;

public abstract class AbstractCurrencyRateSource {

    public abstract CurrencyRate getCurrencyRate(String baseCurrency, String secondCurrency);

    public abstract CurrencyRate getCurrencyRate(String baseCurrency, String secondCurrency, Date date);

    static String sendGet(String url, String params) {
        HttpRequest<String> httpRequest = HttpRequestBuilder.createGet(url, String.class).responseDeserializer(ResponseDeserializer.ignorableDeserializer()).build();
        return httpRequest.executeWithQuery(params).get();
    }

}
