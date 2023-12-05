package bsu.edu.cs222;

import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.atomic.AtomicBoolean;

public class GameCustomization {
    public static void mainMenu() {
        AtomicBoolean hasBackButton = new AtomicBoolean(false);
        AtomicBoolean isHardMode = new AtomicBoolean(false);

        Random rand = new Random(System.currentTimeMillis());

        JFrame mainMenu = new JFrame();
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        mainMenu.setPreferredSize(screenSize);
        mainMenu.setMinimumSize(new Dimension(screenSize.width/3, screenSize.height/3));
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
        Button randomMode = new Button("Random pages");

        Dimension buttonSize = new Dimension(300, 30);
        Dimension question = new Dimension(20, 30);
        setBackButton.setMaximumSize(buttonSize);
        hardMode.setMaximumSize(buttonSize);
        hardModeInfo.setMaximumSize(question);
        randomMode.setMaximumSize(buttonSize);

        JPanel hardModePanel = new JPanel();
        hardModePanel.add(hardMode);
        hardModePanel.add(hardModeInfo);
        hardModePanel.add(randomMode);

        verticalPanel.add(Box.createVerticalStrut(10));
        verticalPanel.add(setBackButton);
        verticalPanel.add(hardModePanel);


        hardModeInfo.addActionListener(e ->
                JOptionPane.showMessageDialog(null, "Hard mode rules: \n No back button \n 4:30 timer"));

        randomMode.addActionListener(e -> {
            String start = "Special:Random";
            String end = "Special:Random";
            String startLink = "https://en.wikipedia.org/wiki/" + start;
            String endLink = "https://en.wikipedia.org/wiki/" + end;
            HyperLinkParser hyperLinkParser = new HyperLinkParser();
            startLink = hyperLinkParser.findFinalRedirect(startLink);
            endLink = hyperLinkParser.findFinalRedirect(endLink);
            startLink =  startLink.replace("https://en.wikipedia.org","");
            endLink =  endLink.replace("https://en.wikipedia.org","");

            long timerStart = System.currentTimeMillis();

            Game.gameStart(startLink, endLink, hasBackButton, timerStart, screenSize, isHardMode.get());
        });

        initialize.addActionListener(e -> {
            String start = beginning.getText();
            String end = ending.getText();

            if (start.equals("Enter your starting link:") || end.equals("Enter your ending link:")){
                JOptionPane.showMessageDialog(null, "No input, restarting!");
                mainMenu.dispose();
                mainMenu();
            }else {
                String link = "/wiki/" + start;
                long timerStart = System.currentTimeMillis();

                Game.gameStart(link, end, hasBackButton, timerStart, screenSize, isHardMode.get());
            }
        });

        setBackButton.addActionListener(e -> {
            hasBackButton.set(true);
            setBackButton.setLabel("Back button enabled.");
        });

        hardMode.addActionListener(e -> {

            String start = beginning.getText();
            String end = ending.getText();
            if (start.equals("Enter your starting link:") || end.equals("Enter your ending link:")){
                JOptionPane.showMessageDialog(null, "No input, restarting!");
                mainMenu.dispose();
                mainMenu();
            }else {
                String link = "/wiki/" + start;
                long timerStart = System.currentTimeMillis();
                long timeLimit = Game.setTimeLimit(timerStart);
                Game.checkTimer(link,end,hasBackButton,timerStart,screenSize,isHardMode.get(), timeLimit);
            }
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
                if (beginning.getText().isEmpty()){
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
                if (ending.getText().isEmpty()){
                    ending.setText("Enter your ending link:");
                }
            }
        });

    }
}


