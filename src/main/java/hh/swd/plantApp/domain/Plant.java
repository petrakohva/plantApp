package hh.swd.plantApp.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Plant {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	private String name;
	private String date;
	
	
	@ManyToOne
	@JsonIgnore
	@JoinColumn(name= "familyid")
	private Family family;
	
	
	public Plant() {
		
	}
	
	public Plant(String name, String date, Family family) {
		super();
		this.name = name;
		this.date = date;
		this.family = family;
	}
	

	public void setId(Long id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public void setFamily(Family family) {
		this.family = family;
	}
	
	

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getDate() {
		return date;
	}

	public Family getFamily() {
		return family;
	}
	
	

	@Override
	public String toString() {
		if(this.family != null)
			return "Plant [id=" + id + ", name=" + name + ", date=" + date +  "family =" + this.getFamily() + "]";
		else
			return "Plant [id=" + id + ", name=" + name + ", date=" + date + "]";
	}
	
	
	
	
	
	
	
	
	

}
