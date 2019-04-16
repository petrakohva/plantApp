package hh.swd.plantApp;

import static org.assertj.core.api.Assertions.assertThat;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import hh.swd.plantApp.domain.Plant;
import hh.swd.plantApp.domain.PlantRepository;
import hh.swd.plantApp.domain.FamilyRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class PlantRepositoryTest {

	@Autowired
	private PlantRepository plantrepo;
	private FamilyRepository famrepo;
	
	@Test
	public void findByNameReturnsPlant() {
		List<Plant> plants = plantrepo.findByName("Peikonlehti");
		
		assertThat(plants).hasSize(1);
		
	}
	
	@Test
	public void createNewPlant() {
		Plant plant = new Plant("Hopeaköynnös", "Tammikuu 2019", famrepo.findByFamilyName("Pothos").get(0));
		plantrepo.save(plant);
		assertThat(plant.getId()).isNotNull();
	}
}
