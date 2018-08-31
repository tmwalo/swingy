package com.gmail.vuyotm.swingy.view;

import javax.swing.*;
import java.awt.*;

public class StatsAndArtifactsGuiView extends JFrame {

    private JLabel      statsAndEquipmentHeading;
    private JLabel      statsHeading;
    private JTextArea   stats;
    private JLabel      equipmentHeading;
    private JTextArea   equipment;
    private JButton     backBtn;

    public StatsAndArtifactsGuiView() throws HeadlessException {
        statsAndEquipmentHeading = new JLabel("Stats and Equipment");
        statsHeading = new JLabel("Stats:");
        stats = new JTextArea();
        equipmentHeading = new JLabel("Equipment:");
        equipment = new JTextArea();
        backBtn = new JButton("Back");
        stats.setEditable(false);
        equipment.setEditable(false);
        statsAndEquipmentHeading.setBounds(220, 20, 200, 20);
        statsHeading.setBounds(100, 50, 100, 20);
        stats.setBounds(100, 80, 200, 200);
        equipmentHeading.setBounds(100, 300, 100, 20);
        equipment.setBounds(100, 330, 200, 100);
        backBtn.setBounds(100, 450, 100, 20);
        add(statsAndEquipmentHeading);
        add(statsHeading);
        add(stats);
        add(equipmentHeading);
        add(equipment);
        add(backBtn);
        setSize(500, 600);
        setLayout(null);
        setVisible(true);
    }

}
