package net.sady.designpattern;

public class RunnableThread implements Runnable{

	public void run() {
		System.out.println("Running thread");
		
	}
	public static void main(String[] args) {
		RunnableThread obj = new RunnableThread();
		Thread thread = new Thread(obj);
		thread.start();
	}

}
