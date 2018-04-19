package basics.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import basics.domain.Value;
import basics.service.ValueService;

@Controller
@SessionAttributes("user")
public class ValueController {

	@Autowired
	public ValueService valueService;

	@RequestMapping(value = "addValue", method = RequestMethod.GET)
	public String addValue(Model model) {
		Value value = new Value();
		model.addAttribute("value", value);
		return "addValue";
	}

	@RequestMapping(value = "addValue", method = RequestMethod.POST)
	public String addValue(@ModelAttribute Value value) {
		if (value != null && (valueService.getProduct(value.getType(), value.getName()) == null)) {
			valueService.addValue(value);
			return "home";
		} else {
			if (valueService.getProduct(value.getType(), value.getName()) != null) {
				System.out.println("The Value " + value + " is already present in Database.");
			} else {
				System.out.println("Value " + value + " has errors.");
			}
			return "error";
		}
	}

	@RequestMapping(value = "showValue", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public HashMap<String, List<Value>> showValues() {
		HashMap<String, List<Value>> resultList = valueService.getAllProducts();
		return resultList;
	}

}
