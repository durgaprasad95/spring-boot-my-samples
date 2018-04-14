package basics.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class FruitController {

	@RequestMapping(value = "/addFruit")
	public String addFruit() {
		return "addFruit";
	}
}
