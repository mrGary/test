package com.nikolaev.test_task.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class ProfitCalculationPanel extends JPanel {

    private JLabel profitLabel;
    private JTextArea profitTextArea;
    private JButton profitCalculationButton;
    private ActionListener listener;

    ProfitCalculationPanel(ActionListener actionListener){
        super(new GridLayout(0,2,5,20));
        listener = actionListener;
        profitLabelInit();
        profitTextAreaInit();
        profitCalculationButtonInit();
        this.setSize(400, 120);
        this.add(profitLabel);
        this.add(profitTextArea);
        this.add(profitCalculationButton);

    }

    private void profitLabelInit(){
        profitLabel = new JLabel("Profit");
        profitLabel.setHorizontalAlignment(JLabel.CENTER);
//        profitLabel.setSize(150, 30);
    }

    private void profitTextAreaInit(){
        profitTextArea = new JTextArea();
//        profitTextArea.setSize(150,30);
        profitTextArea.setEditable(false);
    }

    private void profitCalculationButtonInit(){


        profitCalculationButton = new JButton("Recalculate");
//        profitCalculationButton.setSize(150, 30);
        profitCalculationButton.addActionListener(listener);
    }

    public void setProfit(Double profit){

        if (profit >0) {
            profitTextArea.setBackground(Color.GREEN);
        }else {
            profitTextArea.setBackground(Color.RED);
        }
        profitTextArea.setText(profit.toString());
    }

    public void setWarning(String string){
        profitTextArea.setBackground(Color.YELLOW);
        profitTextArea.setText(string);
    }
}
