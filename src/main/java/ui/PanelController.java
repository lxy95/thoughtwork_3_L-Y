package ui;

import model.CellMatrix;
import ui.common.DataType;
import util.Util;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class PanelController {
    private static final int DEFAULT_DURATION = 200;
    final static String DIR = "/mnt/hgfs/Share_Ubuntu/tw/gol/configs/";

    private GOLFrame golFrame;
    private MainControlPanel mainControlPanel;
    private TipsPanel tipsPanel;
    private LeftPanel leftPanel;

    private CellMatrix cellMatrix;

    private static Thread thread;

    private static int duration = DEFAULT_DURATION;

    public PanelController() {
        buildPanels();
    }

    private void buildPanels() {
        golFrame = new GOLFrame();
        mainControlPanel = new MainControlPanel();
        leftPanel = new LeftPanel();
        tipsPanel = new TipsPanel();
        loadTipText();

        JTabbedPane rightPane = new JTabbedPane();
        rightPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
        rightPane.addTab("Main", mainControlPanel);
        rightPane.addTab("Tips", tipsPanel);

        golFrame.getSplitPane().setLeftComponent(leftPanel);
        golFrame.getSplitPane().setRightComponent(rightPane);
        golFrame.setVisible(true);

    }

    private void loadTipText() {
        try {
            tipsPanel.getTipsTextPane().setPage("file://"+DIR+"tips.html");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void start() {
        ToolTipManager.sharedInstance().setInitialDelay(0);
        addMainControlPanelListeners();
    }

    private void addMainControlPanelListeners() {
        mainControlPanel.getDataTypeComboBox().addActionListener(new SelectDataActioner());
        mainControlPanel.getStartPauseButton().addActionListener(new StartActioner());
        mainControlPanel.getStepButton().addActionListener(new StepActioner());
        mainControlPanel.getResetButton().addActionListener(new resetActioner());
    }


    public GOLFrame getGolFrame() {
        return golFrame;
    }

    public void setGolFrame(GOLFrame golFrame) {
        this.golFrame = golFrame;
    }

    public MainControlPanel getMainControlPanel() {
        return mainControlPanel;
    }

    public void setMainControlPanel(MainControlPanel mainControlPanel) {
        this.mainControlPanel = mainControlPanel;
    }

    public TipsPanel getTipsPanel() {
        return tipsPanel;
    }

    public void setTipsPanel(TipsPanel tipsPanel) {
        this.tipsPanel = tipsPanel;
    }

    public LeftPanel getLeftPanel() {
        return leftPanel;
    }

    public void setLeftPanel(LeftPanel leftPanel) {
        this.leftPanel = leftPanel;
    }

    private class SelectDataActioner implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            if(mainControlPanel.getStartPauseButton().getText()=="Stop"){
                thread.stop();
                mainControlPanel.getStartPauseButton().setText("Start");
            }
            String item = (String) mainControlPanel.getDataTypeComboBox().getSelectedItem();
            if (item==DataType.toString(DataType.TUMBLER)){
                String filepath = DIR + "tumbler.txt";
                cellMatrix = Util.initMatrixFromFile(filepath);
                getLeftPanel().showMatrix(cellMatrix.getMatrix());
            }
            if (item==DataType.toString(DataType.EXPLODER)){
                String filepath = DIR + "exploder.txt";
                cellMatrix = Util.initMatrixFromFile(filepath);
                getLeftPanel().showMatrix(cellMatrix.getMatrix());
            }
            if (item==DataType.toString(DataType.CELL_ROW_10)){
                String filepath = DIR + "10cellrow.txt";
                cellMatrix = Util.initMatrixFromFile(filepath);
                getLeftPanel().showMatrix(cellMatrix.getMatrix());
            }
            if (item==DataType.toString(DataType.SMALL_EXPLODER)){
                String filepath = DIR + "smallexploder.txt";
                cellMatrix = Util.initMatrixFromFile(filepath);
                getLeftPanel().showMatrix(cellMatrix.getMatrix());
            }
            if (item==DataType.toString(DataType.LIGHTWEIGHT_SPACESHIP)){
                String filepath = DIR + "Lightweightspaceship.txt";
                cellMatrix = Util.initMatrixFromFile(filepath);
                getLeftPanel().showMatrix(cellMatrix.getMatrix());
            }
            if (item==DataType.toString(DataType.GOSPER_GLIDER_GUN)){
                String filepath = DIR + "gospergildergun.txt";
                cellMatrix = Util.initMatrixFromFile(filepath);
                getLeftPanel().showMatrix(cellMatrix.getMatrix());
            }
            if (item==DataType.toString(DataType.GLIDER)){
                String filepath = DIR + "glider.txt";
                cellMatrix = Util.initMatrixFromFile(filepath);
                getLeftPanel().showMatrix(cellMatrix.getMatrix());
            }
        }
    }

    private class StartActioner implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            if (mainControlPanel.getStartPauseButton().getText()=="Start"){
                try {
                    duration = 10*mainControlPanel.getSpeedSlider().getValue();
                } catch (NumberFormatException e1) {
                    duration = DEFAULT_DURATION;
                }

                thread = new Thread(new GOSThread());
                thread.start();
                mainControlPanel.getStartPauseButton().setText("Stop");
            } else {
                thread.stop();
                mainControlPanel.getStartPauseButton().setText("Start");
            }
        }
    }

    private class GOSThread implements Runnable {

        public void run() {
            while (true) {
                cellMatrix.transfromStatus();
                leftPanel.showMatrix(cellMatrix.getMatrix());
                try {
                    TimeUnit.MILLISECONDS.sleep(duration);
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
            }

        }
    }

    private class StepActioner implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            cellMatrix.transfromStatus();
            leftPanel.showMatrix(cellMatrix.getMatrix());
            if (mainControlPanel.getStepNumLabel().getText()=="--"){
                mainControlPanel.getStepNumLabel().setText("1");
            } else {
                int num = Integer.parseInt(mainControlPanel.getStepNumLabel().getText());
                mainControlPanel.getStepNumLabel().setText(""+(num+1));
            }
        }
    }

    private class resetActioner implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            thread.stop();
            mainControlPanel.getDataTypeComboBox().setSelectedIndex(0);
            mainControlPanel.getStepNumLabel().setText("--");
            mainControlPanel.getStartPauseButton().setText("Start");
            leftPanel.cleanMatrix(cellMatrix.getMatrix());
        }
    }

}
