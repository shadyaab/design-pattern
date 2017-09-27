package net.sady.designpattern.abstractfactory;

public class Ceiling implements Type{
	
	private String desc;

	public void display() {
		System.out.println("Inside Ceiling Class :: Desc : " + this.desc);
	}
	
	public Ceiling(String desc){
		this.desc = desc;
	}

}
