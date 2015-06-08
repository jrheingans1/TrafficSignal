/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Thread;

import javax.swing.SwingUtilities;

import Model.TrafficSignalModel;
import View.TrafficSignalLightPanel;
import View.TrafficSignalPanelSouth;

public class SouthTrafficSignalCycle extends Thread {

    protected boolean isRunning;
    protected boolean isFinished;

    protected TrafficSignalPanelSouth tsPanelSouth;

    public SouthTrafficSignalCycle(TrafficSignalPanelSouth tsPanelSouth) {
        this.tsPanelSouth = tsPanelSouth;
        this.isRunning = true;
        this.isFinished = false;
    }

    /**
     *
     */
    @Override
    public void run() {
        while (isRunning) {
            signalLightOn(tsPanelSouth.getGreenLight(), TrafficSignalModel.GREEN_TIMER);
            signalLightOn(tsPanelSouth.getYellowLight(), TrafficSignalModel.YELLOW_TIMER);
            signalLightOn(tsPanelSouth.getRedLight(), TrafficSignalModel.RED_TIMER);
        }
        this.isFinished = true;
    }

    protected void signalLightOn(TrafficSignalLightPanel light, int seconds) {
        if (isRunning) {
            setLightOn(light, true);
        }

        for (int i = 0; i < 1000 && isRunning; i++) {
            try {
                Thread.sleep(1L * seconds);
            } catch (InterruptedException e) {
            }
        }
        setLightOn(light, false);
    }

    protected void setLightOn(final TrafficSignalLightPanel light,
            final boolean isLightOn) {
        SwingUtilities.invokeLater(() -> {
            light.setLightOn(isLightOn);
        });
    }

    public void stopRunning() {
        this.isRunning = false;
        while (!isFinished) {
            try {
                Thread.sleep(10L);
            } catch (InterruptedException e) {
            }
        }
    }

}
