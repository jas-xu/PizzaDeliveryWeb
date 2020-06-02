<!-- Displays the final summary of the customer's order and delivery or pick up time. -->
<!-- File: checkoutView.jsp -->
<!-- Date: April 11, 2020 -->
<!-- Author: Jason Xu 991545529 -->
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang='en'>
<head>
<meta charset="ISO-8859-1">
<!-- Link to css. -->
<link type='text/css' rel='stylesheet' href='css/main.css'>
<title>Checkout</title>
</head>
<body>
	<div class='grid-container'>
	<!-- gridTop displays the page Header. -->
		<div class='gridTop'>
			<div class='mainHeader'>Thanks for Your Order!</div>
		</div>
		<!-- gridLeft displays the summary of the customer's order, including their 
		information, pizzas, and delivery or pick up time. -->
		<div class='gridLeft'>
			<h2>Your Receipt</h2>
			<strong>${cust.custName}</strong><br> ${cust.custEmail}<br>
			${cust.custAddress}<br> ${cust.custPhone}<br> <br>
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
			</div>
			<h3>${cust.custDelivery} Time: ${orderTime}</h3>
		</div>
		<!-- gridRight displays an image of a pizza. -->
		<div class='gridRightImage'>
			<img src='images/pepperoniPizzaRight.jpg'>
		</div>
	</div>
</body>
</html>