package net.sady.designpattern.abstractfactory;

public class Hand implements Type{

	private String desc;

	public void display() {
		System.out.println("Inside Hand Class :: Desc : " + this.desc);
	}
	
	public Hand(String desc){
		this.desc = desc;
	}
}
