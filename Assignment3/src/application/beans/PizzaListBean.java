package application.beans;

import java.util.ArrayList;

/**
 * PizzaListBean class for holding the information about all pizzas in a single order.
 * 
 * File: PizzaListBean.java
 * Date: April 11, 2020
 * 
 * @author Jason Xu 991545529
 *
 */
public class PizzaListBean {
	
	// data and field variables
	private ArrayList<PizzaBean> pizzas = new ArrayList<PizzaBean>();
	private double totalTaxPrice = 0;
	private double totalPrice = 0;
	
	/**
	 * Constructor
	 */
	public PizzaListBean() {
	}
	
	/**
	 * Returns the entire array of pizzas.
	 * @return pizzas: ArrayList representation of all pizza objects in the order
	 */
	public ArrayList<PizzaBean> getPizzas() {
		return pizzas;
	}

	/**
	 * Sets the pizza array.
	 * @param pizzas: ArrayList representation of a list of pizza objects
	 */
	public void setPizzas(ArrayList<PizzaBean> pizzas) {
		this.pizzas = pizzas;
	}
	
	/**
	 * Adds a pizza objects to the ArrayList of pizzas.
	 * @param pizza: PizzaBean representation of a pizza object
	 */
	public void addPizza(PizzaBean pizza) {
		this.pizzas.add(pizza);
	}
	
	/**
	 * Returns the tax sum of all pizzas in the order.
	 * @return totalTaxPrice: double representation of tax value of entire order
	 */
	public double getTotalTaxPrice() {
		return totalTaxPrice;
	}
	
	/**
	 * Calculates and sets the tax price of a full order.
	 */
	public void setTotalTaxPrice() {
		totalTaxPrice = 0;
		for (PizzaBean pizza : pizzas) {
			totalTaxPrice += pizza.getPrice() * 0.13;
		}
		String strTotalTaxPrice = String.format("%.2f", totalTaxPrice);
		totalTaxPrice = Double.parseDouble(strTotalTaxPrice);
	}
	
	/**
	 * Returns the total price of the entire order.
	 * @return totalPrice: double representation of the entire order's value
	 */
	public double getTotalPrice() {
		return this.totalPrice;
	}
	
	/**
	 * Calculates and sets the price of the entire order.
	 */
	public void setTotalPrice() {
		totalPrice = 0;
		for (PizzaBean pizza : pizzas) {
			totalPrice += pizza.getPrice() * 1.13;
		}
		String strTotalPrice = String.format("%.2f", totalPrice);
		totalPrice = Double.parseDouble(strTotalPrice);
	}
	
}
