package com.nikolaev.test_task.ProfitCalculator.CurrencyRates;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.text.SimpleDateFormat;
import java.util.Date;

public class FixerIoRateSource extends AbstractCurrencyRateSource {

    private final String LIVE_API_URL = "http://data.fixer.io/api/latest";
    private final String API_KEY = "64734f128c898814585d1b2307d545a3";
    private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    @Override
    public CurrencyRate getCurrencyRate(String baseCurrency, String secondCurrency) {
        String response = sendGet(LIVE_API_URL, liveParamString(baseCurrency, secondCurrency));
        Double rate = parseRate(baseCurrency, secondCurrency, response);
        return (rate != null) ? new CurrencyRate(baseCurrency, secondCurrency, rate) : null;
    }

    @Override
    public CurrencyRate getCurrencyRate(String baseCurrency, String secondCurrency, Date date) {
        String response = sendGet("http://data.fixer.io/api/"+dateFormat.format(date), historicalParamString(baseCurrency, secondCurrency));
        Double rate = parseRate(baseCurrency, secondCurrency, response);
        return (rate != null) ? new CurrencyRate(baseCurrency, secondCurrency, rate) : null;
    }

    private Double parseRate(String baseCurrency, String secondCurrency, String response) {
        JSONParser parser = new JSONParser();
        JSONObject jsonObject;
        try {
            jsonObject = (JSONObject) parser.parse(response);
            if ((Boolean) jsonObject.get("success")) {
                JSONObject rates = (JSONObject) jsonObject.get("rates");
                return (Double) rates.get(secondCurrency);
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;

    }

    private String liveParamString(String baseCurrency, String secondCurrency) {
        return "access_key=" + API_KEY + "&base=" + baseCurrency + "&symbols=" + secondCurrency;
    }

    private String historicalParamString(String baseCurrency, String secondCurrency) {
        return "access_key=" + API_KEY+ "&base=" + baseCurrency + "&symbols" + secondCurrency;
    }

}
