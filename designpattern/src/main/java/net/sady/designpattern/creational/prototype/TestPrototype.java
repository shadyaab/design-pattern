package net.sady.designpattern.creational.prototype;

interface CloneVehicle{

	Object clone();
}

class Vehicle implements CloneVehicle{
	private int capacity;
	private int price;
	private String color;
	private boolean isFuelInjector;
	
	public Vehicle(int capacity, int price, String color, boolean isFuelInjector) {
		this.capacity = capacity;
		this.price = price;
		this.color = color;
		this.isFuelInjector = isFuelInjector;
	}
	
	private Vehicle(Vehicle vehicle){
		this.capacity = vehicle.capacity;
		this.price = vehicle.price;
		this.color = vehicle.color;
		this.isFuelInjector = vehicle.isFuelInjector; 
	}

	public Object clone() {
		return new Vehicle(this);
	}
	
	//This can be used to clone
	public Object clone1() {
		return new Vehicle(this.capacity, this.price, this.color, this.isFuelInjector);
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public boolean isFuelInjector() {
		return isFuelInjector;
	}

	public void setFuelInjector(boolean isFuelInjector) {
		this.isFuelInjector = isFuelInjector;
	}

	@Override
	public String toString() {
		return "Vehicle [capacity=" + capacity + ", price=" + price + ", color=" + color + ", isFuelInjector="
				+ isFuelInjector + "]";
	}
	
}

public class TestPrototype {
	
	public static void main(String[] args) {
		// First instance
		Vehicle vehicle = new Vehicle(1400, 100000, "black", true);
		System.out.println(vehicle);
		
		//Clone instance
		Vehicle clonedVehicle = (Vehicle) vehicle.clone();
		System.out.println(clonedVehicle);
		
		clonedVehicle.setFuelInjector(false);
		System.out.println("1st instance: " + vehicle);
		System.out.println("Clone instance: " + clonedVehicle);
	}

}



