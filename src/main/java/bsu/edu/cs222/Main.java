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
        buttonPanel.setLayout(new GridLayout(0, 4));

        List<String> Set= null;
        try {
            Set = info.findHyper("https://en.wikipedia.org/wiki/Cat");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Iterator<String> iterator = Set.iterator();
        while (iterator.hasNext()) {
            String hyperlink = iterator.next();
            JButton button = new JButton(hyperlink);
            button.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {

                }
            });
            buttonPanel.add(button);
        }
        buttonPanel.setMaximumSize(new Dimension(Integer.MAX_VALUE, Integer.MAX_VALUE));
        JScrollPane scrollPane = new JScrollPane(buttonPanel);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        primary.add(scrollPane);
        frame.add(primary);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setVisible(true);
    }
}


