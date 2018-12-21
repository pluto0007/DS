package org.com.exam.module1;

//PROGRAM TO FIND IF THERE EXIST A SUBSET SO THAT THE SUM OF THE NUMBERS IN THE SUBSET IS EQUALTO GIVEN VALUE
public class SubSetExist {

	public static boolean isSubSetExist(int[] arr, int number) {
		for(int i=0;i<arr.length;i++) {
			int j =i+1;
			if(arr[i]==number)
				return true;
			while(j<arr.length) {
				if(arr[i]+arr[j]==number) {
					return true;
				}
				else {
					j++;
				}
			}
		}
		return false;
	}
	public static void main(String[] args) {
		
		if (isSubSetExist(new int[]{4,3,5}, 4)) {
			System.out.println("true");
		}
		else {
			System.out.println("false");
		}
		if (isSubSetExist(new int[]{4,3,5}, 9)) {
			System.out.println("true");
		}
		else {
			System.out.println("false");
		}
		if (isSubSetExist(new int[]{4,3,5}, 5)) {
			System.out.println("true");
		}
		else {
			System.out.println("false");
		}
		if (isSubSetExist(new int[]{4,3,-5}, -2)) {
			System.out.println("true");
		}
		else {
			System.out.println("false");
		}
	}

}
