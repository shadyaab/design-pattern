package net.sady.designpattern.creational.builder;

class Verna{
	
	private int capacity;
	private int price;
	private String color;
	private boolean isFuelInjector;
	
	private Verna(VernaBuilder builder) {
		this.capacity = builder.capacity;
		this.price = builder.price;
		this.color = builder.color;
		this.isFuelInjector = builder.isFuelInjector;
	}

	public int getCapacity() {
		return capacity;
	}

	public int getPrice() {
		return price;
	}

	public String getColor() {
		return color;
	}

	public boolean isFuelInjector() {
		return isFuelInjector;
	}

	static class VernaBuilder{
		private int capacity;
		private boolean isFuelInjector;
		
		//Optional parameters
		private int price;
		private String color;
		
		
		public VernaBuilder(int capacity, boolean isFuelInjector) {
			this.capacity = capacity;
			this.isFuelInjector = isFuelInjector; 
		}
		
		public VernaBuilder setColor(String color){
			this.color = color;
			return this;
		}
		
		public VernaBuilder setPrice(int price){
			this.price = price;
			return this;
		}
		
		public Verna build(){
			return new Verna(this);
		}
	}
}

public class TestBuilder {
	public static void main(String[] args) {
		Verna verna1 = new Verna.VernaBuilder(1600,true).build();
		
		Verna verna2 = new Verna.VernaBuilder(1400, false)
							.setColor("black")
							.build();
		
		System.out.println(verna1.getColor());
		System.out.println(verna2.getColor());
	}	
}
