package com.gmail.vuyotm.swingy.view;

import javax.swing.*;
import java.awt.*;

public class FightGuiView extends JFrame {

    private JLabel      heading;
    private JTextArea   feedback;
    private JButton     physicalAttckBtn;
    private JButton     shinsooAttckBtn;
    private JButton     pickUpItemBtn;
    private JButton     leaveItemBtn;

    public FightGuiView() throws HeadlessException {
        heading = new JLabel("Fight");
        feedback = new JTextArea();
        physicalAttckBtn = new JButton("Physical Attack");
        shinsooAttckBtn = new JButton("Shinsoo Attack");
        pickUpItemBtn = new JButton("Pick Up Item");
        leaveItemBtn = new JButton("Leave Item");
        heading.setBounds(220, 20, 150, 20);
        feedback.setBounds(125, 50, 300, 50);
        physicalAttckBtn.setBounds(125, 120, 150, 20);
        shinsooAttckBtn.setBounds(300, 120, 150, 20);
        pickUpItemBtn.setBounds(125, 150, 150, 20);
        leaveItemBtn.setBounds(300, 150, 150, 20);
        feedback.setEditable(false);
        add(heading);
        add(feedback);
        add(physicalAttckBtn);
        add(shinsooAttckBtn);
        add(pickUpItemBtn);
        add(leaveItemBtn);
        setSize(500, 600);
        setLayout(null);
        setVisible(true);
    }
}
