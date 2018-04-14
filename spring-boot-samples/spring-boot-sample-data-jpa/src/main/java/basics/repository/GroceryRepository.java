package basics.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import basics.domain.Grocery;

@Repository
public interface GroceryRepository extends CrudRepository<Grocery, Long> {

}
