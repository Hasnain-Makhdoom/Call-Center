package at.ac.tuwien.sepm.groupphase.backend.entity.mapper;

import org.mapstruct.Mapper;

import at.ac.tuwien.sepm.groupphase.backend.endpoint.dto.CalendarDto;
import at.ac.tuwien.sepm.groupphase.backend.entity.CalendarEntity;

@Mapper(componentModel = "spring")
public interface CalendarMapper {

	
	
    CalendarEntity calendarDTOToCalendar(CalendarDto dto);

 
    CalendarDto calendarToCalendarDTO(CalendarEntity entity);
}
