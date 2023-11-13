package bsu.edu.cs222;

import javax.swing.*;
import java.awt.*;
import java.util.concurrent.atomic.AtomicBoolean;

public class Main {
    public static void main(String[] args) {
        AtomicBoolean hasBackButton = new AtomicBoolean(false);
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
        Button setBackButton = new Button("Back button?");
        Button hardMode = new Button("Hard mode! (30 sec time limit, no back button)");

        TextField beginning = new TextField(20);
        TextField ending = new TextField(20);
        mainContents.add(beginning, organizer);
        mainContents.add(ending, organizer);
        mainContents.add(initialize, organizer);
        mainContents.add(setBackButton, organizer);
        mainContents.add(hardMode, organizer);

        initialize.addActionListener(e -> {
            String start = beginning.getText();
            String end = ending.getText();
            String link = "/wiki/" + start;
            long timerStart = System.currentTimeMillis();

            Game.gameStart(link, end, hasBackButton, timerStart);
        });

        setBackButton.addActionListener(e -> {hasBackButton.set(true);
        setBackButton.setLabel("Back button enabled.");});

        hardMode.addActionListener(e -> {
            String start = beginning.getText();
            String end = ending.getText();
            String link = "/wiki/" + start;
            long timerStart = System.currentTimeMillis();

            Game.hardModeGameStart(link, end, timerStart);
        });

        mainMenu.add(mainContents);
        mainMenu.setExtendedState(JFrame.MAXIMIZED_BOTH);
        mainMenu.setVisible(true);
    }
}


