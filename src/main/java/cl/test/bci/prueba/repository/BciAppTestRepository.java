package cl.test.bci.prueba.repository;

import cl.test.bci.prueba.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface BciAppTestRepository extends JpaRepository<Users, String> {

	@Query(value = "SELECT h FROM Users h where h.username= ?1")
	public Users findUser(String username);
	
}
