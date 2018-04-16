package basics.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import basics.domain.User;
import basics.service.UserService;

@Controller
public class AccountController {

	@Autowired
	private UserService userService;

	@RequestMapping(value = "account", method = RequestMethod.GET)
	public String account(@ModelAttribute User user) {
		if (!StringUtils.isEmpty(user.getUsername()))
			return "account";
		else
			return "home";
	}

	@RequestMapping(value = "account-user", method = RequestMethod.GET)
	public User accountUser(@ModelAttribute User user) {
		System.out.println(user);
		return userService.getUser(user.getUsername());
	}

}
