package com.day8Collections;

public class ThreadQ3 extends Thread {

	public static void main(String[] args) {
		ThreadQ3 tq3 = new ThreadQ3();
		for (int i = 0; i < 3; i++) {
			Thread t1 = new Thread(tq3);
			t1.start();
		}
	}

	public void run() {

		try {
			for (int i = 0; i < 3; i++) {
				System.out.println("Running Thread " + Thread.currentThread().getId());
				Thread.sleep(500);
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
