package net.sady.designpattern.factory;

public class VehicleFactory {
	
	private static Vehicle instance; 
	
	public static Vehicle getInstance(String type) {
		if(type.equalsIgnoreCase("Car")) {
			instance = new Car();
		} else if(type.equalsIgnoreCase("Bike")) {
			instance = new Bike();
		}
		return instance;
	}

}
