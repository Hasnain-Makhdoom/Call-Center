package at.ac.tuwien.sepm.groupphase.backend.endpoint.dto;

import at.ac.tuwien.sepm.groupphase.backend.endpoint.dto.user.UserDTO;
import lombok.Data;

@Data
public class EmailDto {

	
	 
	    private Long id;

	  
	    private String title;
	    
	    private String email;
	    
	    private UserDTO user;
}
