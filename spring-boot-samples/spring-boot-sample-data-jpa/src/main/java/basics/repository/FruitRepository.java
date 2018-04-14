package basics.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import basics.domain.Fruit;

@Repository
public interface FruitRepository extends CrudRepository<Fruit, Long> {

}
