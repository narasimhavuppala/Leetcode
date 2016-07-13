import java.util.ArrayList;
import java.util.Arrays;
/**
 * Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? 
 * Find all unique triplets in the array which gives the sum of zero.
 */

/**
 * @author rakshith
 *
 */
public class Main {

	public static void main(String[] args) {
		int[] array = {-1, 0, 1, 2, -1, -4};
		printTriplets(array);
	}
	
	public static void printTriplets(int[] array){
		Arrays.sort(array);
		ArrayList<ArrayList<Integer>> result = new ArrayList<>();
		for(int i=0; i<array.length-2; i++){
			if(i==0 || array[i] != array[i-1]){
				int negated = -array[i];
				int start = i+1;
				int end = array.length-1;
				
				while(start<end){
					int sum = array[start]+array[end];
					if( sum == negated){
						ArrayList<Integer> oneSolution = new ArrayList<Integer>();
						oneSolution.add(array[i]);
						oneSolution.add(array[start]);
						oneSolution.add(array[end]);
						result.add(oneSolution);
						start++;end--;
					}else if(sum < negated){
						start++;
					}else{
						end--;
					}
				}
			}
		}
		
		System.out.println(result.toString());
	}
}
