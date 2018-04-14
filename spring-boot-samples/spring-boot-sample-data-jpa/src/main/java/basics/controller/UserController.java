package basics.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import basics.domain.User;
import basics.service.UserService;

@Controller
@SessionAttributes("user")
public class UserController {

	@Autowired
	private UserService userService;

	@RequestMapping(value = "login", method = RequestMethod.GET)
	public String login(Model model) {
		User user = new User();
		user.setUsername("username");
		user.setPassword("*********");
		model.addAttribute("user", user);
		return "login";
	}

	@RequestMapping(value = "login", method = RequestMethod.POST)
	public String loggingIn(@Valid @ModelAttribute User user, BindingResult result) throws Exception {
		if (!result.hasErrors() && userService.validate(user.getUsername(), user.getPassword())) {
			return "home";
		} else
			return "login";
	}

	@RequestMapping(value = "signup", method = RequestMethod.GET)
	public String signup(Model model) {
		User user = new User();
		user.setUsername("username");
		user.setPassword("*********");
		model.addAttribute("user", user);
		return "signup";
	}

	@RequestMapping(value = "signup", method = RequestMethod.POST)
	public String sign(@Valid @ModelAttribute User user, BindingResult result) {
		if (!result.hasErrors()) {
			userService.addUser(user);
			System.out.println("Added new user");
			return "login";
		} else
			return "signup";
	}

	@RequestMapping(value = "logout", method = RequestMethod.GET)
	public String logout(Model model) {
		User user = new User();
		user.setUsername("username");
		user.setPassword("*********");
		model.addAttribute("message", "Logged Out Successfully.");
		model.addAttribute("user", user);
		return "redirect:index.jsp";
	}

}
