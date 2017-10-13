package net.skc.shoppingbackend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import net.skc.shoppingbackend.dao.UserDAO;
import net.skc.shoppingbackend.dto.Address;
import net.skc.shoppingbackend.dto.Cart;
import net.skc.shoppingbackend.dto.User;

public class UserTestCase {

	private static AnnotationConfigApplicationContext context;
	private static UserDAO userDAO;
	private static User user = null;
	private static Cart cart = null;
	private static Address address = null;

	@BeforeClass
	public static void init() {
		context = new AnnotationConfigApplicationContext();
		context.scan("net.skc.shoppingbackend");
		context.refresh();

		userDAO = (UserDAO) context.getBean("userDAO");
	}

	// @Test public void testAdd() {
	//
	// user = new User(); user.setFirstName("Shivam");
	// user.setLastName("Chaube"); user.setEmail("google@gmail.com");
	// user.setContactNumber("1234567890"); user.setRole("USER");
	// user.setPassword("12345");
	//
	// // add the user assertEquals("Failed to add user!", true,
	// userDAO.addUser(user));
	//
	// address = new Address();
	// address.setAddressLineOne("1600 Amphitheatre Parkway in Mountain View,");
	// address.setAddressLineTwo("Santa Clara County, California, United
	// States");
	// address.setCity("Santa Clara County"); address.setState("California");
	// address.setCountry("United States"); address.setPostalCode("94043");
	// address.setBilling(true);
	//
	// // link the user with the address using user ID
	// address.setUserId(user.getId());
	//
	// // add the address assertEquals("Failed to add address!", true,
	// userDAO.addAddress(address));
	//
	// if (user.getRole().equals("USER")) {
	//
	// // add a cart for this user cart = new Cart(); cart.setUser(user);
	//
	// // add the cart assertEquals("Failed to add cart!", true,
	// userDAO.addCart(cart));
	//
	// // add a shipping address for this user address = new Address();
	// address.setAddressLineOne("1601 Amphitheatre Parkway in Mountain View,");
	// address.setAddressLineTwo("Santa Clara County, California, United
	// States");
	// address.setCity("Santa Clara County"); address.setState("California");
	// address.setCountry("United States"); address.setPostalCode("94043");
	// //set shipping to true address.setShipping(true);
	//
	// // link it with the user address.setUserId(user.getId());
	//
	// // add the shipping address assertEquals("Failed to add address!", true,
	// userDAO.addAddress(address));
	//
	// }
	//
	// }

	// @Test
	// public void testAdd() {
	//
	// user = new User();
	// user.setFirstName("Shivam");
	// user.setLastName("Chaube");
	// user.setEmail("google@gmail.com");
	// user.setContactNumber("1234567890");
	// user.setRole("USER");
	// user.setPassword("12345");
	//
	// if (user.getRole().equals("USER")) {
	//
	// // add a cart for this user
	// cart = new Cart();
	// cart.setUser(user);
	//
	// // attach the cart with user
	// user.setCart(cart);
	//
	// }
	// // add the user
	// assertEquals("Failed to add user!", true, userDAO.addUser(user));
	//
	// }

	// @Test
	// public void testUpdateCart() {
	// // fetch user by its email
	// user = userDAO.getByEmail("google@gmail.com");
	//
	// // get the cart of the user
	// cart = user.getCart();
	// cart.setGrandTotal(555);
	// cart.setCartLines(2);
	// assertEquals("Failed to update cart!", true, userDAO.updateCart(cart));
	// }

	// @Test
	// public void testAddAddress() {
	// // we need to add a user
	//
	// user = new User();
	// user.setFirstName("Shivam");
	// user.setLastName("Chaube");
	// user.setEmail("google@gmail.com");
	// user.setContactNumber("1234567890");
	// user.setRole("USER");
	// user.setPassword("12345");
	//
	// // add the user
	// assertEquals("Failed to add user!", true, userDAO.addUser(user));
	//
	// // we are going to add the address
	//
	// address = new Address();
	// address.setAddressLineOne("1600 Amphitheatre Parkway in Mountain View,");
	// address.setAddressLineTwo("Santa Clara County, California, United
	// States");
	// address.setCity("Santa Clara County");
	// address.setState("California");
	// address.setCountry("United States");
	// address.setPostalCode("94043");
	// address.setBilling(true);
	//
	// // attach the user to the address
	// address.setUser(user);
	// assertEquals("Failed to add address!", true,
	// userDAO.addAddress(address));
	//
	// // we are also going to add the shipping address
	//
	// // add a shipping address for this user
	// address = new Address();
	// address.setAddressLineOne("1601 Amphitheatre Parkway in Mountain View,");
	// address.setAddressLineTwo("Santa Clara County, California, United
	// States");
	// address.setCity("Santa Clara County");
	// address.setState("California");
	// address.setCountry("United States");
	// address.setPostalCode("94043");
	// // set shipping to true
	// address.setShipping(true);
	//
	// // attach the user to the address
	// address.setUser(user);
	// assertEquals("Failed to add shipping address!", true,
	// userDAO.addAddress(address));
	// }

	// @Test
	// public void testAddAddress() {
	//
	// // fetch user from its email id
	// user = userDAO.getByEmail("google@gmail.com");
	//
	// // we are also going to add the shipping address
	// address = new Address();
	// address.setAddressLineOne("1602 Amphitheatre Parkway in Mountain View,");
	// address.setAddressLineTwo("Santa Clara County, California, United
	// States");
	// address.setCity("Santa Clara County");
	// address.setState("California");
	// address.setCountry("United States");
	// address.setPostalCode("94044");
	// // set shipping to true
	// address.setShipping(true);
	//
	// // attach the user to the address
	// address.setUser(user);
	// assertEquals("Failed to add shipping address!", true,
	// userDAO.addAddress(address));
	//
	// }

	@Test
	public void testGetAddresses() {
		// fetch user from its email id
		user = userDAO.getByEmail("google@gmail.com");

		assertEquals("Failed to fetch the list of address and size does not match!", 2,
				userDAO.listShippingAddresses(user).size());

		assertEquals("Failed to fetch the list of billing address and size does not match!", "Santa Clara County",
				userDAO.getBillingAddress(user).getCity());

	}
}
