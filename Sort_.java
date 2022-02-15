package simplesort;

import java.awt.Point;
import java.util.ArrayList;

public class Sort_ {

	Point[] point = new Point[10];
	String[] numbers = {"36", "28", "43", "11", "7", "55", "17", "23", "13", "52"};
	ArrayList<Integer> point_ = new ArrayList<Integer>();
	ArrayList<String> numbers_ = new ArrayList<String>();
	ArrayList<Integer> Numbers = new ArrayList<Integer>();
	Swap swap = new Swap();
	int firstCounter;
	int secondCounter;
	int secondBuffer;
	String firstBuffer;
	boolean isSorted = false;
	
	Sort_() {
		
	}
	
	public void Method() {
		if(!point_.isEmpty() || !numbers_.isEmpty()) { point_.clear(); numbers_.clear(); }	
		for(int i = 0, j = 20; i < point.length; i++, j += 45) {
			point[i] = new Point(60, j);
			point_.add(i, (int) point[i].getY());
			numbers_.add(numbers[i]);
		}
	}
	
	public void StringToInteger() {
		for(int i = 0; i < numbers.length; i++) {
			Numbers.add(Integer.parseInt(numbers[i]));
		}
	}
	
	public void Sorting() {
		if((firstCounter < numbers.length - 1) && secondCounter != 0) {
			firstCounter++;
			if(Numbers.get(firstCounter) < Numbers.get(firstCounter - 1)) {
				isSorted = true;
				firstBuffer = numbers_.get(firstCounter);
				secondBuffer = Numbers.get(firstCounter);
				numbers_.set(firstCounter, numbers_.get(firstCounter - 1));
				numbers_.set(firstCounter - 1, firstBuffer);
				Numbers.set(firstCounter, Numbers.get(firstCounter - 1));
				Numbers.set(firstCounter - 1, secondBuffer);
			} else isSorted = false;
		} else if(secondCounter < numbers.length - 1) {
			isSorted = false;
			firstCounter = 0;
			secondCounter++;
		} else { 
			secondCounter = 0;
			System.out.println(numbers_); 
		}
	}
}
