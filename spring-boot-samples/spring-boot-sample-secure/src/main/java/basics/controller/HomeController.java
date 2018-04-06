package basics.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {

	@RequestMapping("/")
	@ResponseBody
	String home() {
		return "Application Started Running";
	}

	@PreAuthorize("hasAnyRole('ADMIN')")
	@RequestMapping("/console")
	void console() {
	}
}
