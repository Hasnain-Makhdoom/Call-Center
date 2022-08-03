package at.ac.tuwien.sepm.groupphase.backend.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(LoginAttempts.class)
public abstract class LoginAttempts_ {

	public static volatile SingularAttribute<LoginAttempts, Boolean> blocked;
	public static volatile SingularAttribute<LoginAttempts, Long> id;
	public static volatile SingularAttribute<LoginAttempts, User> user;
	public static volatile SingularAttribute<LoginAttempts, Integer> attempts;

	public static final String BLOCKED = "blocked";
	public static final String ID = "id";
	public static final String USER = "user";
	public static final String ATTEMPTS = "attempts";

}

