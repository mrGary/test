package com.nikolaev.test_task.gui;

import javax.swing.*;
import java.awt.*;
import java.util.Calendar;
import java.util.Date;

public class PurchaseDatePanel extends JPanel {


    private JSpinner dateSpinner;
    private JLabel dateLabel;

    PurchaseDatePanel() {
        super(new GridLayout(0, 2, 5, 20));
        dateLabelInit();
        dateSpinnerInit();
        this.setSize(400, 40);
        this.add(dateLabel);
        this.add(dateSpinner);
    }

    private void dateSpinnerInit() {
        dateSpinner = new JSpinner(getDateModel());
        dateSpinner.setEditor(new JSpinner.DateEditor(dateSpinner, "dd/MM/yyyy"));
        dateSpinner.setSize(150, 30);
    }

    private void dateLabelInit() {
        dateLabel = new JLabel("Date of Purchase");
        dateLabel.setSize(150, 30);
        dateLabel.setHorizontalAlignment(JLabel.CENTER);
    }

    private SpinnerDateModel getDateModel() {
        Calendar calendar = Calendar.getInstance();
        Date endDate = calendar.getTime();
        calendar.add(Calendar.DAY_OF_WEEK_IN_MONTH, -1);
        Date initDate = calendar.getTime();
        calendar.add(Calendar.YEAR, -20);
        Date earliestDate = calendar.getTime();
        return new SpinnerDateModel(initDate, earliestDate, endDate, Calendar.DAY_OF_MONTH);
    }

    public Date getDate() {
        return (Date) dateSpinner.getModel().getValue();
    }

}
