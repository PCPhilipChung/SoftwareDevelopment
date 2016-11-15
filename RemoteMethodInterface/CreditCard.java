package Assignment3;

import java.io.Serializable;

/**
 * This is a credit card class that implements Serializable allowing a stream of bytes for objects. It contains
 * the creditcard's number and a boolean field to check if it is valid.
 * @author Philip
 *
 */
public class CreditCard implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private long creditCardNumber;
	private boolean isValid; 
	
	/**
	 * Default Constructor that sets the object to empty state.
	 */
	public CreditCard() {
		this.creditCardNumber = 0;
		this.isValid = false;
	}
	/**
	 * Overloaded Constructor that takes a long argument and assigns it to the object's creditcard number.
	 * @param l This argument represents the creditcard number.
	 */
	public CreditCard(long l){
		this.creditCardNumber = l;
	}
	
	/**
	 * Getter method that returns the object's credit card number
	 * @return this.creditCardNumber This field represents the credit card number.
	 */
	public long getCreditCardNumber(){
		return this.creditCardNumber;
	}
	
	/**
	 * Setter method that takes a long argument and assigns it to the object's creditcard number.
	 * @param l This argument represents the credit card number.
	 */
	public void setCreditCardNumber(long l){
		this.creditCardNumber = l;
	}
	
	/**
	 * Getter method that returns the credit cards state whether it is valid or not.
	 * @return this.isValid This represents the state of the credit card.
	 */
	public boolean getIsValid(){
		return this.isValid;
	}
	
	/**
	 * Setter method that takes a boolean argument and assigns it to the credit card's valid state
	 * @param v This argument represents the valid state to be assigned to the credit card.
	 */
	public void setIsValid(boolean v){
		this.isValid = v;
	}
	
	/**
	 * Object class method that overwrites the toString method and returns a string of the credit card number.ds
	 */
	public String toString(){
		String t = "";
		
		t+= this.creditCardNumber;
	
		
		return t;
	}
}
