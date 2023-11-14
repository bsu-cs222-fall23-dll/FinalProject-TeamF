package bsu.edu.cs222;

import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.concurrent.atomic.AtomicBoolean;

public class Main {
    public static void main(String[] args) {
        mainMenu();
    }
    public static void mainMenu() {
        AtomicBoolean hasBackButton = new AtomicBoolean(false);
        Game begin = new Game();

        JFrame mainMenu = new JFrame();
        mainMenu.setPreferredSize(Toolkit.getDefaultToolkit().getScreenSize());
        mainMenu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainMenu.setLayout(new BorderLayout());

        JPanel mainContents = new JPanel();
        mainContents.setLayout(new GridLayout(2, 1));

        JPanel horizontalPanel = new JPanel(new FlowLayout());
        Button initialize = new Button("Start Game!");
        TextField beginning = new TextField(20);
        TextField ending = new TextField(20);
        beginning.setText("Enter your starting link:");
        ending.setText("Enter your ending link:");
        horizontalPanel.add(beginning);
        horizontalPanel.add(ending);
        horizontalPanel.add(initialize);



        JPanel verticalPanel = new JPanel();
        verticalPanel.setLayout(new BoxLayout(verticalPanel, BoxLayout.Y_AXIS));
        Button setBackButton = new Button("Back button?");
        Button hardMode = new Button("Hard mode!");
        Button hardModeInfo = new Button("?");

        Dimension buttonSize = new Dimension(100, 30);
        Dimension question = new Dimension(20, 30);
        setBackButton.setMaximumSize(buttonSize);
        hardMode.setMaximumSize(buttonSize);
        hardModeInfo.setMaximumSize(question);

        JPanel hardModePanel = new JPanel();
        hardModePanel.add(hardMode);
        hardModePanel.add(hardModeInfo);

        verticalPanel.add(Box.createVerticalStrut(10));
        verticalPanel.add(setBackButton);
        verticalPanel.add(hardModePanel);

        initialize.addActionListener(e -> {
            String start = beginning.getText();
            String end = ending.getText();
            String link = "/wiki/" + start;
            long timerStart = System.currentTimeMillis();

            Game.gameStart(link, end, hasBackButton, timerStart);
        });

        setBackButton.addActionListener(e -> {
            hasBackButton.set(true);
            setBackButton.setLabel("Back button enabled.");
        });

        hardMode.addActionListener(e -> {
            String start = beginning.getText();
            String end = ending.getText();
            String link = "/wiki/" + start;
            long timerStart = System.currentTimeMillis();

            Game.hardModeGameStart(link, end, timerStart);
        });

        mainContents.add(horizontalPanel);
        mainContents.add(verticalPanel);

        mainMenu.add(mainContents);
        mainMenu.setExtendedState(JFrame.MAXIMIZED_BOTH);
        mainMenu.setVisible(true);

        beginning.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (beginning.getText().equals("Enter your starting link:")) {
                    beginning.setText("");
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (beginning.getText().equals("")){
                    beginning.setText("Enter your starting link:");
                }
            }
        });

        ending.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (ending.getText().equals("Enter your ending link:")) {
                    ending.setText("");
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (ending.getText().equals("")){
                    ending.setText("Enter your ending link:");
                }
            }
        });

    }
}


