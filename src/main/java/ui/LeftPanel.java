package ui;

import javax.swing.*;
import java.awt.*;

public class LeftPanel extends JPanel {
    JPanel innerJPanel;
    final private int ROWS = 40;
    final private int COLS = 80;
    private JTextPane tipsTextPane;
    private JPanel gridPanel = new JPanel();
    private JTextField[][] textMatrix;

    public LeftPanel() {
        setLayout(new BorderLayout(0, 0));
        setPreferredSize(new Dimension(400, 400));
        initGridLayout();
    }

    private void buildPanel() {
        GridBagLayout gridBagLayout = new GridBagLayout();
        gridBagLayout.columnWidths = new int[] {10, 100, 10};
        gridBagLayout.rowHeights = new int[]{20, 0, 0};
        gridBagLayout.columnWeights = new double[]{0.0, 1.0, 0.0};
        gridBagLayout.rowWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
        setLayout(gridBagLayout);

        JScrollPane scrollPane = new JScrollPane();
        GridBagConstraints gbc_scrollPane = new GridBagConstraints();
        gbc_scrollPane.insets = new Insets(0, 0, 0, 5);
        gbc_scrollPane.fill = GridBagConstraints.BOTH;
        gbc_scrollPane.gridx = 1;
        gbc_scrollPane.gridy = 1;
        add(scrollPane, gbc_scrollPane);

        tipsTextPane = new JTextPane();
        scrollPane.setViewportView(tipsTextPane);
    }

    /**
     * 创建显示的gridlayout布局
     */
    private void initGridLayout() {
        gridPanel = new JPanel();
        gridPanel.setLayout(new GridLayout(ROWS, COLS));
        textMatrix = new JTextField[ROWS][COLS];
        for (int x = 0; x < ROWS; x++) {
            for (int y = 0; y < COLS; y++) {
                JTextField text = new JTextField();
                textMatrix[x][y] = text;
                gridPanel.add(text);
            }
        }
        add(gridPanel);
    }

    public void showMatrix(int[][] matrix) {
        int rowBase = (ROWS-matrix.length)/2;
        int colBase = (COLS-matrix[0].length)/2;
        for (int x = 0; x < matrix.length; x++) {
            for (int y = 0; y < matrix[0].length; y++) {
                if (matrix[x][y] == 1) {
                    textMatrix[rowBase+x][colBase+y].setBackground(Color.BLACK);
                } else {
                    textMatrix[rowBase+x][colBase+y].setBackground(Color.WHITE);
                }
            }
        }
        gridPanel.updateUI();
    }

    public void cleanMatrix(int[][] matrix) {
        int rowBase = (ROWS-matrix.length)/2;
        int colBase = (COLS-matrix[0].length)/2;
        for (int x = 0; x < matrix.length; x++) {
            for (int y = 0; y < matrix[0].length; y++) {
                if (matrix[x][y] == 1) {
                    matrix[x][y] = 0;
                    textMatrix[rowBase+x][colBase+y].setBackground(Color.white);
                }
            }
        }
        gridPanel.updateUI();
    }
}
