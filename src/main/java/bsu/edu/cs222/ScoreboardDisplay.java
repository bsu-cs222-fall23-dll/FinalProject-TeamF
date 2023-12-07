package bsu.edu.cs222;

import javax.swing.*;

public class ScoreboardDisplay {
    static void displayScoreboard(){
        JFrame scoreBoard = new JFrame();
        JTextArea scoreInformation = new JTextArea();
        scoreInformation.append(Scoreboard.scoreCollection());
        scoreBoard.add(scoreInformation);

        scoreBoard.setVisible(true);
    }
}
