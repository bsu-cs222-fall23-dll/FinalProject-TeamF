package bsu.edu.cs222;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

public class Game {
    static long timerStart;
    static String lastLink;
    static long timerEnd;
    static long totalTime;
    static int counter = 0;
    static int backButtonCounter = 0;

    public static void gameStart(String link, String end){

        if (link.contains(end)){
            timerEnd = System.currentTimeMillis();
            totalTime = timerEnd - timerStart;
            double seconds = totalTime/1000.0;
            JOptionPane.showMessageDialog(null,"Congrats! you did it! \n It took " + counter + " Clicks and " +seconds + " Seconds! \n You used " + backButtonCounter + " Back button press(es).");
            System.exit(0);
        }

        HyperLinkParser info = new HyperLinkParser();

        JFrame frame = new JFrame(link + "     Get to " + end);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        JPanel primary = new JPanel();
        primary.setPreferredSize(Toolkit.getDefaultToolkit().getScreenSize());

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(0, 4));

        List<String> next;
        try {
            next = info.findHyper("https://en.wikipedia.org" + link);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        JButton backButton = new JButton("Previous");
        backButton.setPreferredSize(new Dimension(200,35));

        backButton.addActionListener(e -> {
            backButtonCounter++;
            gameStart(lastLink, end);
            frame.dispose();
        });
        buttonPanel.add(backButton);

        Iterator<String> iterator = next.iterator();
        while (iterator.hasNext()) {
            String hyperlink = iterator.next();
            String nextLink = iterator.next();


            JButton button = new JButton(hyperlink);
            Dimension maxButtonSize = new Dimension(200, 35);
            button.setPreferredSize(maxButtonSize);

            button.addActionListener(e -> {
                counter++;
                lastLink = link;
                gameStart(nextLink, end);
                frame.dispose();
            });
            buttonPanel.add(button);
        }

        JScrollPane scrollPane = new JScrollPane(buttonPanel);
        scrollPane.setAutoscrolls(true);
        scrollPane.setPreferredSize(Toolkit.getDefaultToolkit().getScreenSize());
        scrollPane.getVerticalScrollBar().setUnitIncrement(20);

        primary.add(scrollPane);
        frame.add(primary);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setVisible(true);
    }
}
