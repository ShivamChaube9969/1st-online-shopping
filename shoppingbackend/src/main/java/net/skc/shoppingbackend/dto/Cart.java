package net.skc.shoppingbackend.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Cart implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/*
	 * Private fields
	 */

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	/*======================*/
	
	@OneToOne
	private User user;
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	/*======================*/
	@Column(name = "grand_total")
	private int grandTotal;
	@Column(name = "cart_lines")
	private int cartLines;

	/*
	 * Setters & Getters for private fields
	 */

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getGrandTotal() {
		return grandTotal;
	}

	public void setGrandTotal(int grandTotal) {
		this.grandTotal = grandTotal;
	}

	public int getCartLines() {
		return cartLines;
	}

	public void setCartLines(int cartLines) {
		this.cartLines = cartLines;
	}

	/*
	 * toString for logging and debugging activity
	 */

	@Override
	public String toString() {
		return "Cart [id=" + id + ", userId=" + ", grandTotal=" + grandTotal + ", cartLines=" + cartLines
				+ "]";
	}

}
