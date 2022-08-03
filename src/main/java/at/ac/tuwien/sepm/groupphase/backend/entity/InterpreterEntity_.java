package at.ac.tuwien.sepm.groupphase.backend.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(InterpreterEntity.class)
public abstract class InterpreterEntity_ extends at.ac.tuwien.sepm.groupphase.backend.entity.User_ {

	public static volatile SingularAttribute<InterpreterEntity, String> bankDetails;
	public static volatile SingularAttribute<InterpreterEntity, Boolean> location_online;
	public static volatile SingularAttribute<InterpreterEntity, String[]> topic_knowledge;
	public static volatile SingularAttribute<InterpreterEntity, Boolean> certificate;

	public static final String BANK_DETAILS = "bankDetails";
	public static final String LOCATION_ONLINE = "location_online";
	public static final String TOPIC_KNOWLEDGE = "topic_knowledge";
	public static final String CERTIFICATE = "certificate";

}

