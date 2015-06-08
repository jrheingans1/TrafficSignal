/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.awt.FlowLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;

public final class TrafficSignalFrame {

    protected ButtonPanel bPanel;

    protected JFrame frame;
    protected JLabel north;
    protected JLabel south;
    protected JLabel east;
    protected JLabel west;

    protected TrafficSignalPanelNorth tsPanelNorth;
    protected TrafficSignalPanelSouth tsPanelSouth;
    protected TrafficSignalPanelWest tsPanelWest;
    protected TrafficSignalPanelEast tsPanelEast;

    public TrafficSignalFrame() {
        createPartControl();
    }

    protected void createPartControl() {
        tsPanelNorth = new TrafficSignalPanelNorth();
        tsPanelSouth = new TrafficSignalPanelSouth();
        tsPanelWest = new TrafficSignalPanelWest();
        tsPanelEast = new TrafficSignalPanelEast();
        bPanel = new ButtonPanel();

        bPanel.setTrafficSignalPanelNorth(tsPanelNorth);
        bPanel.setTrafficSignalPanelSouth(tsPanelSouth);
        bPanel.setTrafficSignalPanelEast(tsPanelEast);
        bPanel.setTrafficSignalPanelWest(tsPanelWest);

        frame = new JFrame();
        north = new JLabel();
        south = new JLabel();
        east = new JLabel();
        west = new JLabel();
        frame.setTitle("Traffic Signal Controller");
        north.setText("North");
        south.setText("South");
        east.setText("East");
        west.setText("West");
        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent event) {
                exitProcedure();
            }
        });

        frame.setLayout(new FlowLayout());
        frame.add(bPanel.getPanel());
        frame.add(north);
        frame.add(tsPanelNorth.getPanel());
        frame.add(south);
        frame.add(tsPanelSouth.getPanel());
        frame.add(east);
        frame.add(tsPanelEast.getPanel());
        frame.add(west);
        frame.add(tsPanelWest.getPanel());
        frame.pack();
        frame.setVisible(true);
    }

    public void exitProcedure() {
        frame.dispose();
        System.exit(0);
    }

    public JFrame getFrame() {
        return frame;
    }

}
