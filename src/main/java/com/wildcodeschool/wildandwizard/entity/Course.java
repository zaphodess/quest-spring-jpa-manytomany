package com.wildcodeschool.wildandwizard.entity;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import com.wildcodeschool.wildandwizard.entity.Wizard;

@Entity
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    
	//public Comparator<Course> byId = Comparator.comparing(Course::getId);
    
    @ManyToMany(
    		mappedBy = "courses", 
    		fetch = FetchType.EAGER, 
    		cascade = CascadeType.ALL
    )
    private List<Wizard> wizards = new ArrayList<Wizard>();

    public List<Wizard> getWizards() {
		return wizards;
	}

	public void setWizards(List<Wizard> wizards) {
		this.wizards = wizards;
	}

	public Course() {
    }

    public Course(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
