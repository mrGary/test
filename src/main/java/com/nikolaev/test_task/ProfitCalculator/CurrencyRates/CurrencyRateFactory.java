package com.nikolaev.test_task.ProfitCalculator.CurrencyRates;


import java.util.Date;

public class CurrencyRateFactory {

    private CurrencyRateFactory() {

    }

    public static CurrencyRate getCurrencyRate(String baseCurrency, String secondCurrency, Date date, RateSource rateSource) {
        return getRateSource(rateSource).getCurrencyRate(baseCurrency, secondCurrency, date);
    }

    public static CurrencyRate getCurrencyRate(String baseCurrency, String secondCurrency, RateSource rateSource) {
        return getRateSource(rateSource).getCurrencyRate(baseCurrency, secondCurrency);
    }

    private static AbstractCurrencyRateSource getRateSource(RateSource rateSource){
        switch (rateSource) {
            case fixerio: return new FixerIoRateSource();
            case currencylayer: return new CurrencyLayerRateSource();
        }
         return null;
    }


}
