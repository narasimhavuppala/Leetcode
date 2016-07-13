import java.util.Arrays;

/**
 * Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.
 * If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).
 * The replacement must be in-place, do not allocate extra memory.
 * Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.
 * 
 * 1,2,3 ans:  1,3,2
 * 3,2,1 ans:  1,2,3
 * 1,1,5 ans:  1,5,1
 */

/**
 * @author rakshith
 *
 */
public class Main {

	public static void main(String[] args) {
		int[] array = { 1, 3, 2, 5, 6, 4}; // 132645
		printNextPermutation(array);
	}

	public static void printNextPermutation(int[] array){
		if(array.length <= 1){
			System.out.println(Arrays.toString(array));
			return;
		}
		for(int i = array.length-2; i>=0; i--){
			for(int j = array.length-1; j>=i; j--){
				if(array[j] > array[i]){
					swap(array,i,j);
					
					Arrays.sort(array,i+1,array.length);
					System.out.println(Arrays.toString(array));
					return;
				}
			}
		}
		System.out.println(new StringBuffer((Arrays.toString(array))).reverse());
		Arrays.sort(array);
	}
	
	public static void swap(int[] array, int i, int j){
		array[i] += array[j];
		array[j] = array[i] - array[j];
		array[i] -= array[j];
	}
}
