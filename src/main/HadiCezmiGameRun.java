package main;

import javax.swing.JFrame;

import main.ui.GameWindow;

/**
 * IMPORTANT:
 * 
 * Fall 2016 COMP 302 Software Engineering Term Project, Koç University
 * 
 * This project uses physics package under copyright of the MIT. 										*			
 * 
 * Project Name: HadiCezmi 
 * Group Name: JusticeLeague
 * Group Members: Evrim Turan, Musa Çıbık, Mustafa Acıkaraoğlu, Mustafa Saraç
 * 
 * DESCRIPTION:
 * HadiCezmi is a 2D arcade game which enables two players to play in competing manner.
 * 
 * Players design game board by adding gizmos, rotating and/or deleting them in edit mode, and they play the
 * game in running mode. Players can save and load the game configuration to and from an XML file. 
 *
 */

public final class HadiCezmiGameRun {
    public static final void main(String[] args) {
        GameWindow window = GameWindow.getInstance();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.pack();
        window.setResizable(false);
        window.setVisible(true);
    }
}
