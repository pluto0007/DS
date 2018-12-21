package org.com.exam.module1;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.stream.Collectors;


//https://www.hackerrank.com/challenges/java-1d-array/problem
/*4
5 3
0 0 0 0 0
6 5
0 0 0 1 1 1
6 3
0 0 1 1 1 0
3 1
0 1 0*/
public class ArrayGame {

    public static boolean canWin(int leap, int[] game) {
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.add(0);
        
        while (!queue.isEmpty()) {
          int current = queue.poll();
          game[current] = 2;
          // If next cell is crossing the limit of the array, then its win or current + leap is crossing the limit of the array, then its win
          if (current + 1 >= game.length || current + leap >= game.length) {
            return true;
          }

          // If cell i+1 contains a zero, you can walk to cell i+1.
          if (game[current + 1] == 0) {
            queue.add(current + 1);
          }
          // If cell  i+leap contains a zero, you can jump to cell i+leap.
          if (game[current + leap] == 0) {
            queue.add(current + leap);
          }

          //If cell  i-1 exists and contains a zero, you can walk back to cell i-1.
          if (current - 1 >= 0 && game[current - 1] == 0) {
            queue.add(current - 1);
          }
        }

        return false;
       }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int q = scan.nextInt();
        while (q-- > 0) {
            int n = scan.nextInt();
            int leap = scan.nextInt();
            
            int[] game = new int[n];
            for (int i = 0; i < n; i++) {
                game[i] = scan.nextInt();
            }

            System.out.println( (canWin(leap, game)) ? "YES" : "NO" );
        }
        scan.close();
    }
}
