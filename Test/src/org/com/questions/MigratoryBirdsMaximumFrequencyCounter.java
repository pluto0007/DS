package org.com.questions;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/*The first line contains an integer denoting n, the number of birds sighted and reported in the array arr. 
The second line describes arr as n space-separated integers representing the type numbers of each bird sighted.

Print the type number of the most common bird; if two or more types of birds are equally common, choose the type with the SMALLEST ID number.
Input :
6
1 4 4 4 5 3

o/p :

4

11
1 2 3 4 5 4 3 2 1 3 4

o/p : 
3
*/
public class MigratoryBirdsMaximumFrequencyCounter {


    static int migratoryBirds(List<Integer> arr) {        
        
    	// Defining new array which gets its value by incrementing its corresponding index while iterating over the passed array which contains the element from 1 to n
        int[] array = new int [arr.size()];
        
        for(int id:arr){
            array[id]++;
        }
        
        int maxValue = 0; 
        int maxPos=0;
    
        // We are iterating from 1 as arry[] wont be having any data at zero index because passed array contains value 1 to n.
        // suppose if two index contains same value, we have to return the smallest ID number, which will get automatically
        // covered in here, as smallest ID number will come first as we are filling the array and incrementing in linear fashion
        
        for(int i =1;i<arr.size();i++){
            if(array[i]>maxValue){
                maxValue = array[i];
                maxPos =  i;
            }       
        }
        return maxPos;
        }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        

        int arrCount = Integer.parseInt(bufferedReader.readLine().trim());

        String[] arrItems = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        List<Integer> arr = new ArrayList<>();

        for (int i = 0; i < arrCount; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr.add(arrItem);
        }

        int result = migratoryBirds(arr);
        System.out.println(result);
  

        bufferedReader.close();
  
    }

}
