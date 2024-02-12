package com.escho;

public class Hello {

	public static void main(String[] args) {
		new Hello().printMessage("ES");

	}
	
	public String getMessage(String name) {
		return "Hi, " + name;
	}
	
	public void printMessage(String name) {
		System.out.println("\n***** Hello class *****\n");
		System.out.println(this.getMessage(name));
		System.out.println("\n***** Hello class *****\n");
	}

}
