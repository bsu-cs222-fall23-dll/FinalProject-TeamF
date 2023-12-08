package bsu.edu.cs222;

import org.junit.Test;
import javax.swing.*;
import java.awt.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MiniMainButtonTest extends MiniMain{

    @Test
    public void tutorialButtonTest(){
        JPanel testPanel = new JPanel();
        GridBagConstraints testGrid = new GridBagConstraints();
        JFrame testMainFrame = new JFrame();
        MiniMain.tutorialButton(testPanel, testGrid, testMainFrame);
        assertEquals(1, testPanel.getComponentCount());
        Component component = testPanel.getComponent(0);
        assertTrue(component instanceof JButton);
        JButton button = (JButton) component;
        assertEquals("Tutorial", button.getText());
        assertEquals(new Dimension(200, 30), button.getMaximumSize());
    }

    @Test
    public void testPlayButton() {
        JPanel testPanel = new JPanel();
        GridBagConstraints testGrid = new GridBagConstraints();
        JFrame testMainFrame = new JFrame();
        MiniMain.playButton(testPanel, testGrid, testMainFrame);
        assertEquals(1, testPanel.getComponentCount());
        Component component = testPanel.getComponent(0);
        assertTrue(component instanceof JButton);
        JButton button = (JButton) component;
        assertEquals("Play", button.getText());
        assertEquals(new Dimension(100, 50), button.getMaximumSize());
    }

    @Test
    public void testScoreBoardButton() {
        JPanel testPanel = new JPanel();
        GridBagConstraints testGrid = new GridBagConstraints();
        JFrame testMainFrame = new JFrame();
        MiniMain.scoreBoardButton(testPanel, testGrid, testMainFrame);
        assertEquals(1, testPanel.getComponentCount());
        Component component = testPanel.getComponent(0);
        assertTrue(component instanceof JButton);
        JButton button = (JButton) component;
        assertEquals("Score Board", button.getText());
        assertEquals(new Dimension(100, 50), button.getMaximumSize());
    }
}
