package at.ac.tuwien.sepm.groupphase.backend.endpoint.dto;

import java.sql.Time;

import lombok.Data;


@Data
public class LoginUserResponseDto {

	
	private Long id;

	   
    private String firstName;
    
  
    private String lastNname;


    private String username;
    
   
    private String profilephoto;
    
   
    private Boolean online_status;
    
  
    private Time counter;
    
    private String role;
    
}
