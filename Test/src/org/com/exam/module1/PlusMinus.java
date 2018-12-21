package org.com.exam.module1;

import java.util.Scanner;

/*5
-1 2 -3 -3 0*/
public class PlusMinus {

    // Complete the plusMinus function below.
    static void plusMinus(int[] arr) {
    	double negativeNumberCounter = 0;
    	double positiveNumberCounter = 0;
    	double zeroCounter = 0;
    	double negativeProportion;
    	double postiveProportion;
    	double zeroProportion;
    	int n = arr.length;
    	for(int i:arr) {
    		if(i<0) {
    			negativeNumberCounter++;
    		}
    		else if(i>0) {
    			positiveNumberCounter++;
    		}
    		else if(i==0) {
    			zeroCounter++;
    		}
    	}

    	postiveProportion = positiveNumberCounter/n;
    	postiveProportion = postiveProportion*1000000/1000000;
    	System.out.println(String.format("%1$-" + 8 + "s", postiveProportion).replace(' ', '0'));
    	
    	negativeProportion = negativeNumberCounter/n;
    	negativeProportion = Math.floor(negativeProportion*1000000)/1000000;
    	System.out.println(String.format("%1$-" + 8 + "s", negativeProportion).replace(' ', '0'));

    	zeroProportion = 1-negativeProportion-postiveProportion;
    	System.out.println(String.format("%1$-" + 8 + "s", zeroProportion).replace(' ', '0'));

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        plusMinus(arr);

        scanner.close();
    }

}
