package at.ac.tuwien.sepm.groupphase.backend.entity.mapper;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import at.ac.tuwien.sepm.groupphase.backend.endpoint.dto.TimeSheetDto;
import at.ac.tuwien.sepm.groupphase.backend.entity.TimeSheetEntity;

@Mapper(componentModel = "spring")
public interface TimeSheetMapper {
	TimeSheetDto TimeSheetToTimeSheetDTO(TimeSheetEntity entity);

    @InheritInverseConfiguration
    TimeSheetEntity TimeSheetDTOToTimeSheet(TimeSheetDto dto);
}
