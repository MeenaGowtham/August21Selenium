package com.day5;

public class Programming {
	
	String message = "I love ";
	Programming(){
		message = message+"programming languages";
	}
	
	Programming(String language){
		message = message+language;
	}

	public static void main(String[] args) {
		Programming p1 = new Programming();
		Programming p2 = new Programming("Java");
		System.out.println(p1.message);
		System.out.println(p2.message);
	}
}
