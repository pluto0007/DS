package org.com.java8;

public class RunnableLamda {

	public static void main(String[] args) throws InterruptedException {
		Runnable runnable = new Runnable() {
			public void run() {
				for(int i=0;i<10;i++) {
					System.out.println("hello " + Thread.currentThread().getName());
				}
			}
		};
		
		Runnable runnableLamda = ()-> {for(int i=0;i<10;i++) {
			System.out.println("hello " + Thread.currentThread().getName());
		}};
		
		Thread thread = new Thread(runnableLamda);
		thread.start();
		thread.join();

	}

}
