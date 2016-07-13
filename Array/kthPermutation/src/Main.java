import java.util.List;
import java.util.ArrayList;
/**
 * The set [1,2,3,…,n] contains a total of n! unique permutations.
 * Given n and k, return the kth permutation sequence.
 * Note: Given n will be between 1 and 9 inclusive.
 */
/**
 * @author rakshith
 *
 */
public class Main {

	public static void main(String[] args) {
		int n = 5;
		int k = 5; //cannot be 0.
		printkthPermutation(n, k);
	}
	
	public static void printkthPermutation(int n, int k){
		List<Integer> list = new ArrayList<Integer>();
		int factorial = 1;
		for(int i=1; i<=n; i++){
			factorial *= i;
			list.add(i);
		}
		factorial /= n;
		k--;
		StringBuffer sb = new StringBuffer();
		for(int i=1; i<=n; i++){
			int p = k/factorial;
			sb.append(list.remove(p));
			
			if(i==n){
				break;
			}
			k = k%factorial;
			factorial /= n-i;
		}
		System.out.print(sb);
	}
}
