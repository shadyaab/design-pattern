package net.sady.designpattern.behavior.strategy;

import java.util.ArrayList;
import java.util.List;

/**
 * Strategy pattern is used when we have multiple algorithm for a specific task
 * and client decides the actual implementation to be used at runtime
 * 
 * @author shadyaab
 *
 */
interface PaymentStrategy {
	public void pay(int amount);
}

class CreditDebitPaymentStrategy implements PaymentStrategy {

	private int cardNumber;
	private String name;
	private int cvvNo;

	public CreditDebitPaymentStrategy(int cardNumber, String name, int cvvNo) {
		super();
		this.cardNumber = cardNumber;
		this.name = name;
		this.cvvNo = cvvNo;
	}

	public void pay(int amount) {
		System.out.println("Payment with credit card is successfull");
	}
}

class PaypalPaymentStrategy implements PaymentStrategy {

	private String email;
	private String password;

	public PaypalPaymentStrategy(String email, String password) {
		super();
		this.email = email;
		this.password = password;
	}

	public void pay(int amount) {
		System.out.println("Payment using paypal is successfull");
	}
}

class Item {
	private String name;
	private int price;

	public Item(String name, int price) {
		super();
		this.name = name;
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public int getPrice() {
		return price;
	}

}

class ShoppingCart {

	List<Item> items = null;

	public ShoppingCart() {
		this.items = new ArrayList<>();
	}

	public void addItem(Item item) {
		this.items.add(item);
	}

	public int calculateTotalPrice() {
		int sum = 0;
		for (Item item : items) {
			sum += item.getPrice();
		}
		return sum;
	}

	public void pay(PaymentStrategy strategy) {
		int amount = calculateTotalPrice();
		strategy.pay(amount);
	}
}

public class TestStrategy {

	public static void main(String[] args) {
		ShoppingCart cart = new ShoppingCart();

		cart.addItem(new Item("Washing Machine", 20000));
		cart.addItem(new Item("TV", 15000));

		cart.pay(new PaypalPaymentStrategy("sady@gmail.com", "password"));

	}

}
