package bsu.edu.cs222;

import javax.swing.*;
import java.awt.*;

public class Main extends JPanel {

    public static void main(String[] args) {
        JFrame miniMain = new JFrame("The Wikipedia Game");
        miniMain.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        miniMain.setSize(400, 300);
        miniMain.setLayout(new BorderLayout());

        JLabel titleLabel = new JLabel("WIKIPEDIA GAME");
        titleLabel.setFont(new Font("Linux Libertine", Font.PLAIN, 23));
        titleLabel.setForeground(Color.BLUE);
        titleLabel.setHorizontalAlignment(JLabel.CENTER);

        miniMain.add(titleLabel, BorderLayout.NORTH);
        JPanel buttonsPanel = new JPanel(new GridBagLayout());

        GridBagConstraints grid = new GridBagConstraints();
        grid.gridx = 0;
        grid.gridy = 0;
        grid.insets = new Insets(10, 0, 10, 0);

        JButton button1 = new JButton("Options");
        button1.setMaximumSize(new Dimension(100, 50));
        buttonsPanel.add(button1, grid);
        button1.addActionListener(e -> {

        });

        grid.gridy++;
        JButton button2 = new JButton("Help");
        button2.setMaximumSize(new Dimension(200, 30));
        buttonsPanel.add(button2, grid);
        button2.addActionListener(e -> {

        });

        grid.gridy++;
        JButton button3 = new JButton("Play");
        button3.setMaximumSize(new Dimension(100, 50));
        buttonsPanel.add(button3, grid);
        button3.addActionListener(e -> StartScreen.mainMenu());

        miniMain.getContentPane().setBackground(Color.DARK_GRAY);
        miniMain.add(buttonsPanel, BorderLayout.CENTER);
        miniMain.setLocationRelativeTo(null);
        miniMain.setVisible(true);
    }
}