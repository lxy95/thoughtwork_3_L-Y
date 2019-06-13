package ui;

import javax.swing.*;
import java.awt.*;

public class GOLFrame extends JFrame {
    private static final Dimension DEFAULT_WINDOW_SIZE = new Dimension(1000, 600);
    private static final Dimension MINIMUM_WINDOW_SIZE = new Dimension(300, 300);

    JSplitPane splitPane = new JSplitPane();

    public GOLFrame() {

        initFrame();

        setLayout(new BorderLayout(0, 0));

        splitPane = new JSplitPane();
        splitPane.setResizeWeight(1);
        splitPane.setOneTouchExpandable(true);
        add(splitPane);

    }

    public JSplitPane getSplitPane() {
        return splitPane;
    }

    private void initFrame() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("GOL - Game of Life - L & Y ");
        setSize(DEFAULT_WINDOW_SIZE);
        setMinimumSize(MINIMUM_WINDOW_SIZE);
        setLocation(
                (Toolkit.getDefaultToolkit().getScreenSize().width - getWidth()) / 2,
                (Toolkit.getDefaultToolkit().getScreenSize().height - getHeight()) / 2);

    }

    public static void main(String[] args) {
        GOLFrame golFrame = new GOLFrame();
        golFrame.setVisible(true);
    }

}