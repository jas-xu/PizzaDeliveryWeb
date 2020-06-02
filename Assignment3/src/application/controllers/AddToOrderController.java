package application.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import application.beans.*;

/**
 * Servlet implementation class AddToOrderController sets and sends customer and order data to view.
 * 
 * File: AddToOrderController.java 
 * Date: April 11, 2020
 * 
 * @author Jason Xu 991545529
 * 
 */
@WebServlet("/AddToOrderController")
public class AddToOrderController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddToOrderController() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession(false); // creates new session

		if (session == null) { // if there is no existing session

			// creates a new CustomerBean object and sets all its field variables
			CustomerBean cust = new CustomerBean();
			cust.setCustName(request.getParameter("custName"));
			cust.setCustAddress(request.getParameter("custAddress"));
			cust.setCustPhone(request.getParameter("custPhone"));
			cust.setCustEmail(request.getParameter("custEmail"));
			cust.setCustDelivery(request.getParameter("custDelivery"));

			PizzaListBean pizzaList = new PizzaListBean(); // creates a new PizzaListBean object

			session = request.getSession(); // stores the session in a variable

			session.setAttribute("cust", cust); // stores the CustomerBean in session
			session.setAttribute("pizzaList", pizzaList); // stores the PizzaListBean in session
						
		} else { // if a session already exists

			PizzaListBean pizzaList = (PizzaListBean) session.getAttribute("pizzaList"); // retrieves the PizzaListBean from session
			
			// creates a new PizzaBean object and sets all its field variables
			PizzaBean pizza = new PizzaBean();
			pizza.setSize(request.getParameter("size"));
			pizza.setToppings(request.getParameterValues("toppings"));
			pizza.setToppingsList(request.getParameterValues("toppings"));
			pizza.setPrice();
			
			pizzaList.addPizza(pizza); // add PizzaBean to PizzaListBean
			pizzaList.setTotalTaxPrice(); // calculate and set tax of pizza order
			pizzaList.setTotalPrice(); // calculate and set total price of pizza order
						
		}
		
		request.getRequestDispatcher("/addToOrderView.jsp").forward(request, response); // forwards data to view

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
