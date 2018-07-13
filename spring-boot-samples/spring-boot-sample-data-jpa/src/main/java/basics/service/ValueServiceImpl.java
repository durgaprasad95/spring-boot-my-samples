package basics.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import basics.domain.Value;
import basics.repository.ValueRepository;

@Service
public class ValueServiceImpl implements ValueService {

	@Autowired
	private ValueRepository valueRepository;

	@Override
	public Value addValue(Value value) {
		value.setQuantity(value.getMeasuringScale(), value.getUnits());
		valueRepository.save(value);
		return value;
	}

	@Override
	public Value getProduct(String type, String name) {
		return valueRepository.findByTypeAndName(type, name);
	}

	@Override
	public HashMap<String, List<Value>> getAllProducts() {
		HashMap<String, List<Value>> result = new HashMap<String, List<Value>>();
		if (!valueRepository.findAllByType("Fruit").isEmpty()) {
			result.put("fruitValues", valueRepository.findAllByType("Fruit"));
		}
		if (!valueRepository.findAllByType("Vegetable").isEmpty()) {
			result.put("vegetableValues", valueRepository.findAllByType("Vegetable"));
		}
		if (!valueRepository.findAllByType("Grocery").isEmpty()) {
			result.put("groceryValues", valueRepository.findAllByType("Grocery"));
		}
		return result;
	}

	@Override
	public Value updateValue(Value value) {
		Value temp = valueRepository.findByName(value.getName());
		Value resultValue = null;
		if (temp != null && value != null) {
			resultValue = new Value(temp.getName(), temp.getType(), temp.getQuantity(), value.getAmount());
			valueRepository.delete(temp);
			valueRepository.save(resultValue);
		} else {
			if (temp == null) {
				System.out.println("Some Database issues are there.Please bear with us");
			} else {
				System.out.println("Value " + value + " has errors.");
			}
		}
		return resultValue;
	}

}
