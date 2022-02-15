package simplesort;

public class Swap {
	
	int swapCounter;
	boolean isSwapped = false;
	
	public double getDown(int up) {
		double angle = Math.toRadians((15 - up * 5) * 6);
		return angle;
	}
	
	public double getUp(int down) {
		double angle = Math.toRadians((-30 - down * 10) * 3);
		return angle;
	}
	
	public int getX(double angle, int pos) {
		int x = (int)(Math.cos(angle) * pos);
		return x;
	}
	
	public int getY(double angle, int pos) {
		int y = (int)(Math.sin(angle) * pos);
		return y;
	}
	
	public void swapTime() {
		if(swapCounter < 6) swapCounter++;
		else { swapCounter = 0; isSwapped = false; }
	}
} 
