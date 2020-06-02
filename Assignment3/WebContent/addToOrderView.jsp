<!-- Displays the options that the user can choose to create a pizza with. Also display the summary of the user's order. -->
<!-- File: addToOrderView.jsp -->
<!-- Date: April 11, 2020 -->
<!-- Author: Jason Xu 991545529 -->
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang='en'>
<head>
<meta charset="ISO-8859-1">
<!-- Link to css -->
<link type='text/css' rel='stylesheet' href='css/main.css'>
<title>Add to Order</title>
</head>
<body>
	<div class='grid-container'>
	<!-- gridTop displays the page header. -->
		<div class='gridTop'>
			<div class='mainHeader'>Order for ${cust.custName}</div>
		</div>
		<!-- gridLeft displays the choices for customizing pizzas. -->
		<div class='gridLeft'>
			<h2>Add a Pizza</h2>
			<!-- Form to add a pizza to the order. -->
			<form action='AddToOrderController' method='POST'>
				<h4>Size:</h4>
				<input type='radio' id='small' name='size' value='S'>Small <input
					type='radio' id='medium' name='size' value='M'>Medium <input
					type='radio' id='large' name='size' value='L' checked>Large
				<input type='radio' id='xlarge' name='size' value='XL'>Extra
				Large
				<h3>Toppings:</h3>
				<input type='checkbox' id='pepperoni' name='toppings'
					value='Pepperoni'>Pepperoni<br> <input type='checkbox'
					id='sausage' name='toppings' value='Sausage'>Sausage<br>
				<input type='checkbox' id='mushrooms' name='toppings'
					value='Mushrooms'>Mushrooms<br> <input type='checkbox'
					id='anchovies' name='toppings' value='Anchovies'>Anchovies<br>
				<input type='checkbox' id='greenOlives' name='toppings'
					value='Green Olives'>Green Olives<br> <input
					type='checkbox' id='blackOlives' name='toppings'
					value='Black Olives'>Black Olives<br> <input
					type='checkbox' id='greenPeppers' name='toppings'
					value='Green Peppers'>Green Peppers<br> <input
					type='checkbox' id='hotPeppers' name='toppings' value='Hot Peppers'>Hot
				Peppers<br> <input type='checkbox' id='extraCheese'
					name='toppings' value='Extra Cheese'>Extra Cheese<br>
				<input type='checkbox' id='extraSauce' name='toppings'
					value='Extra Sauce'>Extra Sauce<br> <input
					type='submit' value='Add Pizza'>
			</form>
		</div>
		<!-- gridRight displays the customer's current order summary. -->
		<div class='gridRight'>
			<h2>Your Order So Far (${cust.custDelivery})</h2>
			<!-- Form to confirm the order. -->
			<form action='CheckoutController' method='POST'>
				<div class='grid-container-orders'>
					<div class='pizzaOrderItem'>
						<strong>Size</strong>
					</div>
					<div class='pizzaOrderItem'>
						<strong>Toppings</strong>
					</div>
					<div class='pizzaOrderItem'>
						<strong>Price</strong>
					</div>
					<c:forEach var="pizza" items="${pizzaList.pizzas}">
						<div class='pizzaOrderItem'>${pizza.size}</div>
						<div class='pizzaOrderItem'>${pizza.toppingsList}</div>
						<div class='pizzaOrderItem'>$${pizza.price}</div>
					</c:forEach>
					<div class='pizzaOrderItem'></div>
					<div class='pizzaOrderPrice'>Tax:</div>
					<div class='pizzaOrderItem'>$${pizzaList.totalTaxPrice}</div>
					<div class='pizzaOrderItem'></div>
					<div class='pizzaOrderPrice'>Total:</div>
					<div class='pizzaOrderItem'>
						<strong>$${pizzaList.totalPrice}</strong>
					</div>
					<div class='pizzaOrderItem'></div>
					<div class='pizzaOrderItem'></div>
					<button type='submit' value='checkout'>
						Proceed<br>to<br>Checkout
					</button>
				</div>
			</form>
		</div>
	</div>
</body>
</html>
