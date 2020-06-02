package application.beans;

/**
 * PizzaBean class for holding information of pizzas ordered by customers.
 * 
 * File: PizzaBean.java
 * Date: April 11, 2020
 * 
 * @author Jason Xu 991545529
 *
 */
public class PizzaBean {

	// data and field variables
	private String size;
	private String[] toppings;
	private double price = 0;
	private String toppingsList = "";

	/**
	 * Constructor
	 */
	public PizzaBean() {
	}

	/**
	 * Returns size of pizza.
	 * @return size: String representation of size
	 */
	public String getSize() {
		return size;
	}

	/**
	 * Sets the size of the pizza.
	 * @param size: String representation of the pizza's size
	 */
	public void setSize(String size) {
		this.size = size;
	}

	/**
	 * Returns the toppings on the pizza in a String list.
	 * @return toppings: String list of toppings on pizza
	 */
	public String[] getToppings() {
		return toppings;
	}

	/**
	 * Sets the toppings on the pizza.
	 * @param toppings: String list representation of the toppings on the pizza
	 */
	public void setToppings(String[] toppings) {
		this.toppings = toppings;
	}

	/**
	 * Returns the list of toppings on the pizza in a comma separated list.
	 * @return toppingsList: String representation of the toppings on the pizza
	 */
	public String getToppingsList() {
		return this.toppingsList;
	}
	
	/**
	 * Sets the comma separated list of toppings as a String rather than String list.
	 * @param toppings: String list representation of the toppings on the pizza
	 */
	public void setToppingsList(String[] toppings) {
		if (this.toppings == null) {
			toppingsList = "None";
		} else {
			for (String topping : toppings) {
				toppingsList += topping + ", ";
			}
			toppingsList = toppingsList.substring(0, toppingsList.length() - 2);
		}
	}

	/**
	 * Gets the price of the pizza.
	 * @return price: double representation of pizza price
	 */
	public double getPrice() {
		return this.price;
	}
	
	/**
	 * Calculates and sets the price of the pizza based on size and number of toppings.
	 */
	public void setPrice() {
		// Calculates price of pizza based on size.
		if (size.equals("S")) { // if pizza is small
			price += 9.99;
		} else if (size.equals("M")) { // if pizza is medium
			price += 12.99;
		} else if (size.equals("L")) { // if pizza is large
			price += 14.99;
		} else { // if pizza is extra large
			price += 19.99;
		}

		// Adds price to pizza based on number of toppings.
		if (this.toppings != null) {
			int freeToppings = toppings.length / 4; // every 4th topping is free
			int paidToppings = toppings.length - freeToppings; // subtracts free toppings from total toppings to get how
																// many toppings need to be paid for
			price += paidToppings; // adds toppings price to total price of pizza
		}
		String strPrice = String.format("%.2f", price); // formats to 2 decimal places
		this.price = Double.parseDouble(strPrice);
	}

}
