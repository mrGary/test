package com.nikolaev.test_task.gui;

import com.nikolaev.test_task.ProfitCalculator.CurrencyRates.RateSource;

import javax.swing.*;
import java.awt.*;

class RateSourcePanel extends JPanel {

    private JSpinner rateSourceSpinner;
    private JLabel rateSourceLabel;

    RateSourcePanel() {
        super(new GridLayout(0, 2, 5, 20));
        rateSourceLabelInit();
        rateSourceSpinnerInit();
        this.setSize(400, 40);
        this.add(rateSourceLabel);
        this.add(rateSourceSpinner);
    }

    private void rateSourceSpinnerInit() {
        rateSourceSpinner = new JSpinner(getDateModel());
        rateSourceSpinner.setEditor(new JSpinner.ListEditor(rateSourceSpinner));
        rateSourceSpinner.setSize(150, 30);
    }

    private void rateSourceLabelInit() {
        rateSourceLabel = new JLabel("Rate source");
        rateSourceLabel.setSize(150, 30);
        rateSourceLabel.setHorizontalAlignment(JLabel.CENTER);
    }

    private SpinnerListModel getDateModel() {
        return new SpinnerListModel(RateSource.values());
    }

    public RateSource getRateSource() {
        return RateSource.valueOf(rateSourceSpinner.getValue().toString());
    }


}
