package bsu.edu.cs222;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public class Game {
    static String lastLink;
    static long timerEnd;
    static long totalTime;
    static int counter = 0;
    static int backButtonCounter = 0;

    public static long setTimeLimit(long timerStart) {

        return timerStart + 270_000;
    }

    public static void checkTimer(String link, String end, AtomicBoolean hasBackButton, long timerStart, Dimension screenSize, boolean isHardMode, long timeLimit) {
        if (System.currentTimeMillis() > timeLimit) {
            JOptionPane.showMessageDialog(null, "Unfortunately, you have run out of time. Better luck next time!");
            Main.mainMenu();
        } else {
            gameStart(link, end, hasBackButton, timerStart, screenSize, isHardMode);
        }
    }

    public static void gameStart(String link, String end, AtomicBoolean hasBackButton, long timerStart, Dimension screenSize, boolean isHardMode) {
        endCheck(link, end, timerStart, hasBackButton, isHardMode);

        layoutGenerator(link, end, screenSize, hasBackButton, timerStart, isHardMode);

    }


    private static void endCheck(String link, String end, long timerStart, AtomicBoolean hasBackButton, boolean isHardMode) {
        if (link.toLowerCase().replaceAll("_", " ").contains(end)) {
            timerEnd = System.currentTimeMillis();
            totalTime = timerEnd - timerStart;
            double seconds = totalTime / 1000.0;
            gameEnd(hasBackButton, seconds, isHardMode);
        }
    }


    private static void gameEnd(AtomicBoolean hasBackButton, double seconds, boolean isHardMode) {
        if (isHardMode) {
            JOptionPane.showMessageDialog(null, "Congrats! you beat hard mode!! \n It took " + counter + " Clicks and " + seconds + " Seconds!");
        }
        if (hasBackButton.get()) {
            JOptionPane.showMessageDialog(null, "Congrats! you did it! \n It took " + counter + " Clicks and " + seconds + " Seconds! \n You used " + backButtonCounter + " Back button press(es).");
        } else {
            JOptionPane.showMessageDialog(null, "Congrats! you did it! \n It took " + counter + " Clicks and " + seconds + " Seconds!");
        }
        System.exit(0);
    }

    private static void layoutGenerator(String link, String end, Dimension screenSize, AtomicBoolean hasBackButton, long timerStart, boolean isHardMode) {
        HyperLinkParser info = new HyperLinkParser();

        JFrame frame = new JFrame(link + "     Get to " + end);
        frame.setMinimumSize(new Dimension(screenSize.width / 2, screenSize.height / 2));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        JPanel primary = new JPanel();
        primary.setPreferredSize(screenSize);
        primary.setMinimumSize(new Dimension(screenSize.width / 2, screenSize.height / 2));

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(0, 4));

        List<String> next;
        try {
            next = info.findHyper("https://en.wikipedia.org" + link);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        backButtonCheck(hasBackButton, end, timerStart, screenSize, frame, buttonPanel, isHardMode);


        Iterator<String> iterator = next.iterator();
        while (iterator.hasNext()) {
            String hyperlink = iterator.next();
            String nextLink = iterator.next();


            JButton button = new JButton(hyperlink);
            Dimension maxButtonSize = new Dimension(frame.getWidth() / 4, frame.getHeight() / 6);
            button.setPreferredSize(maxButtonSize);

            button.addActionListener(e -> {
                counter++;
                lastLink = link;
                if (isHardMode) {
                    long timeLimit = setTimeLimit(timerStart);
                    checkTimer(nextLink, end, hasBackButton, timerStart, screenSize, true, timeLimit);
                } else {
                    gameStart(nextLink, end, hasBackButton, timerStart, screenSize, false);
                }
                frame.dispose();
            });
            buttonPanel.add(button);
        }

        JScrollPane scrollPane = new JScrollPane(buttonPanel);
        scrollPane.setAutoscrolls(true);
        scrollPane.setPreferredSize(Toolkit.getDefaultToolkit().getScreenSize());
        scrollPane.setMinimumSize(new Dimension(screenSize.width / 2, screenSize.height / 2));
        scrollPane.getVerticalScrollBar().setUnitIncrement(20);

        primary.add(scrollPane);
        frame.add(primary);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setVisible(true);
    }

    private static void backButtonCheck(AtomicBoolean hasBackButton, String end, long timerStart, Dimension screenSize, JFrame frame, JPanel buttonPanel, boolean isHardMode) {
        if (hasBackButton.get()) {
            JButton backButton = new JButton("Previous");
            backButton.setPreferredSize(new Dimension(200, 35));

            backButton.addActionListener(e -> {
                backButtonCounter++;
                gameStart(lastLink, end, hasBackButton, timerStart, screenSize, isHardMode);
                frame.dispose();
            });
            buttonPanel.add(backButton);
        }
    }
}