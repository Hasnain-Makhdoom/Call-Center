package at.ac.tuwien.sepm.groupphase.backend.endpoint.dto;


import at.ac.tuwien.sepm.groupphase.backend.endpoint.dto.user.UserDTO;
import at.ac.tuwien.sepm.groupphase.backend.entity.File;
import lombok.Data;


@Data
public class TimeSheetDto {

	
    private Long id;
    private String name;
    private String sheet;
    private UserDTO user;
}
