package com.gmail.vuyotm.swingy.view;

import lombok.Getter;

import javax.swing.*;
import java.awt.*;

@Getter

public class MoveRegularGuiView extends JFrame {

    private JLabel      heading;
    private JButton     northBtn;
    private JButton     southBtn;
    private JButton     eastBtn;
    private JButton     westBtn;
    private JTextField  feedbackTxtFld;
    private JButton     fightBtn;
    private JButton     runBtn;

    public MoveRegularGuiView() throws HeadlessException {
        heading = new JLabel("Move Regular");
        northBtn = new JButton("North");
        southBtn = new JButton("South");
        eastBtn = new JButton("East");
        westBtn = new JButton("West");
        feedbackTxtFld = new JTextField();
        fightBtn = new JButton("Fight");
        runBtn = new JButton("Run");
        heading.setBounds(220, 20, 150, 20);
        northBtn.setBounds(220, 50, 100, 20);
        southBtn.setBounds(220, 130, 100, 20);
        eastBtn.setBounds(320, 90, 100, 20);
        westBtn.setBounds(100, 90, 100, 20);
        feedbackTxtFld.setBounds(150, 170, 250, 20);
        fightBtn.setBounds(150, 210, 100, 20);
        runBtn.setBounds(300, 210, 100, 20);
        add(heading);
        add(northBtn);
        add(southBtn);
        add(eastBtn);
        add(westBtn);
        add(feedbackTxtFld);
        add(fightBtn);
        add(runBtn);
        setSize(500, 600);
        setLayout(null);
        setVisible(true);
    }

    public void setFeedbackTxt(String feedback) {
        feedbackTxtFld.setText(feedback);
    }

}
