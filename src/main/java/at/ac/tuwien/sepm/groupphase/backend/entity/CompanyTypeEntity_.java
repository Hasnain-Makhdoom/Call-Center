package at.ac.tuwien.sepm.groupphase.backend.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(CompanyTypeEntity.class)
public abstract class CompanyTypeEntity_ {

	public static volatile ListAttribute<CompanyTypeEntity, CompanyEntity> companies;
	public static volatile SingularAttribute<CompanyTypeEntity, String> name;
	public static volatile SingularAttribute<CompanyTypeEntity, Long> id;

	public static final String COMPANIES = "companies";
	public static final String NAME = "name";
	public static final String ID = "id";

}

