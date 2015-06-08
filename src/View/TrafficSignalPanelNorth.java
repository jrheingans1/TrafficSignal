/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.border.Border;

import Model.TrafficSignalModel;
import java.awt.Component;
import javax.swing.JLabel;

public final class TrafficSignalPanelNorth {

    protected JPanel panel;
    protected JLabel label;

    protected TrafficSignalLightPanel redLight;
    protected TrafficSignalLightPanel yellowLight;
    protected TrafficSignalLightPanel greenLight;

    public TrafficSignalPanelNorth() {
        createPartControl();
    }

    protected void createPartControl() {
        Border border = BorderFactory.createLineBorder(Color.BLACK, 4);

        redLight = new TrafficSignalLightPanel(Color.RED);
        redLight.setBorder(border);
        redLight.setPreferredSize(TrafficSignalModel.LIGHT_SIZE);

        yellowLight = new TrafficSignalLightPanel(Color.YELLOW);
        yellowLight.setBorder(border);
        yellowLight.setPreferredSize(TrafficSignalModel.LIGHT_SIZE);

        greenLight = new TrafficSignalLightPanel(Color.GREEN);
        greenLight.setBorder(border);
        greenLight.setPreferredSize(TrafficSignalModel.LIGHT_SIZE);

        panel = new JPanel();
        label = new JLabel();

        panel.setLayout(new FlowLayout());
        panel.setPreferredSize(
                new Dimension(TrafficSignalModel.LIGHT_SIZE.width + 50,
                        TrafficSignalModel.LIGHT_SIZE.height * 3 + 25));

        panel.add(redLight);
        panel.add(yellowLight);
        panel.add(greenLight);
        label.setText("North");

    }

    public JPanel getPanel() {
        return panel;
    }

    public JLabel getLabel() {
        return label;
    }

    public TrafficSignalLightPanel getRedLight() {
        return redLight;
    }

    public TrafficSignalLightPanel getYellowLight() {
        return yellowLight;
    }

    public TrafficSignalLightPanel getGreenLight() {
        return greenLight;
    }

}
