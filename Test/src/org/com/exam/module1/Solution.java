package org.com.exam.module1;

import java.util.Scanner;

public class Solution{
    public static void main(String []argh){
        Scanner in = new Scanner(System.in);
        int t=in.nextInt();
        int sum =0;
        for(int i=0;i<t;i++){
            int a = in.nextInt();
            int b = in.nextInt();
            int n = in.nextInt();
            sum = sum +a;
            for(int j=0;j<n;j++){
                sum+=(Math.pow(2,j)*b);
                System.out.print(sum + " ");
            }
            System.out.print("\n");
            sum =0;
            
        }
        in.close();
    }
    // Sample input
    /*
    1
    5 3 5
    */
}
