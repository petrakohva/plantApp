package hh.swd.plantApp.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Family {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long familyId;
	
	private String familyName;
	private String care;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "family")
	private List<Plant> plants;
	
	public Family() {
		
	}
	
	public Family(String familyName, String care) {
		super();
		this.familyName = familyName;
		this.care = care;
	}

	
	
	public void setFamilyId(Long familyId) {
		this.familyId = familyId;
	}

	public void setFamilyName(String familyName) {
		this.familyName = familyName;
	}

	public void setCare(String care) {
		this.care = care;
	}

	public void setPlants(List<Plant> plants) {
		this.plants = plants;
	}
	

	public Long getFamilyId() {
		return familyId;
	}

	public String getFamilyName() {
		return familyName;
	}
	
	
	public String getCare() {
		return care;
	}

	public List<Plant> getPlants() {
		return plants;
	}

	@Override
	public String toString() {
		return "Family [familyId=" + familyId + ", familyName=" + familyName + ", care=" + care + "]";
	}
	

	
	
	
	
	
	
	
	

}
