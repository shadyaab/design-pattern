package net.sady.designpattern.abstractfactory;

public class Black implements Color{

	private String fanColor;
	public void displayColor() {
		System.out.println("Color : " + this.fanColor);
	}
	
	public Black(String color){
		this.fanColor = color;
	}

}
