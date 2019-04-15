package hh.swd.plantApp.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface PlantRepository extends CrudRepository<Plant, Long> {
	
	List<Plant> findByName(String name);

}
