package hh.swd.plantApp.web;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import hh.swd.plantApp.domain.Family;
import hh.swd.plantApp.domain.FamilyRepository;
import hh.swd.plantApp.domain.Plant;
import hh.swd.plantApp.domain.PlantRepository;

@Controller
public class PlantController {
	
	@Autowired
	private PlantRepository plantrepo;
	@Autowired
	private FamilyRepository famrepo;
	
	
	//IMAGES?
    @RequestMapping(value = "/marble", method = RequestMethod.GET,
            produces = MediaType.IMAGE_JPEG_VALUE)

    public void getImage(HttpServletResponse response) throws IOException {

        ClassPathResource imgFile = new ClassPathResource("images/marble.jpg");

        response.setContentType(MediaType.IMAGE_JPEG_VALUE);
        StreamUtils.copy(imgFile.getInputStream(), response.getOutputStream());
    }
	
	//INDEX
	@RequestMapping(value="/index", method = RequestMethod.GET)
	public String index(Model model) {
		model.addAttribute("plants", plantrepo.findAll());
		return "index";
	}
	
	//LOGIN
	@RequestMapping(value="/login")
	public String login() {
		return "login";
	}
	
	
	
	//REST LISTING
	@RequestMapping(value="/plants", method = RequestMethod.GET)
	public @ResponseBody List<Plant> plantListRest(){
		return (List<Plant>) plantrepo.findAll();
	}
	
	@RequestMapping(value="/plant/{id}", method = RequestMethod.GET)
	public @ResponseBody Optional<Plant> onePlantRest(@PathVariable("id") Long id){
		return plantrepo.findById(id);
	}
	
	
	
	//LIST PLANTS
	@RequestMapping(value="/plantlist", method = RequestMethod.GET)
	public String plantList(Model model) {
		model.addAttribute("plants", plantrepo.findAll());
		return "plantlist";
	}
	
	
	//ADD A PLANT
	
	@RequestMapping(value="/addplant")
	public String addPlant(Model model) {
		model.addAttribute("plant", new Plant());
		model.addAttribute("family", famrepo.findAll());
		return "addplant";
	}
	
	//SAVE PLANT
	
	@RequestMapping(value="/saveplant", method=RequestMethod.POST)
	public String savePlant(Plant plant) {
		plantrepo.save(plant);
		return "redirect:plantlist";	
	}
	
	//ADD A FAMILY
	
	@RequestMapping(value="/addfamily")
	public String addFamily(Model model) {
		model.addAttribute("family", new Family());
		return "addfamily";
	}
	
	
	//SAVE FAMILY
	
	@RequestMapping(value="/savefam", method=RequestMethod.POST)
	public String saveFamily(Family family) {
		famrepo.save(family);
		return "redirect:plantlist";	
	}
	
	
	//DELETE PLANT
	
	@RequestMapping(value="/delete/{id}", method=RequestMethod.GET)
	public String deletePlant(@PathVariable("id") Long id, Model model) {
		plantrepo.deleteById(id);
		return "redirect:../plantlist";
	}
	

	//EDIT PLANT
	
	@RequestMapping(value="/edit/{id}")
	public String editPlant(@PathVariable("id") Long id, Model model) {
		model.addAttribute("plant", plantrepo.findById(id));
		model.addAttribute("family", famrepo.findAll());
		return "editplant";
	}
	
	
	

}
