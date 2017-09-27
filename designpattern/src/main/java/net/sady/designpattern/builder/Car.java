package net.sady.designpattern.builder;

public class Car implements Vehicle{

	private int seater;
	
	public void display() {
		System.out.println("This is car with " + this.seater + " seater");
	}

}
