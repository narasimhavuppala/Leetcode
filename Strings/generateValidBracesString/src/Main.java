/**
 * https://github.com/settyblue/leetcode-best-answers/blob/master/forum/leetcode_problem_22.pdf
 */

/**
 * @author rakshith
 *
 */
public class Main {

	public static void main(String[] args) {
		int n = 3;
		printValidBraces(n);
	}
	
	public static void printValidBraces(int n){
		printValidBracesUtil(n,0,"");
	}
	
	public static void printValidBracesUtil(int n, int m, String soFar){
		if(n==0 && m==0){
			System.out.println(soFar);
			return;
		}
		
		if(n > 0)printValidBracesUtil(n-1,m+1,soFar+"(");
		if(m > 0)printValidBracesUtil(n,m-1,soFar+")");
		
	}
}
