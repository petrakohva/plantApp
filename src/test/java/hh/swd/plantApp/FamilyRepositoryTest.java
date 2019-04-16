package hh.swd.plantApp;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import hh.swd.plantApp.domain.Family;
import hh.swd.plantApp.domain.FamilyRepository;
import hh.swd.plantApp.domain.Plant;
import hh.swd.plantApp.domain.PlantRepository;


@RunWith(SpringRunner.class)
@DataJpaTest
public class FamilyRepositoryTest {


		@Autowired
		private FamilyRepository famrepo;
		
		@Test
		public void findByNameReturnsPlant() {
			List<Family> families = famrepo.findByFamilyName("Monstera");
			
			assertThat(families).hasSize(1);
			
		}
		
		@Test
		public void createNewPlant() {
			Family family = new Family("Calathea", "Perushoito");
			famrepo.save(family);
			assertThat(family.getFamilyId()).isNotNull();
		}
	}
