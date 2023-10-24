package bsu.edu.cs222;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;


public class Main {

    public static void main(String[] args) {
        HyperLinkParser info = new HyperLinkParser();

        JPanel primary = new JPanel();
        primary.setPreferredSize(new Dimension(500, 200));
        primary.add(new JScrollPane());
        JTextArea text = new JTextArea();

        List<String> testSet= null;
        try {
            testSet = info.findHyper("https://en.wikipedia.org/wiki/Cat");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Iterator iterator = testSet.iterator();
        while (iterator.hasNext()){
            text.append(iterator.next().toString() + "\n");
        }

        JScrollPane append = new JScrollPane(text);
        primary.add(append);

        JOptionPane.showMessageDialog(null, primary);
    }
}


