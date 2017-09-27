package net.sady.designpattern.builder;

public class Bike implements Vehicle{

	private int seater;
	
	public void display() {
		System.out.println("This is bike with " + this.seater + " seater");
	}
}
