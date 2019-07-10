package net.sady.designpattern.behavior.chainofresponsibility;

import java.util.Scanner;

class Currency {
	private int amount;

	public Currency(int amount) {
		this.amount = amount;
	}

	public int getAmount() {
		return amount;
	}
}

interface DispenseChain {
	public void setNextChain(DispenseChain nextChain);

	public void dispense(Currency curr);
}

class Dispenser50Rs implements DispenseChain {

	private DispenseChain chain;

	public void setNextChain(DispenseChain nextChain) {
		this.chain = nextChain;
	}

	public void dispense(Currency curr) {
		if (curr.getAmount() >= 50) {
			int num = curr.getAmount() / 50;
			int rem = curr.getAmount() % 50;
			System.out.println("Dispensing " + num + " Rs 50 note");
			if (rem != 0) {
				this.chain.dispense(new Currency(rem));
			}
		} else {
			this.chain.dispense(curr);
		}
	}
}

class Dispense20Rs implements DispenseChain{

	private DispenseChain chain;
	public void setNextChain(DispenseChain nextChain) {
		this.chain = nextChain;
	}

	public void dispense(Currency curr) {
		if(curr.getAmount() >= 20 ) {
			int num = curr.getAmount() / 20 ;
			int rem = curr.getAmount() % 20;
			System.out.println("Dispensing " + num + " Rs 20 note");
			if(rem != 0) {
				this.chain.dispense(new Currency(rem));
			}
		} else {
			this.chain.dispense(curr);
		}
	}
}

class Dispense10Rs implements DispenseChain{

	private DispenseChain chain;
	public void setNextChain(DispenseChain nextChain) {
		this.chain = nextChain;
	}

	public void dispense(Currency curr) {
		if(curr.getAmount() >= 10 ) {
			int num = curr.getAmount() / 10 ;
			int rem = curr.getAmount() % 10;
			System.out.println("Dispensing " + num + " Rs 10 note");
			if(rem != 0) {
				this.chain.dispense(new Currency(rem));
			}
		} else {
			this.chain.dispense(curr);
		}
	}
}


public class ATMDispenseChain {

	private DispenseChain chain1;
	public ATMDispenseChain() {
		chain1 = new Dispenser50Rs();
		DispenseChain chain2 = new Dispense20Rs();
		DispenseChain chain3 = new Dispense10Rs();
		
		chain1.setNextChain(chain2);
		chain2.setNextChain(chain3);
	}
	
	public static void main(String[] args) {
		
		ATMDispenseChain atmDispenser = new ATMDispenseChain();
		while(true) {
			System.out.println("Please enter the amount to withdraw");
			Scanner sc = new Scanner(System.in);
			int amount = sc.nextInt();
			if(amount % 10 != 0) {
				System.out.println("Invalid amount - could not dispense");
				return;
			} else {
				atmDispenser.chain1.dispense(new Currency(amount));
			}
		}
		
	}
	
	
}































