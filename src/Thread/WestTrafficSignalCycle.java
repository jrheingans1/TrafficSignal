/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Thread;

import javax.swing.SwingUtilities;

import Model.EastWestTrafficSignalModel;
import View.TrafficSignalLightPanel;
import View.TrafficSignalPanelWest;

public class WestTrafficSignalCycle extends Thread {

    protected boolean isRunning;
    protected boolean isFinished;

    protected TrafficSignalPanelWest tsPanelWest;

    public WestTrafficSignalCycle(TrafficSignalPanelWest tsPanelWest) {
        this.tsPanelWest = tsPanelWest;
        this.isRunning = true;
        this.isFinished = false;
    }

    /**
     *
     */
    @Override
    public void run() {
        while (isRunning) {
            signalLightOn(tsPanelWest.getRedLight(), EastWestTrafficSignalModel.RED_TIMER);
            signalLightOn(tsPanelWest.getGreenLight(), EastWestTrafficSignalModel.GREEN_TIMER);
            signalLightOn(tsPanelWest.getYellowLight(), EastWestTrafficSignalModel.YELLOW_TIMER);
            

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
