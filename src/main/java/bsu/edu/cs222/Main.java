package bsu.edu.cs222;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;


public class Main {

    public static void main(String[] args) {
        HyperLinkParser info = new HyperLinkParser();

        JFrame frame = new JFrame("Hyperlinks");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        JPanel primary = new JPanel();
        primary.setPreferredSize(Toolkit.getDefaultToolkit().getScreenSize());

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(0, 8));


        List<String> Set = null;
        try {
            Set = info.findHyper("https://en.wikipedia.org/wiki/Cat");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        Iterator<String> iterator = Set.iterator();
        while (iterator.hasNext()) {
            String hyperlink = iterator.next();
            String link = iterator.next();

            JButton button = new JButton(hyperlink);
            Dimension maxButtonSize = new Dimension(100, 20);
            button.setPreferredSize(maxButtonSize);

            button.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    continuing(link);
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

    public static void continuing(String link){
        HyperLinkParser info = new HyperLinkParser();

        JFrame frame = new JFrame(link);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        JPanel primary = new JPanel();
        primary.setPreferredSize(Toolkit.getDefaultToolkit().getScreenSize());

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(0, 8));

        List<String> next= null;
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


