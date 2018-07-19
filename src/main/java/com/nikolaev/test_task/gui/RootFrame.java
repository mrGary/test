package com.nikolaev.test_task.gui;

import com.nikolaev.test_task.ProfitCalculator.Calculator;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class RootFrame implements ActionListener {
    private JFrame rootFrame;
    private JPanel rootPanel;
    private PurchaseDatePanel purchaseDatePanel = new PurchaseDatePanel();
    private AmountOfCurrencyPanel amountOfCurrencyPanel = new AmountOfCurrencyPanel();
    private ProfitCalculationPanel profitCalculationPanel = new ProfitCalculationPanel(this);
    private RateSourcePanel rateSourcePanel = new RateSourcePanel();
    private BaseCurrencyPanel baseCurrencyPanel = new BaseCurrencyPanel();
    private Calculator calc = new Calculator();

    public RootFrame() {
    }

    public void createGui() {
        rootFrameInit();
        rootPanel.add(rateSourcePanel);
        rootPanel.add(purchaseDatePanel);
        rootPanel.add(baseCurrencyPanel);
        rootPanel.add(amountOfCurrencyPanel);
        rootPanel.add(profitCalculationPanel);
        rootFrame.pack();
        rootFrame.setVisible(true);
    }

    private void rootFrameInit() {
        rootFrame = new JFrame("Profit Calculator");
        rootFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        rootFrame.setPreferredSize(new Dimension(400, 500));
        rootFrame.setLocation(new Point(400, 400));
        rootPanel = new JPanel(new GridLayout(5, 0, 5, 20));
        rootFrame.add(rootPanel, BorderLayout.NORTH);


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Double amount = amountOfCurrencyPanel.getAmmount();
        if (amount != null) {
            Double result = calc.calculateProfit(baseCurrencyPanel.getCurrency(), amount, purchaseDatePanel.getDate(), rateSourcePanel.getRateSource());
            if (result != null) {
                profitCalculationPanel.setProfit(result);
            } else {
                profitCalculationPanel.setWarning("Rate source data error");
            }
        }
    }


}
