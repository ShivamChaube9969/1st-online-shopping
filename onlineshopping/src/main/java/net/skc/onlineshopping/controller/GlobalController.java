package net.skc.onlineshopping.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import net.skc.onlineshopping.model.UserModel;
import net.skc.shoppingbackend.dao.UserDAO;
import net.skc.shoppingbackend.dto.User;

@ControllerAdvice
public class GlobalController {

	@Autowired
	private HttpSession session;

	@Autowired
	private UserDAO userDAO;

	private UserModel userModel = null;

	@ModelAttribute("userModel")
	public UserModel getUserModel() {
		if (session.getAttribute("userModel") == null) {
			// add user model
			Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

			User user = userDAO.getByEmail(authentication.getName());
			if (user != null) {
				userModel = new UserModel();
				// create new UserModel object to pass the user details
				userModel.setId(user.getId());
				userModel.setEmail(user.getEmail());
				userModel.setRole(user.getRole());
				userModel.setFullName(user.getFirstName() + " " + user.getLastName());

				if (userModel.getRole().equals("USER")) {
					// set the cart only if user has role USER
					userModel.setCart(user.getCart());
				}
				// set the user model in the session
				session.setAttribute("userModel", userModel);
				return userModel;
			}
		}

		return (UserModel) session.getAttribute("userModel");
	}

}
