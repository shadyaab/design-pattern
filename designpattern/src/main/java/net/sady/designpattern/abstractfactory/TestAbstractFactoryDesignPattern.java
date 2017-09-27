package net.sady.designpattern.abstractfactory;

public class TestAbstractFactoryDesignPattern {
	
	public static void main(String[] args) {
		
		FanAbstractFactory factory = FactoryCreator.getFactory("shape");
		Type type = factory.getShape("Table", "This is table fan");
		type.display();
	}
}
