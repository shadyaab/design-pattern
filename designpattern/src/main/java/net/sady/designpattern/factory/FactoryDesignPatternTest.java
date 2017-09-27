package net.sady.designpattern.factory;

public class FactoryDesignPatternTest {

	public static void main(String[] args) {
		Vehicle vehicle= VehicleFactory.getInstance("Car");
		vehicle.display();
	}
	
}
