package net.sady.designpattern.singleton;

public class DoubleCheckSingleton {

	private static DoubleCheckSingleton instance;
	
	private DoubleCheckSingleton(){}
	
	//Thread-Safe with minimum performance overhead
	public static DoubleCheckSingleton getInstance() {
		if(instance == null) {
			synchronized (DoubleCheckSingleton.class) {
				if(instance == null) {
					instance = new DoubleCheckSingleton();
				}
			}
		}
		return instance;
	}
}
