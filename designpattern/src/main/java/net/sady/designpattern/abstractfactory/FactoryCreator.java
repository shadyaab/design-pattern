package net.sady.designpattern.abstractfactory;

public class FactoryCreator {
	
	public static FanAbstractFactory getFactory(String feature){
		if(feature.equalsIgnoreCase("shape")){
			return new ShapeFactory();
		} else if (feature.equalsIgnoreCase("color")) {
			return new ColorFactory();
		}
		return null;
	}

}
