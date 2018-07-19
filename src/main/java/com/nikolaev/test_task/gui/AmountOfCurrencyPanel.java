package com.nikolaev.test_task.gui;

import javax.swing.*;
import java.awt.*;
import java.util.regex.Pattern;

public class AmountOfCurrencyPanel extends JPanel {

    private final static String DOUBLE_PATTERN = "[0-9]+(\\.){0,1}[0-9]*";
    private final static String INTEGER_PATTERN = "\\d+";

    private JLabel amountOfCurrencyLabel;
    private JTextField amountOfCurrencyTextField;

    public AmountOfCurrencyPanel(){
        super(new GridLayout(0,2,5,20));
        AmountOfCurrencyLabelInit();
        AmountOfCurrencyTextFieldInit();
        this.add(amountOfCurrencyLabel);
        this.add(amountOfCurrencyTextField);
        this.setSize(400, 120);
    }

    private void AmountOfCurrencyLabelInit(){
        amountOfCurrencyLabel = new JLabel("Amount");
        amountOfCurrencyLabel.setSize(150, 30);
        amountOfCurrencyLabel.setHorizontalAlignment(JLabel.CENTER);
    }

    private void AmountOfCurrencyTextFieldInit(){
        amountOfCurrencyTextField = new JTextField();
        amountOfCurrencyTextField.setSize(150, 30);
    }

    private boolean validateDouble(String string){
        return (Pattern.matches(DOUBLE_PATTERN, string) || Pattern.matches(INTEGER_PATTERN, string));
    }

    public Double getAmmount(){
        String text = amountOfCurrencyTextField.getText();
        if (validateDouble(text)){
            return Double.parseDouble(text);
        }else {
            amountOfCurrencyTextField.setText("Wrong Input");
            return null;
        }
    }

}
