package net.sady.designpattern.singleton;

//Known as Bill Plugh Singleton Implementation
public class InnerClassSingletonMethod {

	private InnerClassSingletonMethod(){}
	
	private static class InnerClass{
		private static final InnerClassSingletonMethod instance = new InnerClassSingletonMethod();
	}
	//Removes the overhead of Synchronization. Makes it the most efficientt singleton implementation.
	public static InnerClassSingletonMethod getInstance() {
		 return InnerClass.instance;
	}
	
}
