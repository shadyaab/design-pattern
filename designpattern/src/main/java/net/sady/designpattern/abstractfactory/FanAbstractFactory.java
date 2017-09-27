package net.sady.designpattern.abstractfactory;

public abstract class FanAbstractFactory {
	public abstract Type getShape(String type, String desc);
	public abstract Color getColor(String color, String desc);	
}
