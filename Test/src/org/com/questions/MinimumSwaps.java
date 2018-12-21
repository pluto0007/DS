package org.com.questions;

//https://www.hackerrank.com/challenges/minimum-swaps-2/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=arrays

/*This problem can be solved easily by observing the actual
 *  position of elements and their current position ,
 *   the actual position of element in sorted array will 
 *   be the a[i]-1 or (element-1), by tracking the actual
 *    position of element if we come back to the current 
 *    element then there exist a cycle , then count the size 
 *    of that cycle , the number of swaps will be cycling 
 *    size-1, do this for all the cycles and add them together.
 *    
 *    There exist two cycles:
Cycle 1: 2 ->4-> 1-> 2
Cycle 2: 5 -> 3 -> 5

Size of cycle = number of nodes:
Size of cycle 1=3
Size of cycle 2=2

Number of swaps: (3-1)+(2-1) = 3*/
public class MinimumSwaps {

	public static int sort(int[] arr) {		
	int swap=0;
	boolean visited[]=new boolean[arr.length];

	for(int i=0;i<arr.length;i++){
		int j=i,cycle=0;

		// Idea here is iterating over the cycle until visited become true
		while(!visited[j]){
			visited[j]=true;
			j=arr[j]-1; // start with first element, as array is zero indexed and elements here are consecutive, so element at index i would be i-1
			cycle++;
		}
		
		if(cycle!=0)
			swap+=cycle-1;
	}
	return swap;
}
	
	public static String padLeftZeros(String inputString, int length) {
	    if (inputString.length() >= length) {
	        return inputString;
	    }
	    StringBuilder sb = new StringBuilder();
	    while (sb.length() < length - inputString.length()) {
	        sb.append('0');
	    }
	    sb.append(inputString);
	 
	    return sb.toString();
	}
	public static void main(String[] args) {
		//int[] arr = {7,1,3,2,4,5,6};
		int[] arr = {4,3,1,2};
		System.out.println(sort(arr));
		padLeftZeros("chetan", 8);
	}

}
