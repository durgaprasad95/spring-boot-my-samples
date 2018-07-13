package basics.service;

import java.util.HashMap;
import java.util.List;

import basics.domain.Value;

public interface ValueService {

	Value addValue(Value value);

	Value getProduct(String type, String name);

	HashMap<String, List<Value>> getAllProducts();

	Value updateValue(Value value);
}
