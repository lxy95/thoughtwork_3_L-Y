package ui;

import ui.common.DataType;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class MainControlPanel extends JPanel {
    private JButton startPauseButton;
    private JButton resetButton;
    private JButton stepButton;
    private JLabel stepNumLabel;

    private JSlider speedSlider;
    private JSlider zoomSlider;

    private JLabel lblDataType;
    private JComboBox dataTypeComboBox;

    public MainControlPanel() {
        setMinimumSize(new Dimension(220, 0));
        setPreferredSize(new Dimension(280, 631));

        buildPanel();
    }
    /**
     * Create the panel.
     */
    public void buildPanel() {

        GridBagLayout gridBagLayout = new GridBagLayout();
        gridBagLayout.columnWidths = new int[] {10, 0, 100, 100, 80, 10};
        gridBagLayout.rowHeights = new int[]{20, 0, 15, 0, 0, 15, 0, 0, 0, 15, 0, 0, 15, 0, 31, 15, 0, 15, 0};
        gridBagLayout.columnWeights = new double[]{0.0, 0.0, 1.0, 1.0, 1.0, 0.0};
        gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
        setLayout(gridBagLayout);

        JPanel panel_1 = new JPanel();
        GridBagConstraints gbc_panel_1 = new GridBagConstraints();
        gbc_panel_1.anchor = GridBagConstraints.NORTH;
        gbc_panel_1.gridwidth = 3;
        gbc_panel_1.insets = new Insets(0, 0, 5, 5);
        gbc_panel_1.fill = GridBagConstraints.HORIZONTAL;
        gbc_panel_1.gridx = 2;
        gbc_panel_1.gridy = 1;
        add(panel_1, gbc_panel_1);
        GridBagLayout gbl_panel_1 = new GridBagLayout();
        gbl_panel_1.columnWidths = new int[]{0, 0};
        gbl_panel_1.rowHeights = new int[]{0, 23};
        gbl_panel_1.columnWeights = new double[]{1.0, 1.0};
        gbl_panel_1.rowWeights = new double[]{0.0, 0.0};
        panel_1.setLayout(gbl_panel_1);

        lblDataType = new JLabel("data Type");
        GridBagConstraints gbc_lblDataType = new GridBagConstraints();
        gbc_lblDataType.anchor = GridBagConstraints.WEST;
        gbc_lblDataType.insets = new Insets(30, 0, 5, 5);
        gbc_lblDataType.gridx = 2;
        gbc_lblDataType.gridy = 0;
        add(lblDataType, gbc_lblDataType);

        dataTypeComboBox = new JComboBox ();
        GridBagConstraints gbc_dataTypeComboBox = new GridBagConstraints();
        gbc_dataTypeComboBox.gridwidth = 2;
        gbc_dataTypeComboBox.insets = new Insets(30, 0, 5, 5);
        gbc_dataTypeComboBox.fill = GridBagConstraints.HORIZONTAL;
        gbc_dataTypeComboBox.gridx = 3;
        gbc_dataTypeComboBox.gridy = 0;
        dataTypeComboBox.addItem(DataType.toString(DataType.CLEAR));
        dataTypeComboBox.addItem(DataType.toString(DataType.CELL_ROW_10));
        dataTypeComboBox.addItem(DataType.toString(DataType.EXPLODER));
        dataTypeComboBox.addItem(DataType.toString(DataType.GLIDER));
        dataTypeComboBox.addItem(DataType.toString(DataType.GOSPER_GLIDER_GUN));
        dataTypeComboBox.addItem(DataType.toString(DataType.LIGHTWEIGHT_SPACESHIP));
        dataTypeComboBox.addItem(DataType.toString(DataType.SMALL_EXPLODER));
        dataTypeComboBox.addItem(DataType.toString(DataType.TUMBLER));
        add(dataTypeComboBox, gbc_dataTypeComboBox);

        startPauseButton = new JButton("Start");
        //startPauseButton.setFont(new Font("微软雅黑",Font.PLAIN,20));
        startPauseButton.setMaximumSize(new Dimension(200, 23));
        startPauseButton.setPreferredSize(new Dimension(100, 23));
        GridBagConstraints gbc_startPauseButton = new GridBagConstraints();
        gbc_startPauseButton.fill = GridBagConstraints.HORIZONTAL;
        gbc_startPauseButton.insets = new Insets(0, 0, 5, 5);
        gbc_startPauseButton.gridx = 0;
        gbc_startPauseButton.gridy = 2;
        panel_1.add(startPauseButton, gbc_startPauseButton);

        stepButton = new JButton("Step");
        GridBagConstraints gbc_stepButton = new GridBagConstraints();
        gbc_stepButton.fill = GridBagConstraints.HORIZONTAL;
        gbc_stepButton.insets = new Insets(0, 0, 5, 5);
        gbc_stepButton.gridx = 0;
        gbc_stepButton.gridy = 3;
        panel_1.add(stepButton, gbc_stepButton);
        stepButton.setPreferredSize(new Dimension(100, 23));

        resetButton = new JButton("Reset");
        GridBagConstraints gbc_resetButton = new GridBagConstraints();
        gbc_resetButton.insets = new Insets(0, 0, 0, 5);
        gbc_resetButton.fill = GridBagConstraints.HORIZONTAL;
        gbc_resetButton.gridx = 0;
        gbc_resetButton.gridy = 4;
        panel_1.add(resetButton, gbc_resetButton);
        resetButton.setPreferredSize(new Dimension(100, 23));

        JLabel lblStepNum = new JLabel("StepNum");
        lblStepNum.setMinimumSize(new Dimension(100, 14));
        GridBagConstraints gbc_lblStepNum = new GridBagConstraints();
        gbc_lblStepNum.anchor = GridBagConstraints.WEST;
        gbc_lblStepNum.insets = new Insets(0, 0, 5, 5);
        gbc_lblStepNum.gridx = 2;
        gbc_lblStepNum.gridy = 6;
        add(lblStepNum, gbc_lblStepNum);

        stepNumLabel = new JLabel("--");
        GridBagConstraints gbc_stepNumLabel = new GridBagConstraints();
        gbc_stepNumLabel.fill = GridBagConstraints.HORIZONTAL;
        gbc_stepNumLabel.insets = new Insets(0, 0, 5, 5);
        gbc_stepNumLabel.gridx = 3;
        gbc_stepNumLabel.gridy = 6;
        add(stepNumLabel, gbc_stepNumLabel);
        stepNumLabel.setPreferredSize(new Dimension(100, 23));
        stepNumLabel.setBackground(Color.WHITE);

        JLabel speedLabel = new JLabel("Speed(*10ms)");
        GridBagConstraints gbc_speedLabel = new GridBagConstraints();
        gbc_speedLabel.anchor = GridBagConstraints.WEST;
        gbc_speedLabel.insets = new Insets(0, 0, 5, 5);
        gbc_speedLabel.gridx = 2;
        gbc_speedLabel.gridy = 8;
        add(speedLabel, gbc_speedLabel);

        speedSlider = new JSlider();
        speedSlider.setPaintTicks(true);
        speedSlider.setPaintLabels(true);
        speedSlider.setMajorTickSpacing(5);
        speedSlider.setMinorTickSpacing(1);
        speedSlider.setMinimum(10);
        speedSlider.setMaximum(50);
        speedSlider.setValue(20);
        GridBagConstraints gbc_speedSlider = new GridBagConstraints();
        gbc_speedSlider.fill = GridBagConstraints.HORIZONTAL;
        gbc_speedSlider.gridwidth = 2;
        gbc_speedSlider.insets = new Insets(0, 0, 5, 5);
        gbc_speedSlider.gridx = 3;
        gbc_speedSlider.gridy = 8;
        add(speedSlider, gbc_speedSlider);

    }

    public JSlider getZoomSlider() {
        return zoomSlider;
    }
    public JButton getStartPauseButton() {
        return startPauseButton;
    }
    public JButton getStepButton() {
        return stepButton;
    }
    public JSlider getSpeedSlider() {
        return speedSlider;
    }
    public JButton getResetButton() {
        return resetButton;
    }
    public JComboBox getDataTypeComboBox() {
        return dataTypeComboBox;
    }

    public JLabel getStepNumLabel() {
        return stepNumLabel;
    }

    public void setStepNumLabel(JLabel stepNumLabel) {
        this.stepNumLabel = stepNumLabel;
    }
}