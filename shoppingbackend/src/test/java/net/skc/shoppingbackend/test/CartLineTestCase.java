package net.skc.shoppingbackend.test;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import net.skc.shoppingbackend.dao.CartLineDAO;
import net.skc.shoppingbackend.dao.ProductDAO;
import net.skc.shoppingbackend.dao.UserDAO;
import net.skc.shoppingbackend.dto.Cart;
import net.skc.shoppingbackend.dto.CartLine;
import net.skc.shoppingbackend.dto.Product;
import net.skc.shoppingbackend.dto.User;

public class CartLineTestCase {
	private static AnnotationConfigApplicationContext context;

	private static CartLineDAO cartLineDAO = null;
	private static ProductDAO productDAO = null;
	private static UserDAO userDAO = null;

	private Product product = null;
	private User user = null;
	private Cart cart = null;
	private CartLine cartLine = null;

	@BeforeClass
	public static void init() {
		context = new AnnotationConfigApplicationContext();
		context.scan("net.skc.shoppingbackend");
		context.refresh();
		productDAO = (ProductDAO) context.getBean("productDAO");
		userDAO = (UserDAO) context.getBean("userDAO");
		cartLineDAO = (CartLineDAO) context.getBean("cartLineDAO");

	}

	@Test
	public void testAddNewCartLine() {

		// 1. get the user
		user = userDAO.getByEmail("skc@gmail.com");

		// 2. fetch the cart
		cart = user.getCart();

		// 3. get the product
		product = productDAO.get(6);

		// 4. create a new cart line
		cartLine = new CartLine();

		cartLine.setBuyingPrice(product.getUnitPrice());

		cartLine.setProductCount(cartLine.getProductCount() + 1);

		cartLine.setTotal(cartLine.getProductCount() * product.getUnitPrice());

		cartLine.setAvailable(true);

		cartLine.setCartId(cart.getId());

		cartLine.setProduct(product);

		assertEquals("Failed to add the cart Line", true, cartLineDAO.add(cartLine));

		// update the cart

		cart.setGrandTotal(cart.getGrandTotal() + cartLine.getTotal());
		cart.setCartLines(cart.getCartLines() + 1); // adding a new cart Line
		assertEquals("Failed to update the cart Line", true, cartLineDAO.updateCart(cart));
	}
}
