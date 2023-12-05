package bsu.edu.cs222;

import javax.swing.*;
import java.awt.*;

public class MiniMain {
    public static void miniMain() {
        JFrame miniMain = new JFrame("The Wikipedia Game");
        miniMain.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        miniMain.setSize(new Dimension(Toolkit.getDefaultToolkit().getScreenSize().width/2, Toolkit.getDefaultToolkit().getScreenSize().height/2 ));
        miniMain.setLayout(new BorderLayout());

        JLabel titleLabel = new JLabel("WIKIPEDIA GAME");
        titleLabel.setFont(new Font("Gabriola", Font.PLAIN, 40));
        titleLabel.setForeground(new Color(51, 204, 255));
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
            Tutorial.tutorialStart();
            miniMain.setVisible(false);
        });

        grid.gridy++;
        JButton button3 = new JButton("Play");
        button3.setMaximumSize(new Dimension(100, 50));
        buttonsPanel.add(button3, grid);
        button3.addActionListener(e -> {
            GameCustomization.mainMenu();
            miniMain.setVisible(false);
        });

        grid.gridy++;
        JButton button4 = new JButton("Score Board");
        button4.setMaximumSize(new Dimension(100, 50));
        buttonsPanel.add(button4, grid);
        button4.addActionListener(e -> {
            ScorboardDisplay.displayScoreboard();
            miniMain.setVisible(false);
        });

        miniMain.getContentPane().setBackground(Color.DARK_GRAY);
        miniMain.add(buttonsPanel, BorderLayout.CENTER);
        miniMain.setLocationRelativeTo(null);
        miniMain.setVisible(true);
    }
}
