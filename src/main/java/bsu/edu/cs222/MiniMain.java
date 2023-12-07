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

        optionsButton(buttonsPanel, grid);
        tutorialButton(buttonsPanel, grid, miniMain);
        playButton(buttonsPanel, grid, miniMain);
        scoreBoardButton(buttonsPanel, grid, miniMain);

        miniMain.getContentPane().setBackground(Color.DARK_GRAY);
        miniMain.add(buttonsPanel, BorderLayout.CENTER);
        miniMain.setLocationRelativeTo(null);
        miniMain.setVisible(true);
    }

    public static void optionsButton(JPanel buttonsPanel, GridBagConstraints grid){
        JButton optionsButton = new JButton("Options");
        optionsButton.setMaximumSize(new Dimension(100, 50));
        optionsButton.addActionListener(e -> {

        });
        buttonsPanel.add(optionsButton, grid);
    }

    public static void tutorialButton(JPanel buttonsPanel, GridBagConstraints grid, JFrame miniMain){
        grid.gridy++;
        JButton tutorialButton = new JButton("Tutorial");
        tutorialButton.setMaximumSize(new Dimension(200, 30));
        buttonsPanel.add(tutorialButton, grid);
        tutorialButton.addActionListener(e -> {
            Tutorial.tutorialStart();
            miniMain.setVisible(false);
        });
    }

    public static void playButton(JPanel buttonsPanel, GridBagConstraints grid, JFrame miniMain){
        grid.gridy++;
        JButton playButton = new JButton("Play");
        playButton.setMaximumSize(new Dimension(100, 50));
        buttonsPanel.add(playButton, grid);
        playButton.addActionListener(e -> {
            GameCustomization.mainMenu();
            miniMain.setVisible(false);
        });
    }

    public static void scoreBoardButton(JPanel buttonsPanel, GridBagConstraints grid, JFrame miniMain){
        grid.gridy++;
        JButton scoreBoardButton = new JButton("Score Board");
        scoreBoardButton.setMaximumSize(new Dimension(100, 50));
        buttonsPanel.add(scoreBoardButton, grid);
        scoreBoardButton.addActionListener(e -> {
            ScoreboardDisplay.displayScoreboard();
            miniMain.setVisible(false);
        });
    }
}
