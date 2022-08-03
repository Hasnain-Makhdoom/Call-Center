package at.ac.tuwien.sepm.groupphase.backend.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.SuperBuilder;

@Data
@Entity
@Table(name = "interpreter")
@EqualsAndHashCode(callSuper = false)
@SuperBuilder
public class InterpreterEntity extends User{


//	 @Id
//	    @Column(name="id")
//	    private Long id;


	    @Column(nullable = false, unique = true)
	    private boolean location_online;

	    @Column(nullable = false, unique = true)
	    private Boolean certificate;

	    @Column(nullable = false, unique = true)
	    private String bankDetails;


	    @Column(nullable = false, unique = true)
	    private String[] topic_knowledge;
}
