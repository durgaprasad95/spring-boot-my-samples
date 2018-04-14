package basics.service;

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
		valueRepository.save(value);
		return value;
	}

}
