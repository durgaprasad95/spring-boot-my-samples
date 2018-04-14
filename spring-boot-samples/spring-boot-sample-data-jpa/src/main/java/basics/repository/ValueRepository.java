package basics.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import basics.domain.Value;

@Repository
public interface ValueRepository extends CrudRepository<Value, String> {

	Value findByName(String name);
}
