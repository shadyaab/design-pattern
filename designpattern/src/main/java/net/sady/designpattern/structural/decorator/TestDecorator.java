package net.sady.designpattern.structural.decorator;

abstract class Pizza{
	String description;
	String price;
	
	public String getDescription(){
		return this.description;
	}
	
	abstract int getPrice();
}

class SimplePizza extends Pizza{

	public SimplePizza(String description){
		this.description = description;
	}
	
	int getPrice() {
		return 100;
	}
}

class FarmHouse extends Pizza{
	
	public FarmHouse(String description){
		this.description = description;
	}

	int getPrice() {
		return 150;
	}
}

abstract class ToppingDecorator extends Pizza{
	public abstract String getDescription();
}

class Jalapeno extends ToppingDecorator{

	private Pizza pizza;
	public Jalapeno(Pizza pizza){
		this.pizza = pizza;
	}
	
	public String getDescription() {
		return null;
	}

	int getPrice() {
		return 0;
	}
}

class Corn extends ToppingDecorator{

	private Pizza pizza;
	
	public Corn(Pizza pizza){
		this.pizza = pizza;
	}
	
	public String getDescription() {
		return null;
	}

	int getPrice() {
		return 0;
	}
	
}


public class TestDecorator {
	
	public static void main(String[] args) {
		Pizza pizza = new SimplePizza();
		pizza = new Jalapeno(pizza);
		
		Pizza pizza2 = new Corn(new SimplePizza());
		
	}
	
	

}
