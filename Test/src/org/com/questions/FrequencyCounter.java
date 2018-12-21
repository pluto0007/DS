package org.com.questions;

public class FrequencyCounter {

	public static void main(String[] args) {
		String name = "my name is chetan my name is chetan";
		name = name.replace(" ","");
		int[] arr = new int[26];
		for(int i=0;i<name.length();i++) {
				arr[name.charAt(i) -'a']++;
		}
		for(int i=0;i<name.length();i++) {
			if(arr[name.charAt(i)-'a']!=0) {
				System.out.println(name.charAt(i) + " "+ arr[name.charAt(i)-'a']);
				arr[name.charAt(i) - 'a'] = 0; 
			}
		}
	}

}
