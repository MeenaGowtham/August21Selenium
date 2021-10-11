package com.day8Collections;

public class ThreadQ1 implements Runnable {
	public static void main(String[] args) {
		ThreadQ1 tq1 = new ThreadQ1();
		Thread t1 = new Thread(tq1);
		t1.start();

	}

	public void run() {
		try {
			for (int i = 0; i < 10; i++) {
				System.out.println("Implementing Runnable Interface !!!");
				Thread.sleep(500);
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
