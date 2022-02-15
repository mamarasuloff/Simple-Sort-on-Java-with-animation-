package simplesort;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class View {
	JFrame frame;
	JPanel firstPanel, secondPanel;
    JButton startButton, stopButton;
    Canvas canvas = new Canvas();
    Sort_ sort_ = new Sort_();
    
    public View() {
    	
    	frame = new JFrame( "Simple Sort" );
    	
    	// Frist panel parameters ==========================================================
    	firstPanel = new JPanel();													      //
    	startButton = new JButton("Sort");                                                //
    	stopButton = new JButton("Pause"); 												  //
    	firstPanel.setBorder(BorderFactory.createLineBorder(Color.BLUE));				  //
    	firstPanel.setPreferredSize(new Dimension(100, 500));							  //
    	startButton.setPreferredSize(new Dimension(96, 30));							  //
    	startButton.addActionListener(new Sort());										  //
    	stopButton.setPreferredSize(new Dimension(96, 30));								  //
    	stopButton.addActionListener(new Pause());										  //
    	firstPanel.add(startButton);									 	 		      //
    	firstPanel.add(stopButton);									 	 				  //
    	// =================================================================================
    	
    	// Second panel parameters =========================================================
    	secondPanel = new JPanel();														  //
    	secondPanel.setBorder(BorderFactory.createLineBorder(Color.BLUE));				  //
    	secondPanel.setLayout(new BorderLayout());										  //
    	secondPanel.setPreferredSize(new Dimension(200, 500));							  //
    	secondPanel.add(canvas.canvas_, BorderLayout.CENTER);							  //
    	// =================================================================================
    	
    	// Frame parameters ================================================================
    	frame.setSize(300, 550); 	// set frame size								      //										
    	frame.setResizable(false);														  //
    	frame.setVisible(true); 	// display frame									  //
    	frame.setLayout(new BorderLayout());											  //
    	frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );							  //
    	// =================================================================================
    	
    	// Add Panels to Frame =============================================================
    	frame.add(firstPanel, BorderLayout.WEST);										  //
    	frame.add(secondPanel, BorderLayout.CENTER);									  //
    	// =================================================================================
    }
    
    // First Handler =======================================================================
    class Sort implements ActionListener {											      //
        public void actionPerformed(ActionEvent ae) {									  //
        	canvas.timer.start();														  //
        }																				  //
    }																					  //
    // =====================================================================================
    
    // Second Handler ======================================================================
    class Pause implements ActionListener {												  //
        public void actionPerformed(ActionEvent ae) {                                     //
        	canvas.timer.stop();														  //
        } 																				  //
    }																					  //
    // =====================================================================================
}
