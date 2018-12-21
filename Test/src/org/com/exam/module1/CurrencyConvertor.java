package org.com.exam.module1;

import java.util.*;
import java.text.*;

public class CurrencyConvertor {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double payment = scanner.nextDouble();
        scanner.close();
        NumberFormat numberFormatUSA = NumberFormat.getCurrencyInstance(new Locale("en", "US")); // it is used to covert any val
        String us = numberFormatUSA.format(payment);
        NumberFormat numberFormatCH = NumberFormat.getCurrencyInstance(Locale.CHINA);
        String ch = numberFormatCH.format(payment);
        NumberFormat numberFormatFR = NumberFormat.getCurrencyInstance(new Locale("fr", "FR"));
        String fr = numberFormatFR.format(payment);
        NumberFormat numberFormatIN = NumberFormat.getCurrencyInstance(new Locale("en", "IN"));
        String in = numberFormatIN.format(payment);
        // Write your code here.
        
        System.out.println("US: " + us);
       System.out.println("India: " + in);
        System.out.println("China: " + ch);
        System.out.println("France: " + fr);
    }
}
