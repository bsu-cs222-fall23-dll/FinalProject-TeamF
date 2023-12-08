package bsu.edu.cs222;

import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.concurrent.atomic.AtomicBoolean;

public class GameCustomization {
    public static void mainMenu() {
        AtomicBoolean hasBackButton = new AtomicBoolean(false);
        AtomicBoolean isHardMode = new AtomicBoolean(false);

        JFrame mainMenu = new JFrame();
        JPanel mainContents = new JPanel();
        JPanel modeButtonPanel = new JPanel();

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        mainMenu.setMinimumSize(new Dimension(screenSize.width / 2, screenSize.height / 2));
        mainMenu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        GridBagConstraints grid = new GridBagConstraints();
        grid.gridx = 0;
        grid.gridy = 0;
        grid.insets = new Insets(10, 10, 10, 10);

        TextField beginning = new TextField(20);
        beginning.setText("Enter your starting link:");
        mainContents.add(beginning);

        TextField ending = new TextField(20);
        ending.setText("Enter your ending link:");
        mainContents.add(ending);

        startButton(mainMenu, mainContents, grid, beginning, ending, hasBackButton, isHardMode, screenSize);
        backButton(grid, modeButtonPanel, hasBackButton);
        hardModeButton(mainMenu, modeButtonPanel, grid, beginning, ending, hasBackButton, isHardMode, screenSize);
        questionButton(modeButtonPanel, grid);
        randomButton(mainMenu, modeButtonPanel, grid, hasBackButton, isHardMode, screenSize);


        mainMenu.add(mainContents, BorderLayout.NORTH);
        mainMenu.add(modeButtonPanel, BorderLayout.CENTER);
        mainMenu.setLocationRelativeTo(null);
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
                if (beginning.getText().isEmpty()) {
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
                if (ending.getText().isEmpty()) {
                    ending.setText("Enter your ending link:");
                }
            }
        });

    }

    public static void startButton(JFrame mainMenu, JPanel mainContents, GridBagConstraints grid, TextField beginning, TextField ending, AtomicBoolean hasBackButton, AtomicBoolean isHardMode, Dimension screenSize) {
        grid.gridy++;
        Button initialize = new Button("Start Game!");
        initialize.setMaximumSize(new Dimension(200, 30));
        mainContents.add(initialize, grid);
        initialize.addActionListener(e -> {
            String startingLink = beginning.getText();
            String endingLink = ending.getText();
            if (startingLink.equals("Enter your starting link:") || endingLink.equals("Enter your ending link:")) {
                JOptionPane.showMessageDialog(null, "No input, restarting!");
                mainMenu.dispose();
                mainMenu();
            } else {
                String link = "/wiki/" + startingLink;
                long timerStart = System.currentTimeMillis();

                Game.gameStart(link, endingLink, hasBackButton, timerStart, screenSize, isHardMode.get());
                mainMenu.dispose();
            }
        });
    }

    public static void backButton(GridBagConstraints grid, JPanel modeButtonPanel, AtomicBoolean hasBackButton) {
        grid.gridy++;
        JButton backButton = new JButton("Back Button?");
        backButton.setMaximumSize(new Dimension(200, 30));
        modeButtonPanel.add(backButton, grid);
        backButton.addActionListener(e -> {
            hasBackButton.set(true);
            //noinspection deprecation
            backButton.setLabel("Back button enabled.");
        });
    }

    public static void hardModeButton(JFrame mainMenu, JPanel modeButtonPanel, GridBagConstraints grid, TextField beginning, TextField ending, AtomicBoolean hasBackButton, AtomicBoolean isHardMode, Dimension screenSize) {
        grid.gridy++;
        JButton hardModeButton = new JButton("Hard Mode");
        hardModeButton.setMaximumSize(new Dimension(200, 30));
        modeButtonPanel.add(hardModeButton, grid);
        hardModeButton.addActionListener(e -> {
            String startingLink = beginning.getText();
            String endingLink = ending.getText();
            if (startingLink.equals("Enter your starting link:") || endingLink.equals("Enter your ending link:")) {
                JOptionPane.showMessageDialog(null, "No input, restarting!");
                mainMenu.dispose();
                mainMenu();
            } else {
                String link = "/wiki/" + startingLink;
                long timerStart = System.currentTimeMillis();
                long timeLimit = Game.setTimeLimit(timerStart);
                mainMenu.dispose();
                Game.checkTimer(link, endingLink, hasBackButton, timerStart, screenSize, isHardMode.get(), timeLimit);
            }
        });
    }

    public static void questionButton(JPanel modeButtonPanel, GridBagConstraints grid){
        grid.gridy++;
        JButton backButton = new JButton("?");
        modeButtonPanel.add(backButton, grid);
        backButton.addActionListener(e -> JOptionPane.showMessageDialog(null, "Hard mode rules: \n No back button \n 4:30 timer"));
    }

    public static void randomButton(JFrame mainMenu, JPanel modeButtonPanel, GridBagConstraints grid, AtomicBoolean hasBackButton, AtomicBoolean isHardMode, Dimension screenSize) {
        grid.gridy++;
        JButton randomButton = new JButton("Random");
        randomButton.setMaximumSize(new Dimension(200, 30));
        modeButtonPanel.add(randomButton, grid);
        randomButton.addActionListener(e -> {
            String start = "Special:Random";
            String end = "Special:Random";
            String startLink = "https://en.wikipedia.org/wiki/" + start;
            String endLink = "https://en.wikipedia.org/wiki/" + end;
            HyperLinkParser hyperLinkParser = new HyperLinkParser();
            startLink = hyperLinkParser.findFinalRedirect(startLink);
            endLink = hyperLinkParser.findFinalRedirect(endLink);
            startLink = startLink.replace("https://en.wikipedia.org", "");
            endLink = endLink.replace("https://en.wikipedia.org", "");

            long timerStart = System.currentTimeMillis();

            Game.gameStart(startLink, endLink, hasBackButton, timerStart, screenSize, isHardMode.get());
            mainMenu.dispose();
        });
    }
}


