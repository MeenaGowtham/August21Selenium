package com.practiceQuestions;

public class Metal {
	public void ring() {
	System.out.println("Ring");
	}
	public void chain() {
		System.out.println("Chain");
	}	
	public static void main(String[] args) {
		Metal m = new Gold();
		m.ring();
		m.chain();
	}
	 
}


