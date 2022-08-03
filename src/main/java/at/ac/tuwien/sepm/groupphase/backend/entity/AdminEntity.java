package at.ac.tuwien.sepm.groupphase.backend.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.experimental.SuperBuilder;


@Data
@Entity
@Table(name = "admin")
@SuperBuilder
public class AdminEntity extends User{

	    @Id
	    @Column(name="id")
	    private Long id;


	    @Column(nullable = false, unique = true)
	    private Boolean SMS_Certification;
}
