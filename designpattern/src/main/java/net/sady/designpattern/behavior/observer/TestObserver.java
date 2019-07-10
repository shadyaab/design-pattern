package net.sady.designpattern.behavior.observer;

import java.util.ArrayList;
import java.util.List;

/**
 *  Observer design pattern is useful when you are interested 
 *  in the state of an object and want to get notified whenever 
 *  there is any change
 * 
 * @author shadyaab
 *
 */
interface Subject {
	public void register(Observer obj);

	public void unregister(Observer obj);

	public void notifyObserver();

	public Object getUpdate();
}

interface Observer {

	public void update();

	public void setSubject(Subject subject);
}

class MyTopic implements Subject {

	private List<Observer> observers;
	private String message;
	private boolean changed;
	private final Object MUTEX = new Object();

	MyTopic() {
		this.observers = new ArrayList<Observer>();
	}

	public void register(Observer obj) {
		if (obj == null) {
			throw new NullPointerException();
		}

		synchronized (MUTEX) {
			if (!observers.contains(obj)) {
				observers.add(obj);
			}
		}
	}

	public void unregister(Observer obj) {
		synchronized (MUTEX) {
			observers.remove(obj);
		}
	}

	public void notifyObserver() {
		List<Observer> localObserver = null;
		
		//synchronization is used to make sure any observer registered after 
		//message is received is not notified
		synchronized (MUTEX) {
			if (!changed) {
				return;
			}
			localObserver = new ArrayList<>(this.observers);
			this.changed = false;
		}
		for (Observer observer : localObserver) {
			observer.update();
		}
	}

	public Object getUpdate() {
		return this.message;
	}
	
	public void postMessage(String message) {
		System.out.println("Message posted to the topic: " + message);
		this.message = message;
		this.changed= true;
		notifyObserver();
	}
}

class MyTopicSubscriber implements Observer {

	private String name;
	private Subject topic;

	public MyTopicSubscriber(String name) {
		this.name = name;
	}

	public void update() {
		String msg = (String) topic.getUpdate();
		if (msg == null) {
			System.out.println(name + ": No new message;");
		} else {
			System.out.println(name + ": Consuming message :: " + msg);
		}
	}

	public void setSubject(Subject subject) {
		this.topic = subject;
	}

}

public class TestObserver {

	public static void main(String[] args) {
		MyTopic topic  = new MyTopic();
		
		Observer ob1 = new MyTopicSubscriber("ob1");
		Observer ob2 = new MyTopicSubscriber("ob2");
		Observer ob3 = new MyTopicSubscriber("ob3");
		
		topic.register(ob1);
		topic.register(ob2);
		topic.register(ob3);
		
		ob1.setSubject(topic);
		ob2.setSubject(topic);
		ob3.setSubject(topic);
		
		ob1.update();
		
		topic.postMessage("Hello World");
		
	}

}
