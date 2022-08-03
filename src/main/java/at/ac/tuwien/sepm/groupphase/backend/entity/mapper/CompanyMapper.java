package at.ac.tuwien.sepm.groupphase.backend.entity.mapper;

import org.mapstruct.Mapper;

import at.ac.tuwien.sepm.groupphase.backend.endpoint.dto.company.CompanyDto;
import at.ac.tuwien.sepm.groupphase.backend.entity.CompanyEntity;

@Mapper(componentModel = "spring")
public interface CompanyMapper {

	CompanyEntity CompanyDTOToCompany(CompanyDto dto);

	 
	CompanyDto CompanyToCompanyDTO(CompanyEntity entity);
	
}
