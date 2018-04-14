package basics.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import basics.domain.Vegetable;

@Repository
public interface VegetableRepository extends CrudRepository<Vegetable,Long>{

}
