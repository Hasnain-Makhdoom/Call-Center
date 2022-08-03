package at.ac.tuwien.sepm.groupphase.backend.entity;

import javax.persistence.*;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;

@Entity
@Table(name="customer")
@Data
@EqualsAndHashCode(callSuper = false)
@SuperBuilder
public class Customer extends User{

	@Column(nullable = false)
    private double balance;

}
