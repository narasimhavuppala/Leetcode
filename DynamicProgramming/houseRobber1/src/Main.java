import java.util.Arrays;
/**
 * http://www.programcreek.com/2014/03/leetcode-house-robber-java/
 * 
 * You are a professional robber planning to rob houses along a 
 * street. Each house has a certain amount of money stashed, 
 * the only constraint stopping you from robbing each of them 
 * is that adjacent houses have security system connected and 
 * it will automatically contact the police if two adjacent 
 * houses were broken into on the same night.
 * 
 * Given a list of non-negative integers representing the amount 
 * of money of each house, determine the maximum amount of money 
 * you can rob tonight without alerting the police.
 */

/**
 * @author rakshith
 *
 */
public class Main {

	public static void main(String[] args) {
		int[] array = {50, 60, 1, 20, 25, 1, 2, 25, 1, 1, 1};
		printMaxAmount(array);
	}
	
	public static void printMaxAmount(int[] amount){
		int[] maxAmount = new int[amount.length];
		int[] prevHouseId = new int[amount.length];
		boolean[] included = new boolean[amount.length];
		maxAmount[0] = amount[0];
		prevHouseId[0] = 0;
		included[0] = true;
		maxAmount[1] = Math.max(amount[0],amount[1]);
		if(amount[0] > amount[1]){
			prevHouseId[1] = 0;
			included[1] = false;
		}else{
			prevHouseId[1] = 1;
			included[1] = true;
		}
		
		for(int i=2; i<amount.length; i++){
			if(maxAmount[i-1] > maxAmount[i-2]+amount[i]){
				maxAmount[i] = maxAmount[i-1];
				included[i] = false;
				
			}else{
				maxAmount[i] = maxAmount[i-2]+amount[i];
				included[i] = true;
				if(included[i-2]){
					prevHouseId[i] = i-2;
				}else{
					prevHouseId[i] = prevHouseId[i-2];
				}
			}
		}
		System.out.println("max amount is "+maxAmount[maxAmount.length-1]);
		System.out.println(Arrays.toString(amount));
		System.out.println(Arrays.toString(maxAmount));
		System.out.println(Arrays.toString(prevHouseId));
		/*
		for(int i=0; i< amount.length; i++){
			if()
		}*/
	}
}
