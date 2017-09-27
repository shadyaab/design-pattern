package net.sady.designpattern.abstractfactory;

public class Table implements Type {
	
	private String desc;

	public void display() {
		System.out.println("Inside table Class :: Desc : " + this.desc);
	}
	
	public Table(String desc){
		this.desc = desc;
	}
}
