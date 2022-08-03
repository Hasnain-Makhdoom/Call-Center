package at.ac.tuwien.sepm.groupphase.backend.endpoint.dto.company;



import at.ac.tuwien.sepm.groupphase.backend.endpoint.dto.CompanyTypeDto;
import at.ac.tuwien.sepm.groupphase.backend.entity.File;
import lombok.Data;


@Data
public class CompanyDto {

	   private long id;
	    private String url;
	    
	    private String invoice;
	    
	    private String linkForVideoCall;
	    
	    private CompanyTypeDto companyType;
}
