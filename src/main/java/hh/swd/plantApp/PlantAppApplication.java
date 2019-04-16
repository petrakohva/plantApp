package hh.swd.plantApp;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import hh.swd.plantApp.domain.Family;
import hh.swd.plantApp.domain.FamilyRepository;
import hh.swd.plantApp.domain.Plant;
import hh.swd.plantApp.domain.PlantRepository;
import hh.swd.plantApp.domain.User;
import hh.swd.plantApp.domain.UserRepository;



@SpringBootApplication
public class PlantAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(PlantAppApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner bookDemo(PlantRepository plantrepo, FamilyRepository famrepo, UserRepository userrepo ) {
		return (args) -> {
			famrepo.save(new Family("Monstera", "Tykkää valoisasta, mutta ei suoraa paahdetta. Kastelu kun multa on kuivaa. Sumutella kannattaa aina kun ehtii, etenkin lehtien alapinnoilta."));
			famrepo.save(new Family("Pothos", "Pärjää aika pienellä hoidolla. Kastelu kun multa on kuivaa ja pitää sumuttelusta sekä auringonvalosta."));
			
			plantrepo.save(new Plant("Peikonlehti", "Syyskuu 2018", famrepo.findByFamilyName("Monstera").get(0)));
			plantrepo.save(new Plant("Kultaköynnös", "Elokuu 2018", famrepo.findByFamilyName("Pothos").get(0)));
			
			User user1 = new User("user", "$2a$04$jd0qclLNkmgS.sYNNJn4N.TGm3d6hUqXVGdPKKXW3g.kwu5ClJWhu", "USER");
			User user2 = new User("admin", "$2a$04$uFdAKugLPJCS6sSkn.JnIuwqpibVV3Qffz53C31cTZz.tAXPloor6", "ADMIN");
			userrepo.save(user1);
			userrepo.save(user2);
	};

	}
}
