package org.nagarro.com;

import java.util.concurrent.TimeUnit;

public class LoopTask implements Runnable {

	private static int count = 0;
	private int id;

	public LoopTask() {
		this.id = ++count;
	}

	@Override
	public void run() {
		System.out.println("Task started " + id + " @@@@@@");

		for (int i = 10; i > 1; i--) {
			System.out.println("<Task-" + id + "> TICK TOCK " + i);

			try {
				TimeUnit.MILLISECONDS.sleep((long) Math.random() * 1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("Task finished " + id + " @@@@@@");

	}

}
