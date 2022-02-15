package simplesort;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.Timer;


public class Canvas {
	Timer timer;
	String numberBufferA;
	String numberBufferB;
	Sort_ sort_ = new Sort_();
	Canvas_ canvas_ = new Canvas_();
	Swap swap = new Swap();
	int pointBufferA;
	int pointBufferB;
	int tempA;
	int tempB;
	boolean isStarted = false;

	public Canvas() {															   				    
		timer = new Timer(85, new updateTime_());
	}																			    
	
	class updateTime_ implements ActionListener {
		public void actionPerformed(ActionEvent e) {
	        canvas_.repaint();
		}
	}
	
	class Canvas_ extends JPanel {
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			Graphics2D g2d = (Graphics2D) g;
			
			if(!isStarted) {
				sort_.StringToInteger();
				sort_.Method();
				isStarted = true;
			}
			
			if(!swap.isSwapped) {
				swap.isSwapped = true;
				sort_.Sorting();
				if(sort_.isSorted) {
					tempA = sort_.firstCounter - 1;
					tempB = sort_.firstCounter;
					pointBufferA = sort_.point_.get(tempA);
					pointBufferB = sort_.point_.get(tempB);
					numberBufferA = sort_.numbers_.get(tempA);
					numberBufferB = sort_.numbers_.get(tempB);
					sort_.point_.remove(tempA);
					sort_.point_.remove(tempA);
					sort_.numbers_.remove(tempA);
					sort_.numbers_.remove(tempA);
				}
			}
			
			g.setFont(new Font("Colibri", Font.BOLD, 30));
			g.setColor(Color.blue);
			for(int i = 0; i < sort_.point_.size(); i++) {
				g.drawRect(60, sort_.point_.get(i), 40, 40);
				g.drawString(sort_.numbers_.get(i), 65 + swap.getX(swap.getUp(0), 0), sort_.point_.get(i) - swap.getY(swap.getUp(0), 30));
			}
			
			if(sort_.isSorted) {
				g.setFont(new Font("Colibri", Font.BOLD, 30));
				g.setColor(Color.red);
				g2d.setStroke(new BasicStroke(2));
				g.drawString(numberBufferB, 65 + swap.getX(swap.getDown(swap.swapCounter), 45), (62 + pointBufferA - 10) - swap.getY(swap.getDown(swap.swapCounter), 23));
				g.drawString(numberBufferA, 65 + swap.getX(swap.getUp(swap.swapCounter), 45), (62 + pointBufferA - 10) - swap.getY(swap.getUp(swap.swapCounter), 23));
				g.drawRect(60 + swap.getX(swap.getDown(swap.swapCounter), 45), (32 + pointBufferA - 10) - swap.getY(swap.getDown(swap.swapCounter), 23), 40, 40);
				g.drawRect(60 + swap.getX(swap.getUp(swap.swapCounter), 45), (32 + pointBufferA - 10) - swap.getY(swap.getUp(swap.swapCounter), 23), 40, 40);
			} else if(sort_.firstCounter < sort_.numbers.length - 1){
				g.setFont(new Font("Colibri", Font.BOLD, 30));
				g.setColor(Color.red);
				g.drawRect(60, sort_.point_.get(sort_.firstCounter), 40, 40);
				g.drawString(sort_.numbers_.get(sort_.firstCounter), 65 + swap.getX(swap.getUp(0), 0), sort_.point_.get(sort_.firstCounter) - swap.getY(swap.getUp(0), 30));
				g.drawRect(60, sort_.point_.get(sort_.firstCounter + 1), 40, 40);
				g.drawString(sort_.numbers_.get(sort_.firstCounter + 1), 65 + swap.getX(swap.getUp(0), 0), sort_.point_.get(sort_.firstCounter + 1) - swap.getY(swap.getUp(0), 30));
			}
			swap.swapTime();
			if(swap.swapCounter == 0) {
				if(sort_.isSorted) {
					sort_.point_.add(tempA, pointBufferA);
					sort_.point_.add(tempB, pointBufferB);
					sort_.numbers_.add(tempA, numberBufferA);
					sort_.numbers_.add(tempB, numberBufferB);
				}
			}
			if(sort_.secondCounter == 0) timer.stop(); 
		}
	}
}
