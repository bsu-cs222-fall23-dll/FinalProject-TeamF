package bsu.edu.cs222;

import org.junit.Test;

import javax.swing.*;
import java.awt.*;
import java.util.concurrent.atomic.AtomicBoolean;

import static org.junit.jupiter.api.Assertions.*;

public class GameCustomizationButtonsTest extends GameCustomization{
    @Test
    public void testHardModeButton() {
        JFrame testFrame = new JFrame();
        JPanel testPanel = new JPanel();
        GridBagConstraints testGrid = new GridBagConstraints();
        TextField testBeginning = new TextField();
        TextField testEnding = new TextField();
        AtomicBoolean testHasBackButton = new AtomicBoolean(false);
        AtomicBoolean testIsHardMode = new AtomicBoolean(false);
        Dimension testScreenSize = new Dimension(800, 600);
        GameCustomization.hardModeButton(testFrame, testPanel, testGrid, testBeginning, testEnding, testHasBackButton, testIsHardMode, testScreenSize);
        assertEquals(1, testPanel.getComponentCount());
        Component component = testPanel.getComponent(0);
        assertTrue(component instanceof JButton);
        JButton button = (JButton) component;
        assertEquals("Hard Mode", button.getText());
        assertEquals(new Dimension(200, 30), button.getMaximumSize());
    }

    @Test
    public void testBackButton() {
        JPanel testPanel = new JPanel();
        GridBagConstraints testGrid = new GridBagConstraints();
        AtomicBoolean testHasBackButton = new AtomicBoolean(false);
        GameCustomization.backButton(testGrid, testPanel, testHasBackButton);
        assertEquals(1, testPanel.getComponentCount());
        Component component = testPanel.getComponent(0);
        assertTrue(component instanceof JButton);
        JButton button = (JButton) component;
        assertEquals("Back Button?", button.getText());
        assertEquals(new Dimension(200, 30), button.getMaximumSize());
        assertFalse(testHasBackButton.get());
        button.doClick();
        assertTrue(testHasBackButton.get());
        assertEquals("Back button enabled.", button.getText());
    }

    @Test
    public void testQuestionButton() {
        JPanel testPanel = new JPanel();
        GridBagConstraints testGrid = new GridBagConstraints();
        GameCustomization.questionButton(testPanel, testGrid);
        assertEquals(1, testPanel.getComponentCount());
        Component component = testPanel.getComponent(0);
        assertTrue(component instanceof JButton);
        JButton button = (JButton) component;
        assertEquals("?", button.getText());
        assertEquals(new Dimension(41, 26), button.getMaximumSize());
    }

    @Test
    public void testRandomButton() {
        JFrame testFrame = new JFrame();
        JPanel testPanel = new JPanel();
        GridBagConstraints testGrid = new GridBagConstraints();
        AtomicBoolean testHasBackButton = new AtomicBoolean(false);
        AtomicBoolean testIsHardMode = new AtomicBoolean(false);
        Dimension testScreenSize = new Dimension(800, 600);
        GameCustomization.randomButton(testFrame, testPanel, testGrid, testHasBackButton, testIsHardMode, testScreenSize);
        assertEquals(1, testPanel.getComponentCount());
        Component component = testPanel.getComponent(0);
        assertTrue(component instanceof JButton);
        JButton button = (JButton) component;
        assertEquals("Random", button.getText());
        assertEquals(new Dimension(200, 30), button.getMaximumSize());
    }

    @Test
    public void testStartButton() {
        JFrame testFrame = new JFrame();
        JPanel testPanel = new JPanel();
        GridBagConstraints testGrid = new GridBagConstraints();
        TextField testBeginning = new TextField();
        TextField testEnding = new TextField();
        AtomicBoolean testHasBackButton = new AtomicBoolean(false);
        AtomicBoolean testIsHardMode = new AtomicBoolean(false);
        Dimension testScreenSize = new Dimension(800, 600);
        GameCustomization.startButton(testFrame, testPanel, testGrid, testBeginning, testEnding, testHasBackButton, testIsHardMode, testScreenSize);
        assertEquals(1, testPanel.getComponentCount());
        Component component = testPanel.getComponent(0);
        assertTrue(component instanceof Button);
        Button button = (Button) component;
        assertEquals("Start Game!", button.getLabel());
        assertEquals(new Dimension(200, 30), button.getMaximumSize());
    }

}
