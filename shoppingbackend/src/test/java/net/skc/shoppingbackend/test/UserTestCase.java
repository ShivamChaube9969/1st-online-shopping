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

	@Test
	public void testAdd() {

		user = new User();
		user.setFirstName("Shivam");
		user.setLastName("Chaube");
		user.setEmail("google@gmail.com");
		user.setContactNumber("1234567890");
		user.setRole("USER");
		user.setPassword("12345");

		// add the user
		assertEquals("Failed to add user!", true, userDAO.addUser(user));

		address = new Address();
		address.setAddressLineOne("1600 Amphitheatre Parkway in Mountain View,");
		address.setAddressLineTwo("Santa Clara County, California, United States");
		address.setCity("Santa Clara County");
		address.setState("California");
		address.setCountry("United States");
		address.setPostalCode("94043");
		address.setBilling(true);

		// link the user with the address using user ID
		address.setUserId(user.getId());

		// add the address
		assertEquals("Failed to add address!", true, userDAO.addAddress(address));

		if (user.getRole().equals("USER")) {

			// add a cart for this user
			cart = new Cart();
			cart.setUserId(user.getId());

			// add the cart
			assertEquals("Failed to add cart!", true, userDAO.addCart(cart));

			// add a shipping address for this user
			address = new Address();
			address.setAddressLineOne("1601 Amphitheatre Parkway in Mountain View,");
			address.setAddressLineTwo("Santa Clara County, California, United States");
			address.setCity("Santa Clara County");
			address.setState("California");
			address.setCountry("United States");
			address.setPostalCode("94043");
			// set shipping to true
			address.setShipping(true);

			// link it with the user
			address.setUserId(user.getId());
			
			// add the shipping address
			assertEquals("Failed to add address!", true, userDAO.addAddress(address));
			
		}

	}
}
