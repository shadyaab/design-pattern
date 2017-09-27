package net.sady.designpattern.abstractfactory;

public class ColorFactory extends FanAbstractFactory{

	@Override
	public Type getShape(String type, String desc) {
		return null;
	}

	@Override
	public Color getColor(String color, String desc) {
		if(color.equalsIgnoreCase("blue")){
			return new Blue(color);
		} else if(color.equalsIgnoreCase("black")){
			return new Black(color);
		} 
		return null;
	}
}
