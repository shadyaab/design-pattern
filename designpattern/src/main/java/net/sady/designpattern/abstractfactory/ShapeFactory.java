package net.sady.designpattern.abstractfactory;

public class ShapeFactory extends FanAbstractFactory{

	@Override
	public Type getShape(String type, String desc) {
		if(type.equalsIgnoreCase("table")){
			return new Table(desc);
		} else if(type.equalsIgnoreCase("ceiling")){
			return new Ceiling(desc);
		} else if(type.equalsIgnoreCase("hand")){
			return new Hand(desc);
		} 
		return null;
	}

	@Override
	public Color getColor(String color, String desc) {
		return null;
	}
}
