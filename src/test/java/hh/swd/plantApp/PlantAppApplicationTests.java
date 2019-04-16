package hh.swd.plantApp;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import hh.swd.plantApp.web.PlantController;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PlantAppApplicationTests {

	@Autowired
	private PlantController controller;
	@Test
	public void contextLoads() throws Exception {
	assertThat(controller).isNotNull();
	}

}
