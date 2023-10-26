package bsu.edu.cs222;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

public class Main {
    static String end;
    static int counter = 0;
    static long timerStart;
    static long timerEnd;
    static long totalTime;

    public static void main(String[] args) {
        String start = JOptionPane.showInputDialog(null, "What Wiki page would you like to start out with?");
        end = JOptionPane.showInputDialog(null, "What Wiki page would you like to end with?");
        timerStart = System.currentTimeMillis();
        continuing("/wiki/" + start);
    }

    public static void continuing(String link){
        if (link.contains(end)){
            timerEnd = System.currentTimeMillis();
            totalTime = timerEnd - timerStart;
            double seconds = totalTime/1000.0;
            JOptionPane.showMessageDialog(null,"Congrats! you did it! \n It took " + counter + " Clicks and " +seconds + " Seconds!");
            System.exit(0);
        }

        HyperLinkParser info = new HyperLinkParser();

        JFrame frame = new JFrame(link + "     Get to " + end);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        JPanel primary = new JPanel();
        primary.setPreferredSize(Toolkit.getDefaultToolkit().getScreenSize());

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(0, 8));

        List<String> next = null;
        try {
            next = info.findHyper("https://en.wikipedia.org" + link);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        Iterator<String> iterator = next.iterator();
        while (iterator.hasNext()) {
            String hyperlink = iterator.next();
            String nextLink = iterator.next();

            JButton button = new JButton(hyperlink);
            Dimension maxButtonSize = new Dimension(100, 20);
            button.setPreferredSize(maxButtonSize);

            button.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    counter++;
                    continuing(nextLink);
                    frame.dispose();

                }
            });
            buttonPanel.add(button);
        }

        JScrollPane scrollPane = new JScrollPane(buttonPanel);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        primary.add(scrollPane);
        frame.add(primary);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setVisible(true);
    }
}


