package com.arval.shoppyng;

import java.util.Scanner;

public class Shop {

	private static Scanner reader = new Scanner(System.in);

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		// 0- initialize shop products
		Store store = new Store();
		store.addProduct("samsung", 300, 10);
		store.addProduct("apple", 300, 55);
		store.addProduct("lg", 200, 20);
		// 1- read customer name
		Basket basket = new Basket();
		String customer = readInput(reader, "Please enter your name: ");
		// 2- display products
		System.out.println("Welcome to Shoppyng " + customer);
		System.out.println("below is our sales");
		for (String product : store.products()) {
			System.out.println(product);
		}
		// 3- choose products to purchase
		while (true) {
			System.out.print("What do you want to buy (press enter to pay):");
			String product = reader.nextLine();
			if (product.isEmpty()) {
				break;
			}
			if (store.stock(product) > 0) {
				store.take(product);
				basket.add(product, store.price(product));
			}
		}
		// 4- display purchases and price
		System.out.println("your purchases are:");
		basket.print();
		System.out.println("basket price: " + basket.price());
	}

	/**
	 * @param reader
	 * @param display
	 * @return
	 */
	private static String readInput(Scanner reader, String display) {
		String input = null;
		while (input == null || input.isEmpty()) {
			System.out.print(display);
			input = reader.nextLine();
		}
		return input;
	}

}
