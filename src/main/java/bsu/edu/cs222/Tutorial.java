package bsu.edu.cs222;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

public class Tutorial {
    static void tutorialStart() {
        HyperLinkParser info = new HyperLinkParser();
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

        JFrame frame = new JFrame("Starting at Cat, get to Scotland");
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
            next = info.findHyper("https://en.wikipedia.org/wiki/Cat");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        Iterator<String> iterator = next.iterator();
        while (iterator.hasNext()) {
            String hyperlink = iterator.next();
            String nextLink = iterator.next();


            JButton button = new JButton(hyperlink);
            Dimension maxButtonSize = new Dimension(frame.getWidth() / 4, frame.getHeight() / 6);
            button.setPreferredSize(maxButtonSize);

            button.addActionListener(e -> {
                if (nextLink.contains("Scotland")){
                    JOptionPane.showMessageDialog(null, "While this is a smaller scale version of the game \n its merely an example of how to navigate and explain th basics \n In the real game you will select your own link, choose new settings, and customize your experience!");
                    JOptionPane.showMessageDialog(null,"Congratulations! You beat the tutorial. \n Explore the other settings and features to build your skill and learn about the game! \n Returning you to the main menu!");
                    frame.setVisible(false);
                    Main.miniMain();
                } else {
                    JOptionPane.showMessageDialog(null, "That's not the proper ending link, please find Scotland!");
                }
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

        JOptionPane.showMessageDialog(null, "Welcome to the WIKIPEDIA GAME, where your goal is to hop from link button to link button trying to find an ending link. \n In this example, we have selected the starting link Cat and your goal is to find the button Labeled Scotland.");
    }
}