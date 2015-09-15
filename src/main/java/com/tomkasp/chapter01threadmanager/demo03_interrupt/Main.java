package com.tomkasp.chapter01threadmanager.demo03_interrupt;

import java.util.concurrent.TimeUnit;

public class Main {

	public static void main(String[] args) throws InterruptedException {
		Thread task = new PrimeGenerator();
		task.start();
		

		try {
			TimeUnit.SECONDS.sleep(80);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		

		task.interrupt();

        TimeUnit.SECONDS.sleep(5);
		System.out.println(task.getState());	// TERMINATED
		task.interrupt();
	}

}

