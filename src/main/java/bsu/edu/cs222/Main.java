package bsu.edu.cs222;

import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        Game begin = new Game();

        JFrame mainMenu = new JFrame();
        mainMenu.setPreferredSize(Toolkit.getDefaultToolkit().getScreenSize());
        mainMenu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainMenu.setLayout(new BorderLayout());

        JPanel mainContents = new JPanel();
        mainContents.setLayout(new GridBagLayout());
        GridBagConstraints organizer = new GridBagConstraints();
        organizer.gridwidth = GridBagConstraints.REMAINDER;
        organizer.fill = GridBagConstraints.HORIZONTAL;

        Button initialize = new Button("Start Game!");

        TextField beginning = new TextField(20);
        TextField ending = new TextField(20);
        mainContents.add(beginning, organizer);
        mainContents.add(ending, organizer);
        mainContents.add(initialize, organizer);

        initialize.addActionListener(e -> {
            String start = beginning.getText();
            String end = ending.getText();
            String link = "/wiki/" + start;

            begin.gameStart(link, end);
        });

        mainMenu.add(mainContents);
        mainMenu.setExtendedState(JFrame.MAXIMIZED_BOTH);
        mainMenu.setVisible(true);
    }
}


