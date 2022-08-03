package at.ac.tuwien.sepm.groupphase.backend.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(AdminEntity.class)
public abstract class AdminEntity_ extends at.ac.tuwien.sepm.groupphase.backend.entity.User_ {

	public static volatile SingularAttribute<AdminEntity, Long> id;
	public static volatile SingularAttribute<AdminEntity, Boolean> SMS_Certification;

	public static final String ID = "id";
	public static final String S_MS__CERTIFICATION = "SMS_Certification";

}

