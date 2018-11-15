package net.sady.designpattern.structural.facade;

interface Vehicle{
	int getPrice();
}

class Verna implements Vehicle{

	public int getPrice() {
		return 12;
	}
}

class Baleno implements Vehicle{

	public int getPrice() {
		return 8;
	}
}

class Swift implements Vehicle{

	public int getPrice() {
		return 7;
	}
}

// Aims at hiding internal complexity 
class PriceHolder{
	public int getVernaPrice(){
		Verna verna= new Verna();
		return verna.getPrice();
	}
	
	public int getBalenoPrice(){
		return new Baleno().getPrice();
	}
	
	public int getSwiftPrice(){
		return new Swift().getPrice();
	}
}

public class TestFacade {

	public static void main(String[] args) {
		PriceHolder holder = new PriceHolder();
		
		int price = holder.getVernaPrice();
		System.out.println("Verna will cost : " + price);
	}
	
}




