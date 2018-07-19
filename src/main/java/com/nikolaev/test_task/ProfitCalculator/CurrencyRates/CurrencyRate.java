package com.nikolaev.test_task.ProfitCalculator.CurrencyRates;

import java.util.List;

public class CurrencyRate {

    public final String baseCurrency;
    public final String secondCurrency;
    public final double rate;

    public CurrencyRate(String baseCurrency, String secondCurrency, double rate) {
        this.baseCurrency = baseCurrency;
        this.secondCurrency = secondCurrency;
        this.rate = rate;
    }
}

