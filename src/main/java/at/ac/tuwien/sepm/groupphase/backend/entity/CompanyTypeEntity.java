package at.ac.tuwien.sepm.groupphase.backend.entity;


import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Data;

@Entity
@Table(name = "company_type")
@Data
public class CompanyTypeEntity {

	
	    @Id
	    @GeneratedValue(strategy = GenerationType.SEQUENCE)
	    private Long id;

	    @Column(nullable = false, unique = true)
	    @Size(max = 255)
	    private String name;
	    
	    
	    @OneToMany(mappedBy = "companyType",cascade = { CascadeType.ALL})
		 @JsonManagedReference
		 private List<CompanyEntity> companies;
	    
}
