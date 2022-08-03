package at.ac.tuwien.sepm.groupphase.backend.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.SuperBuilder;

@Data
@Entity
@Table(name = "company")
@EqualsAndHashCode(callSuper = true)
@SuperBuilder
public class CompanyEntity extends User{


//	    @Id
//	    @Column(name="id")
//	    private Long id;
//
//
//	    @Column(nullable = false, unique = true)
//	    private String name;

	    @Column(nullable = false, unique = true)
	    private String url;


	    @Column(nullable = false, unique = true)
	    private String invoice;


	    @Column(nullable = false, unique = true)
	    private String linkForVideoCall;

	      @ManyToOne
		  @JoinColumn(name = "company_type_id")
		  @JsonBackReference
		  private CompanyTypeEntity companyType;



}
