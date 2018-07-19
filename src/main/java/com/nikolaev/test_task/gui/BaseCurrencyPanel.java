package com.nikolaev.test_task.gui;

import com.nikolaev.test_task.ProfitCalculator.CurrencyRates.Currency;

import javax.swing.*;
import java.awt.*;

public class BaseCurrencyPanel extends JPanel {

    private JLabel baseCurrencyLabel;
    private JSpinner baseCurrencySpinner;

    BaseCurrencyPanel(){
        super(new GridLayout(0, 2, 5, 20));
        baseCurrencyLabelInit();
        baseCurrencySpinerInit();
        this.setSize(400, 40);
        this.add(baseCurrencyLabel);
        this.add(baseCurrencySpinner);
    }

    private void baseCurrencyLabelInit(){
        baseCurrencyLabel = new JLabel("Base Currency");
        baseCurrencyLabel.setSize(150, 30);
        baseCurrencyLabel.setHorizontalAlignment(JLabel.CENTER);
    }

    private void baseCurrencySpinerInit(){
        baseCurrencySpinner = new JSpinner(getDateModel());
        baseCurrencySpinner.setEditor(new JSpinner.ListEditor(baseCurrencySpinner));
        baseCurrencySpinner.setSize(150, 30);
    }

    private SpinnerListModel getDateModel() {
        return new SpinnerListModel(Currency.values());
    }

    public Currency getCurrency(){
        return Currency.valueOf(baseCurrencySpinner.getValue().toString());
    }

}
