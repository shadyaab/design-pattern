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
		return pizza.getDescription() + ", Jalapeno";
	}

	int getPrice() {
		return pizza.getPrice() + 10;
	}
}

class Corn extends ToppingDecorator{

	private Pizza pizza;
	
	public Corn(Pizza pizza){
		this.pizza = pizza;
	}
	
	public String getDescription() {
		return pizza.getDescription() + ", Corn";
	}

	int getPrice() {
		return pizza.getPrice() + 20;
	}
}


public class TestDecorator {
	
	public static void main(String[] args) {
		Pizza pizza = new SimplePizza("Simple Pizza");
		pizza = new Jalapeno(pizza);
		System.out.println(pizza.getDescription() + " And Price : "+ pizza.getPrice());
		
		//Adding single topping
		Pizza pizza2 = new Corn(new SimplePizza("Simple Pizza"));
		System.out.println(pizza2.getDescription() + " And Price : "+ pizza2.getPrice());
		
		//Adding multiple topping
		Pizza pizza3 = new Corn(new Jalapeno(new SimplePizza("Simple Pizza")));
		System.out.println(pizza3.getDescription() + " And Price : "+ pizza3.getPrice());
		
	}
}
