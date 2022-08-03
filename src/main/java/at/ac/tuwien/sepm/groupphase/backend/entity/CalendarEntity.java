package at.ac.tuwien.sepm.groupphase.backend.entity;

import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.Data;

@Data
@Entity
@Table(name = "admin")
public class CalendarEntity {

	
	    @Id
	    @Column(name="id")
	    private Long id;

	    @Column(nullable = false, unique = true)
	    private String name;
	   
	    @Column(nullable = false, unique = true)
	    private String title;
	
	    
	      @ManyToOne
		  @JoinColumn(name = "user_id")
		  @JsonBackReference
		  private User user;
	      
	    
	      
	      
	      
}
