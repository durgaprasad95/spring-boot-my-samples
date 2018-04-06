package basics.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import basics.model.Authority;

@Repository
public interface AuthorityRepository extends CrudRepository<Authority, Long> {

	@Query(value = "select * from AUTHORITIES where USER_NAME = ?1", nativeQuery = true)
	Authority findByCustomQuery(String userName);

	Authority findByRoles(String roles);
}
