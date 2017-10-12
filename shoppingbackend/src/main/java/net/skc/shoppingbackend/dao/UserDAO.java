package net.skc.shoppingbackend.dao;

import net.skc.shoppingbackend.dto.Address;
import net.skc.shoppingbackend.dto.Cart;
import net.skc.shoppingbackend.dto.User;

public interface UserDAO {

	// add an user
	boolean addUser(User user);

	// add an address
	boolean addAddress(Address address);

	// add a cart
	boolean addCart(Cart cart);

}
