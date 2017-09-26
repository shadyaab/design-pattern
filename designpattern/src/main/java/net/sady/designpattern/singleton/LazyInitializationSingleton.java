package net.sady.designpattern.singleton;

public class LazyInitializationSingleton {
	
	private static LazyInitializationSingleton instance;
	
	private LazyInitializationSingleton(){}
	
	//Not Thread-Safe
	public static LazyInitializationSingleton getInstance() {
		if(instance == null) {
			instance = new LazyInitializationSingleton();
		}
		return instance;
	}
}
