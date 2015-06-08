/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JPanel;

import Thread.NorthTrafficSignalCycle;
import Thread.SouthTrafficSignalCycle;
import Thread.EastTrafficSignalCycle;
import Thread.WestTrafficSignalCycle;

public final class ButtonPanel {

    protected JButton startButton;
    protected JButton stopButton;

    protected JPanel panel;

    protected NorthTrafficSignalCycle northThread;
    protected SouthTrafficSignalCycle southThread;
    protected WestTrafficSignalCycle westThread;
    protected EastTrafficSignalCycle eastThread;

    protected TrafficSignalPanelNorth tsPanelNorth;
    protected TrafficSignalPanelSouth tsPanelSouth;
    protected TrafficSignalPanelWest tsPanelWest;
    protected TrafficSignalPanelEast tsPanelEast;

    public ButtonPanel() {
        this.northThread = null;
        this.southThread = null;
        this.eastThread = null;
        this.westThread = null;
        this.createPartControl();
    }

    protected void createPartControl() {
        panel = new JPanel();
        panel.setLayout(new FlowLayout());

        startButton = new JButton("Start");
        startButton.addActionListener((ActionEvent event) -> {
            tsPanelNorth.getRedLight().setLightOn(false);
            tsPanelNorth.getYellowLight().setLightOn(false);
            tsPanelNorth.getGreenLight().setLightOn(false);

            tsPanelSouth.getRedLight().setLightOn(false);
            tsPanelSouth.getYellowLight().setLightOn(false);
            tsPanelSouth.getGreenLight().setLightOn(false);

            tsPanelEast.getRedLight().setLightOn(false);
            tsPanelEast.getYellowLight().setLightOn(false);
            tsPanelEast.getGreenLight().setLightOn(false);

            tsPanelWest.getRedLight().setLightOn(false);
            tsPanelWest.getYellowLight().setLightOn(false);
            tsPanelWest.getGreenLight().setLightOn(false);

            northThread = new NorthTrafficSignalCycle(tsPanelNorth);
            southThread = new SouthTrafficSignalCycle(tsPanelSouth);
            eastThread = new EastTrafficSignalCycle(tsPanelEast);
            westThread = new WestTrafficSignalCycle(tsPanelWest);

            northThread.start();
            southThread.start();
            eastThread.start();
            westThread.start();
        });

        panel.add(startButton);

        stopButton = new JButton("Stop");
        stopButton.addActionListener((ActionEvent event) -> {
            tsPanelNorth.getRedLight().setLightOn(true);
            tsPanelNorth.getYellowLight().setLightOn(false);
            tsPanelNorth.getGreenLight().setLightOn(false);

            tsPanelSouth.getRedLight().setLightOn(true);
            tsPanelSouth.getYellowLight().setLightOn(false);
            tsPanelSouth.getGreenLight().setLightOn(false);

            northThread.stopRunning();
            southThread.stopRunning();
        });

        panel.add(stopButton);

        setButtonSizes(startButton, stopButton);
    }

    protected void setButtonSizes(JButton... buttons) {
        Dimension preferredSize = new Dimension();
        for (JButton button : buttons) {
            Dimension d = button.getPreferredSize();
            preferredSize = setLarger(preferredSize, d);
        }
        for (JButton button : buttons) {
            button.setPreferredSize(preferredSize);
        }
    }

    protected Dimension setLarger(Dimension a, Dimension b) {
        Dimension d = new Dimension();
        d.height = Math.max(a.height, b.height);
        d.width = Math.max(a.width, b.width);
        return d;
    }

//    public void setTrafficSignalPanel(TrafficSignalPanelNorth tsPanelNorth, TrafficSignalPanelSouth tsPanelSouth) {
//        this.tsPanelNorth = tsPanelNorth;
//        this.tsPanelSouth = tsPanelSouth;
//
//    }
    public void setTrafficSignalPanelNorth(TrafficSignalPanelNorth tsPanelNorth) {
        this.tsPanelNorth = tsPanelNorth;
    }

    public void setTrafficSignalPanelSouth(TrafficSignalPanelSouth tsPanelSouth) {
        this.tsPanelSouth = tsPanelSouth;
    }

    public void setTrafficSignalPanelWest(TrafficSignalPanelWest tsPanelWest) {
        this.tsPanelWest = tsPanelWest;
    }

    public void setTrafficSignalPanelEast(TrafficSignalPanelEast tsPanelEast) {
        this.tsPanelEast = tsPanelEast;
    }

    public JPanel getPanel() {
        return panel;
    }

}
