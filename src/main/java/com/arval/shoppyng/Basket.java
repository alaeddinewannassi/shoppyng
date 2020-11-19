package com.arval.shoppyng;

import java.util.HashMap;
import java.util.Map;

public class Basket {

	private Map<String, Purchase> basket = new HashMap<String, Purchase>();

	/**
	 * 
	 */
	public Basket() {
	}

	/**
	 * @param product
	 * @param price
	 */
	public void add(String product, int price) {
		if (this.basket.containsKey(product)) {
			this.basket.get(product).increaseAmount();
		} else {
			Purchase buffer = new Purchase(product, 1, price);
			this.basket.put(product, buffer);
		}
	}

	/**
	 * @return
	 */
	public int price() {
		int buffer = 0;
		for (Purchase i : this.basket.values()) {
			buffer += i.price();
		}
		return buffer;
	}

	/**
	 * 
	 */
	public void print() {
		for (Purchase i : this.basket.values()) {
			System.out.println(i);
		}
	}

}
