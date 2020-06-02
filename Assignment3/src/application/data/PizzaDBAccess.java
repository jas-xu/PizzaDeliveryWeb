package application.data;

import java.sql.*;
import java.sql.Date;

/**
 * Creates a connection to database and allows new entries to be inserted.
 * 
 * File: PizzaDBAccess.java
 * Date: April 11, 2020
 * @author Jason Xu 991545529
 */
public class PizzaDBAccess {

	// data fields
	private Connection connection = null;
	private PreparedStatement insertOrder = null;

	/**
	 * Constructor
	 */
	public PizzaDBAccess() {
	}

	/**
	 * Attempts to connect to database.
	 * @return boolean: if connection is successful
	 */
	public boolean connect() {
		// information used to connect to pizzashop database
		String pizzaShopDBUrl = "jdbc:mysql://localhost/pizzashop";
		String username = "root";
		String password = "Mbdi0302";

		try { // attempts to load driver
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.err.println("ERROR: Could not load driver. " + e.getMessage());
			return false;
		}

		try { // attempts to connect to pizzashop
			System.out.println("Connection is established... ");
			this.connection = DriverManager.getConnection(pizzaShopDBUrl, username, password);
			try { // attempts to create prepared statement
				this.insertOrder = this.connection.prepareStatement(
						"INSERT INTO orderinfo (name, phone, email, street, size, toppings, delivery, price, date, time) VALUES (?,?,?,?,?,?,?,?,?,?);");
			} catch (SQLException e) {
				System.err.println("ERROR: Could not create prepared statement. " + e.getMessage());
				try { // attempts to close connection if statement not created
					this.connection.close();
				} catch (SQLException closeErr) {
					System.err.println("ERROR: Could not close connection. " + closeErr.getMessage());
					return false;
				}
			}
		} catch (SQLException e) {
			System.err.println("ERROR: Could not establish connection to database. " + e.getMessage());
			return false;
		}
		return true;
	}

	/**
	 * Attempts to disconnect from database.
	 * @return boolean: if disconnection is successful
	 */
	public boolean disconnect() {
		try { // attempts to close statements
			this.insertOrder.close();
		} catch (SQLException e) {
			System.err.println("ERROR: Could not close prepared statement. " + e.getMessage());
		}

		try { // attempts to close connection
			this.connection.close();
		} catch (SQLException e) {
			System.err.println("ERROR: Could not close connection. " + e.getMessage());
			return false;
		}
		return true;
	}

	/**
	 * Attempts to insert new entry into pizzashop.orderinfo table
	 * @param name: String representation of customer's name
	 * @param phone: String representation of customer's phone number
	 * @param email: String representation of customer's email
	 * @param street: String representation of customer's street
	 * @param size: String representation of pizza's size
	 * @param toppings: String representation of comma separated list of toppings on pizza
	 * @param delivery: int representation of delivery preference (1 or 0)
	 * @param price: double representation of price of pizza
	 * @param date: date representation of date pizza is ordered
	 * @param time: time representation of time pizza is ordered
	 * @return boolean: if entry is inserted successfully
	 */
	public boolean insertOrder(String name, String phone, String email, String street, String size, String toppings,
			int delivery, double price, Date date, Time time) {
		try { // attempts to set values into prepared statement
			this.insertOrder.setString(1, name);
			this.insertOrder.setString(2, phone);
			this.insertOrder.setString(3, email);
			this.insertOrder.setString(4, street);
			this.insertOrder.setString(5, size);
			this.insertOrder.setString(6, toppings);
			this.insertOrder.setInt(7, delivery);
			this.insertOrder.setDouble(8, price);
			this.insertOrder.setDate(9, date);
			this.insertOrder.setTime(10, time);
			this.insertOrder.executeUpdate();
		} catch (SQLException e) {
			System.err.println("ERROR: Could not insert order. " + e.getMessage());
			return false;
		}
		return true;
	}
}
