import static java.lang.Math.max;
import static java.lang.Math.min;
/**
 * Given n non-negative integers representing an elevation map where the width of each bar is 1, 
 * compute how much water it is able to trap after raining.
 * For example, 
 * Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.
 */

/**
 * @author rakshith
 *
 */
public class Main {
	public static void main(String[] args) {
		int[] array = {0,1,0,2,1,0,1,3,2,1,2,1}; //6
		
		System.out.println("max collected rainwater = "+maxCollectedWater(array));
	}
	
	public static int maxCollectedWater(int[] array){
		if(array.length <= 2)
			return 0;
		
		int[] maxL = new int[array.length];
		int[] maxR = new int[array.length];
		maxL[0] = array[0];
		maxR[array.length-1] = array[array.length-1];
		
		for(int i=1; i<array.length; i++){
			maxL[i] = max(array[i],maxL[i-1]);
			maxR[array.length-1-i] = max(array[array.length-1-i], maxR[array.length-i]);
		}
		
		int collectedWater = 0;
		for(int i=1; i<array.length-1; i++){
			int currentCollected = min(maxL[i],maxR[i])-array[i];
			collectedWater += currentCollected;
		}
		
		return collectedWater;
	}

}
