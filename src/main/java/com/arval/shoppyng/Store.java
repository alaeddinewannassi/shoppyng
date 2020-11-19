package com.arval.shoppyng;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Store {

	private Map<String, Integer> store = new HashMap<String, Integer>();
	private Map<String, Integer> stock = new HashMap<String, Integer>();

	/**
	 * @param product
	 * @param price
	 * @param stock
	 */
	public void addProduct(String product, int price, int stock) {
		this.store.put(product, price);
		this.stock.put(product, stock);
	}

	/**
	 * @param product
	 * @return
	 * @throws Exception
	 */
	public int price(String product) {
		if (this.store.containsKey(product)) {
			return this.store.get(product);
		} else {
			return 0;
		}
	}

	/**
	 * @param product
	 * @return
	 * @throws Exception
	 */
	public int stock(String product) throws Exception {
		if (this.stock.containsKey(product)) {
			return this.stock.get(product);
		} else {
			throw new Exception("store does not contains product with name '" + product + "'.");
		}
	}

	/**
	 * @param product
	 * @return
	 */
	public boolean take(String product) {
		int buffer = 0;
		if (this.stock.containsKey(product)) {
			buffer = this.stock.get(product);
			if (buffer > 0) {
				buffer--;
				this.stock.replace(product, buffer);
				return true;
			} else
				return false;
		} else {
			return false;
		}
	}

	/**
	 * @return
	 */
	public Set<String> products() {
		Set<String> buffer = new HashSet<String>();
		for (String i : this.stock.keySet()) {
			buffer.add(i);
		}
		return buffer;
	}

}
