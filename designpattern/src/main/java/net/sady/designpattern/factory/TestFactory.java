package net.sady.designpattern.factory;

abstract class Vehicle{
	public abstract int getPrice();
	public abstract String getCapacity();
}

class Sedan extends Vehicle{

	private int price;
	private String capacity;
	
	public Sedan(int price, String capacity) {
		super();
		this.price = price;
		this.capacity = capacity;
	}

	public int getPrice() {
		return this.price;
	}

	public String getCapacity() {
		return this.capacity;
	}		
}

class Suv extends Vehicle{
	private int price;
	private String capacity;
	
	public Suv(int price, String capacity) {
		this.price = price;
		this.capacity = capacity;
	}
	
	public int getPrice() {
		return this.price;
	}

	public String getCapacity() {
		return capacity;
	}
}

class VehicleFactory{
	public static Vehicle getVehicleInstance(String vehicle, int price, String type){
		if(vehicle.equalsIgnoreCase("sedan")){
			return new Sedan(price, type);
		} else if(vehicle.equalsIgnoreCase("suv")){
			return new Suv(price, type);
		}
		return null;
	}
}

public class TestFactory {
	public static void main(String[] args) {
		
		Sedan sedan = (Sedan) VehicleFactory.getVehicleInstance("sedan", 7000000, "sedan");
		System.out.println(sedan.getPrice());
	}
}
