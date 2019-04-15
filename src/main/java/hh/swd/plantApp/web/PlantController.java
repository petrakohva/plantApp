package hh.swd.plantApp.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import hh.swd.plantApp.domain.FamilyRepository;
import hh.swd.plantApp.domain.Plant;
import hh.swd.plantApp.domain.PlantRepository;

@Controller
public class PlantController {
	
	@Autowired
	private PlantRepository plantrepo;
	@Autowired
	private FamilyRepository famrepo;
	
	//INDEX
	@RequestMapping(value="/index")
	public String index() {
		return "index";
	}
	
	//LOGIN
	@RequestMapping(value="/login")
	public String login() {
		return "login";
	}
	
	
	//REST
	@RequestMapping(value="/plants", method = RequestMethod.GET)
	public @ResponseBody List<Plant> plantListRest(){
		return (List<Plant>) plantrepo.findAll();
	}
	
	@RequestMapping(value="/plant/{id}", method = RequestMethod.GET)
	public @ResponseBody Optional<Plant> onePlantRest(@PathVariable("id") Long id){
		return plantrepo.findById(id);
	}
	
	//LIST
	@RequestMapping(value="/plantlist", method = RequestMethod.GET)
	public String plantList(Model model) {
		model.addAttribute("plants", plantrepo.findAll());
		return "plantlist";
	}
	
	
	
	

}
