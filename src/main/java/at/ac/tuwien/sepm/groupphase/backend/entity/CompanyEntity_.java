package at.ac.tuwien.sepm.groupphase.backend.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(CompanyEntity.class)
public abstract class CompanyEntity_ extends at.ac.tuwien.sepm.groupphase.backend.entity.User_ {

	public static volatile SingularAttribute<CompanyEntity, CompanyTypeEntity> companyType;
	public static volatile SingularAttribute<CompanyEntity, String> invoice;
	public static volatile SingularAttribute<CompanyEntity, String> linkForVideoCall;
	public static volatile SingularAttribute<CompanyEntity, String> url;

	public static final String COMPANY_TYPE = "companyType";
	public static final String INVOICE = "invoice";
	public static final String LINK_FOR_VIDEO_CALL = "linkForVideoCall";
	public static final String URL = "url";

}

