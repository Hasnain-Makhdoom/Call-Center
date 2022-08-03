package at.ac.tuwien.sepm.groupphase.backend.entity.mapper;

import org.mapstruct.Mapper;

import at.ac.tuwien.sepm.groupphase.backend.endpoint.dto.EmailDto;
import at.ac.tuwien.sepm.groupphase.backend.entity.EmailsEntity;

@Mapper(componentModel = "spring")
public interface EmailMapper {

	EmailsEntity EmailDTOToEmail(EmailDto dto);

	 
	EmailDto EmailToEmailDTO(EmailsEntity entity);
	
}
