package net.sady.designpattern.structural.adapter;

interface Bird{
	public void fly();
	public void makeSound();
}

class Sparrow implements Bird{

	public void fly() {
		System.out.println("Flying");
	}

	public void makeSound() {
		System.out.println("Chirp chirp");
	}
}

interface ToyDuck{
	public void squeak();
}

class PlasticToyDuck implements ToyDuck{

	public void squeak() {
		System.out.println("Squeaking");
	}
	
}

class BirdAdapter implements ToyDuck{

	Bird bird;
	
	public BirdAdapter(Bird bird){
		this.bird = bird;
	}
	
	public void squeak() {
		bird.makeSound();
	}
}

public class TestAdapter {
	
	public static void main(String[] args) {
		Sparrow sparrow = new Sparrow();
		PlasticToyDuck toyDuck = new PlasticToyDuck();
		
		ToyDuck birdAdapter = new BirdAdapter(sparrow);
		
		//Bird behaving like toy duck
		birdAdapter.squeak();
	}
	
	
	
	
	
	

}
