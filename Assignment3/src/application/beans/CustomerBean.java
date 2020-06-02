package application.beans;

/**
 * CustomerBean class for holding information about the customer.
 * 
 * File: CustomerBean.java
 * Date: April 11, 2020
 * 
 * @author Jason Xu 991545529
 *
 */
public class CustomerBean {

	// data and field variables
	private String custName;
	private String custAddress;
	private String custPhone;
	private String custEmail;
	private String custDelivery;
	
	/**
	 * Constructor
	 */
	public CustomerBean() {
	}
	
	/**
	 * Returns the customer's name.
	 * @return custName: String representation of customer's name
	 */
	public String getCustName() {
		return custName;
	}
	
	/**
	 * Sets the customer's name.
	 * @param custName: String representation of the customer's name
	 */
	public void setCustName(String custName) {
		this.custName = custName;
	}
	
	/**
	 * Returns the customer's address.
	 * @return custAddress: String representation of the customer's address
	 */
	public String getCustAddress() {
		return custAddress;
	}
	
	/**
	 * Sets the customer's address.
	 * @param custAddress: String representation of the customer's address
	 */
	public void setCustAddress(String custAddress) {
		this.custAddress = custAddress;
	}
	
	/**
	 * Returns the customer's phone number.
	 * @return custPhone: String representation of the customer's phone number
	 */
	public String getCustPhone() {
		return custPhone;
	}
	
	/**
	 * Sets the customer's phone number.
	 * @param custPhone: String representation of the customer's phone number
	 */
	public void setCustPhone(String custPhone) {
		this.custPhone = custPhone;
	}
	
	/**
	 * Returns the customer's email address.
	 * @return custEmail: String representation of the customer's email address.
	 */
	public String getCustEmail() {
		return custEmail;
	}
	
	/**
	 * Sets the customer's email address.
	 * @param custEmail: String representation of the customer's email address
	 */
	public void setCustEmail(String custEmail) {
		this.custEmail = custEmail;
	}
	
	/**
	 * Returns the customer's delivery status.
	 * @return custDelivery: String representation of the customer's delivery status
	 */
	public String getCustDelivery() {
		return custDelivery;
	}
	
	/**
	 * Sets the customer's delivery status.
	 * @param custDelivery: String representation of the customer's delivery atatus
	 */
	public void setCustDelivery(String custDelivery) {
		this.custDelivery = custDelivery;
	}
	
}
