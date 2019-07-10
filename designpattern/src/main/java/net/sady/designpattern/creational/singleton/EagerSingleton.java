package net.sady.designpattern.creational.singleton;

public class EagerSingleton {
	
	private static final EagerSingleton instance= new EagerSingleton();
	
	private EagerSingleton() {}
	
	public static EagerSingleton getIntance() {
		return instance;
	}
}
