package at.ac.tuwien.sepm.groupphase.backend.endpoint.dto;

import at.ac.tuwien.sepm.groupphase.backend.endpoint.dto.user.UserDTO;
import lombok.Data;

@Data
public class CalendarDto {

	
	  
	    private Long id;

	   
	    private String title;
	    
	    private UserDTO user;
	
}
