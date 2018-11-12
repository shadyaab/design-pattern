package net.sady.designpattern.abstractfactory;

abstract class Vehicle{
	abstract public int getPrice();
	abstract public String getCarType();
}

class Verna extends Vehicle{

	private int price;
	private String carType;
	
	Verna(int price, String carType){
		this.price = price;
		this.carType = carType;
	}
	
	public int getPrice() {
		return this.price;
	}

	public String getCarType() {
		return this.carType;
	}	
}

class Baleno extends Vehicle{
	
	private int price;
	private String carType;
	
	public Baleno(int price, String carType) {
		super();
		this.price = price;
		this.carType = carType;
	}

	public int getPrice() {
		return this.price;
	}

	public String getCarType() {
		return this.carType;
	}
}

abstract class Color{
	abstract public String fillColor();
}

class Blue extends Color{

	public String fillColor() {
		return "This is blue in color"; 
	}
}

class Red extends Color{

	public String fillColor() {
		return "This is red in color"; 
	}
}

abstract class AbstractFactory{
	abstract Vehicle getVehicle(String type, int price, String carType);
	abstract Color getColor(String type);
}

class VehicleFactory extends AbstractFactory{

	Vehicle getVehicle(String type, int price, String carType) {
		if(type.equalsIgnoreCase("Verna")){
			return new Verna(price, carType);
		} else if(type.equalsIgnoreCase("Baleno")){
			return new Baleno(price, carType);
		} 
		return null;
	}

	Color getColor(String type) {
		return null;
	}
}

class ColorFactory extends AbstractFactory{

	Vehicle getVehicle(String type, int price, String carType) {
		return null;
	}

	Color getColor(String type) {
		if(type.equalsIgnoreCase("Blue")){
			return new Blue();
		} else if(type.equalsIgnoreCase("Red")){
			return new Red();
		}
		return null;
	}
}

class FactoryProducer{
	public static AbstractFactory getFactory(String choice){
		if(choice.equalsIgnoreCase("vehicle")){
			return new VehicleFactory();
		} else if(choice.equalsIgnoreCase("color")){
			return new ColorFactory();
		}
		return null;
	}
}

public class TestAbstractFactory {
	
	public static void main(String[] args) {
		AbstractFactory vehicleFactory =  FactoryProducer.getFactory("vehicle");
		
		Verna verna = (Verna) vehicleFactory.getVehicle("verna", 1000000, "sedan");
		
		System.out.println(verna.getCarType());
	}
	
}
