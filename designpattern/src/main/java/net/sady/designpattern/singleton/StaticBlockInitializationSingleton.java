package net.sady.designpattern.singleton;

public class StaticBlockInitializationSingleton {

	private static StaticBlockInitializationSingleton instance;
	
	static {
		try {
			instance = new StaticBlockInitializationSingleton();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	private StaticBlockInitializationSingleton() {}
	
	public static StaticBlockInitializationSingleton getIntance() {
		return instance;
	}
}
