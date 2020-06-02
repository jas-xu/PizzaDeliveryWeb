package application.controllers;

import java.io.IOException;
import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import application.beans.*;
import application.data.PizzaDBAccess;

/**
 * Servlet implementation class of CheckoutController sets and sends data to final summary view.
 * 
 * File: CheckoutController.java 
 * Date: April 11, 2020
 * 
 * @author Jason Xu 991545529
 * 
 */
@WebServlet("/CheckoutController")
public class CheckoutController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CheckoutController() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		
		CustomerBean cust = (CustomerBean) session.getAttribute("cust"); // retrieves Customer info from session
		PizzaListBean pizzaList = (PizzaListBean) session.getAttribute("pizzaList"); // retrieves Pizza order info from session

		LocalDateTime currentTime = LocalDateTime.now(); // gets and stores current time
		DateTimeFormatter dateTime = DateTimeFormatter.ofPattern("dd-MM-yyy HH:mm:ss"); // used to format date and
																						// time
		LocalDateTime orderTime;
		String custDelivery = cust.getCustDelivery();
		if (custDelivery.equals("Pick Up")) { // checks if order is pickup
			orderTime = currentTime.plusMinutes(20); // adds 20 minutes to current time for pickups
		} else { // if delivery
			orderTime = currentTime.plusMinutes(45); // adds 45 minutes to current time for delivery
		}
		String strOrderTime = orderTime.format(dateTime);

		session.setAttribute("orderTime", strOrderTime);

		PizzaDBAccess pizzashop = new PizzaDBAccess(); // creates new database access object to the pizzashop DB
		pizzashop.connect(); // connects to the pizzashop DB

		for (PizzaBean pizza : pizzaList.getPizzas()) { // iterates through every pizza in the order
			String toppings = pizza.getToppingsList();
			int delivery = 1; // delivery status is 1 by default
			if (custDelivery.equals("Pick Up")) { // if pickup request
				delivery = 0; // changes delivery status to 0
			}
			Date sqlDate = Date.valueOf(LocalDate.now()); // stores date in sql friendly format
			Time sqlTime = Time.valueOf(LocalTime.now()); // stores time in sql friendly format
			pizzashop.insertOrder(cust.getCustName(), cust.getCustPhone(), cust.getCustEmail(), cust.getCustAddress(),
					pizza.getSize(), toppings, delivery, pizza.getPrice(), sqlDate, sqlTime); // attempts to add order
																								// to database
		}

		request.getRequestDispatcher("/checkoutView.jsp").forward(request, response); // forwards data to final summary view

		session.invalidate(); // invalidates session

	} // end of doGet()

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
