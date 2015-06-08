/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import javax.swing.SwingUtilities;

import View.TrafficSignalFrame;

public class TrafficSignal implements Runnable {

    @Override
    public void run() {
        new TrafficSignalFrame();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new TrafficSignal());
    }

}
