package org.com.exam.module1;

import java.util.Arrays;

/*Given two arrays of integers, find a pair of values (one value from each array) that you can swap to give the two arrays the same sum. 
EXAMPLE 
lnput:{4, 1, 2, 1, 1, 2}and{3, 6, 3, 3} Output: {1, 3}
*/
public class SumSwapAdvance
{

    public static int getArraySum(int[] a)
    {
        int sum = 0;
        for (int i = 0; i < a.length; i++)
        {
            sum += a[i];
        }
        return sum;
    }
    /*
     * newSumA = sumA -a[i]+b[j];
     * newSumB = sumB -b[j]+a[i]; 
     * As we have to check if newSumA = newSumB
     * sumA - sumB = -b[j]+a[i]-b[j]+a[i]; 
     * sumA - sumB = 2a-2b 
     * a-b= sumA-sumB/2
     * 
     */


    public static int getDifferenceOfArray(int[] a, int[] b)
    {
        int sumArrA = getArraySum(a);
        int sumArrB = getArraySum(b);
        return (sumArrA - sumArrB) / 2;
    }


    public static void swapSum(int[] a, int[] b, int lengthA, int lengthB)
    {
        Arrays.sort(a);
        Arrays.sort(b);
        int difference = getDifferenceOfArray(a, b);
        int i = 0;
        int j = 0;
        while (i < lengthA && j < lengthB)
        {
            int value = a[i] - b[j];
            if (value == difference)
            {
                System.out.println(a[i] + " " + b[j]);
                return;
            }
            else if (value < difference)
            {
                i++;
            }
            else
            {
                j++;
            }
        }
    }


    public static void main(String[] args)
    {
        int[] A = {4, 1, 2, 1, 1, 2};
        int[] B = {3, 6, 3, 3};
        int arrALength = A.length;
        int arrBLength = B.length;
        swapSum(A, B, arrALength, arrBLength);

    }

}
