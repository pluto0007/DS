package org.com.exam.module1;

public class Flipping {
	public int count(int[] a){
		int count_0=0,temp=0,high=0;
		for(int i=0;i<a.length;i++){
			if(a[i]==0){
				if(temp>high){
					high=temp;
					
				}
				temp=0;
				count_0++;
			}
			if(a[i]==1){
				temp++;
				
			}
		}
		if(temp>high){
			high=temp;
			
		}
		temp=0;
		
		return count_0+high;
	}
	public static void main(String args[]){
		int[] array={0, 1, 0, 0, 1, 1, 0};
		Flipping f=new Flipping();
		System.out.println(f.count(array));
		
	}
}

