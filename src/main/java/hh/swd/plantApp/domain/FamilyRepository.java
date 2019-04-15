package hh.swd.plantApp.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface FamilyRepository extends CrudRepository<Family, Long> {
	
	List<Family> findByFamilyName(String familyName);

}
