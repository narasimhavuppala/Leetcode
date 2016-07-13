/**
 * here are N gas stations along a circular route, where the amount of gas at station i is gas[i].
 * You have a car with an unlimited gas tank and it costs cost[i] of gas to travel from 
 * station i to its next station (i+1). You begin the journey with an empty tank at one of the gas stations.
 * Return the starting gas station's index if you can travel around the circuit once, otherwise return -1.
 * Note:
 * The solution is guaranteed to be unique.
 */

/**
 * @author rakshith
 *
 */
public class Main {
	public static void main(String[] args) {
		//int[] gas = { 1, 2, 3, 4, 5}; int[] cost = { 1, 3, 2, 4, 5}; //2
		int[] gas = { 1, 2, 3, 4, 5}; int[] cost = { 4, 4, 4, 4, 4};//-1
		int start = printStartingPoint(gas, cost);
	}
	
	public static int printStartingPoint(int[] gas, int[] cost){
		int finalGasSaved = 0;
		int gasSaved = 0;
		int gasInTank = 0;
		int start = 0;
		for(int i=0; i<gas.length; i++){
			gasSaved = gas[i] - cost[i];
			finalGasSaved += gas[i] - cost[i];
			if(gasInTank + gasSaved < 0){
				start = i+1;
				gasInTank = 0;
			}else{
				gasInTank += gasSaved;
			}
		}
		if(finalGasSaved >= 0){
			System.out.println("Starting point is "+start);
			return start;
		}else{
			System.out.print("No solution exists");
			return -1;
		}
	}
}
