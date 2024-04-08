package com.immunewars.game.startMenu;

import javax.swing.*;
import java.awt.event.*;

public class startMenu extends JFrame {

    public startMenu() {
        setTitle("Start Screen");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(true);

        // Set background image
        ImageIcon backgroundImage = new ImageIcon("C:\\Users\\kaano\\OneDrive\\Masaüstü\\CS102-ImmuneWars\\ImmuneWars\\core\\src\\com\\immunewars\\game\\startMenu\\background.png");
        JLabel backgroundLabel = new JLabel(backgroundImage);
        setContentPane(backgroundLabel);
        setLayout(null); // Absolute layout

        // Create start button
        JButton startButton = new JButton("Start");
        startButton.setBounds(300, 300, 200, 50);
        startButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Add code to start the game or application
                JOptionPane.showMessageDialog(null, "Starting...");
            }
        });
        add(startButton);

        // Create settings button that is invisible lies on settings letters
        JButton settingsButton = new JButton("Settings");
        settingsButton.setBounds(300, 400, 200, 50);
        settingsButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Add code to open settings
                JOptionPane.showMessageDialog(null, "Opening settings...");
            }


        });
        add(settingsButton);

        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new startMenu();
            }
        });
    }
}