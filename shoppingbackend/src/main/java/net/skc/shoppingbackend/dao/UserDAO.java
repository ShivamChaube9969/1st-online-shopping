package net.skc.shoppingbackend.dao;

import java.util.List;

import net.skc.shoppingbackend.dto.Address;
import net.skc.shoppingbackend.dto.User;

public interface UserDAO {

	// add an user
	boolean addUser(User user);
	
	User getByEmail(String email);

	// add an address
	boolean addAddress(Address address);
	
	Address getBillingAddress(User user);
	List<Address> listShippingAddresses(User user);



}
