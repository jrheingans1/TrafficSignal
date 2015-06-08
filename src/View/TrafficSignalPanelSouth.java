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

import Model.NorthSouthTrafficSignalModel;

public final class TrafficSignalPanelSouth {

    protected JPanel panel;

    protected TrafficSignalLightPanel redLight;
    protected TrafficSignalLightPanel yellowLight;
    protected TrafficSignalLightPanel greenLight;

    public TrafficSignalPanelSouth() {
        createPartControl();
    }

    protected void createPartControl() {
        Border border = BorderFactory.createLineBorder(Color.BLACK, 4);

        redLight = new TrafficSignalLightPanel(Color.RED);
        redLight.setBorder(border);
        redLight.setPreferredSize(NorthSouthTrafficSignalModel.LIGHT_SIZE);

        yellowLight = new TrafficSignalLightPanel(Color.YELLOW);
        yellowLight.setBorder(border);
        yellowLight.setPreferredSize(NorthSouthTrafficSignalModel.LIGHT_SIZE);

        greenLight = new TrafficSignalLightPanel(Color.GREEN);
        greenLight.setBorder(border);
        greenLight.setPreferredSize(NorthSouthTrafficSignalModel.LIGHT_SIZE);

        panel = new JPanel();
        panel.setLayout(new FlowLayout());
        panel.setPreferredSize(new Dimension(NorthSouthTrafficSignalModel.LIGHT_SIZE.width + 50,
                NorthSouthTrafficSignalModel.LIGHT_SIZE.height * 3 + 25));

        panel.add(redLight);
        panel.add(yellowLight);
        panel.add(greenLight);
    }

    public JPanel getPanel() {
        return panel;
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
