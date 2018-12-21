package org.com.exam.module1;

import java.util.Scanner;

public class EOF {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int counter =1;
        // hasNext() is used for EOF check
        while(in.hasNext()==true){
            String s = in.nextLine();
            System.out.println(counter +" "+s);
            counter++;
        }
        in.close();
    }
}
