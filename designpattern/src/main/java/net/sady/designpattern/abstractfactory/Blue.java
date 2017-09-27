package net.sady.designpattern.abstractfactory;

public class Blue implements Color {
	
	private String fanColor;

	public void displayColor() {
		System.out.println("Color: " + fanColor);
	}
	
	public Blue(String color){
		this.fanColor = color;
	}
	

}
