package bsu.edu.cs222;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

public class Main {
    static String end;
    static int counter = 0;
    static int backButtonCounter = 0;
    static long timerStart;
    static long timerEnd;
    static long totalTime;

    static String lastLink;

    public static void main(String[] args) {
        String start = JOptionPane.showInputDialog(null, "What Wiki page would you like to start out with?");
        end = JOptionPane.showInputDialog(null, "What Wiki page would you like to end with?");
        timerStart = System.currentTimeMillis();
        lastLink = start;
        continuing("/wiki/" + start);
    }

    public static void continuing(String link){

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
            continuing(lastLink);
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
                continuing(nextLink);
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


