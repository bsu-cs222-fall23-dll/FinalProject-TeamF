package bsu.edu.cs222;

import javax.swing.*;
import java.awt.*;

public class ScoreboardDisplay {
    static void displayScoreboard(){
        JFrame scoreBoard = new JFrame();
        JTextArea scoreInformation = new JTextArea();

        String info = Scoreboard.scoreCollection();

        if(info.equals("[]")){
            scoreInformation.append("No stats available!");
        }else{
            scoreInformation.append(info);
        }

        scoreBoard.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        scoreBoard.setSize(new Dimension(Toolkit.getDefaultToolkit().getScreenSize().width/2, Toolkit.getDefaultToolkit().getScreenSize().height/2 ));

        JPanel buttonsPanel = new JPanel(new GridBagLayout());

        GridBagConstraints grid = new GridBagConstraints();
        grid.gridx = 0;
        grid.gridy = 0;
        grid.insets = new Insets(10, 0, 10, 0);

        exitButton(buttonsPanel, grid, scoreBoard);


        scoreBoard.add(scoreInformation, BorderLayout.NORTH);
        scoreBoard.add(buttonsPanel, BorderLayout.CENTER);
        scoreBoard.setVisible(true);
    }

    public static void exitButton(JPanel buttonsPanel, GridBagConstraints grid, Frame scoreBoard){
        grid.gridy++;
        JButton button1 = new JButton("Back");
        button1.setMaximumSize(new Dimension(100, 50));
        buttonsPanel.add(button1, grid);
        button1.addActionListener(e -> {
            scoreBoard.setVisible(false);
            MiniMain.miniMain();
        });
    }
}


