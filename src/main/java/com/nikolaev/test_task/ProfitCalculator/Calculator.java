package com.nikolaev.test_task.ProfitCalculator;

import com.nikolaev.test_task.ProfitCalculator.CurrencyRates.Currency;
import com.nikolaev.test_task.ProfitCalculator.CurrencyRates.CurrencyRate;
import com.nikolaev.test_task.ProfitCalculator.CurrencyRates.CurrencyRateFactory;
import com.nikolaev.test_task.ProfitCalculator.CurrencyRates.RateSource;

import java.util.Date;

public class Calculator {

    private final String SECOND_CURRENCY = "RUB";
    private final double SPREAD = 0.005;

    public Double calculateProfit(Currency baseCurrency, double ammountOfBaseCurrency, Date dateOfPurchase, RateSource rateSource) {
        CurrencyRate historicalRate = CurrencyRateFactory.getCurrencyRate(baseCurrency.toString(), SECOND_CURRENCY, dateOfPurchase, rateSource);
        CurrencyRate currentRate = CurrencyRateFactory.getCurrencyRate(baseCurrency.toString(), SECOND_CURRENCY, rateSource);
        if (currentRate != null && historicalRate != null) {
            return ((currentRate.rate - currentRate.rate * SPREAD) - historicalRate.rate) * ammountOfBaseCurrency;
        } else {
            return null;
        }

    }
}
