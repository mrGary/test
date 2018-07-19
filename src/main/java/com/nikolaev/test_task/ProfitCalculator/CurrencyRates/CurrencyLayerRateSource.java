package com.nikolaev.test_task.ProfitCalculator.CurrencyRates;


import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.text.SimpleDateFormat;
import java.util.Date;

public class CurrencyLayerRateSource extends AbstractCurrencyRateSource {

    private final String LIVE_API_URL = "http://apilayer.net/api/live";
    private final String HISTORICAL_API_URL = "http://apilayer.net/api/historical";
    private final String API_KEY = "5983263f8f91665885de3e6825eb372c";
    private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    @Override
    public CurrencyRate getCurrencyRate(String baseCurrency, String secondCurrency) {
        String response = sendGet(LIVE_API_URL, liveParamString(baseCurrency, secondCurrency));
        Double rate = parseRate(baseCurrency, secondCurrency, response);
        return (rate != null) ? new CurrencyRate(baseCurrency, secondCurrency, rate) : null;
    }

    @Override
    public CurrencyRate getCurrencyRate(String baseCurrency, String secondCurrency, Date date) {
        String response = sendGet(HISTORICAL_API_URL, historicalParamString(baseCurrency, secondCurrency, dateFormat.format(date)));
        Double rate = parseRate(baseCurrency, secondCurrency, response);

        return (rate != null) ? new CurrencyRate(baseCurrency, secondCurrency, rate) : null;
    }


    private Double parseRate(String baseCurrency, String secondCurrency, String response) {
        JSONParser parser = new JSONParser();
        JSONObject jsonObject;
        try {
            jsonObject = (JSONObject) parser.parse(response);
            if ((Boolean) jsonObject.get("success")) {
                JSONObject quotes = (JSONObject) jsonObject.get("quotes");
                return (Double) quotes.get(baseCurrency + secondCurrency);
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }


    private String liveParamString(String baseCurrency, String secondCurrency) {
        return "access_key=" + API_KEY + "&source=" + baseCurrency + "&" + "currencies=" + secondCurrency + "&format=1";
    }

    private String historicalParamString(String baseCurrency, String secondCurrency, String date) {
        return "access_key=5983263f8f91665885de3e6825eb372c&" + "date=" + date + "&currencies=" + baseCurrency + "," + secondCurrency + "&format=1";
    }


}
