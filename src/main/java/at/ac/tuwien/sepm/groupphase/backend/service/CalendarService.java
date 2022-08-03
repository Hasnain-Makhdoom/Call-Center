package at.ac.tuwien.sepm.groupphase.backend.service;




import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;

import at.ac.tuwien.sepm.groupphase.backend.endpoint.dto.CalendarDto;
import at.ac.tuwien.sepm.groupphase.backend.exception.ServiceException;

public interface CalendarService {

	
    Page<CalendarDto> findByName(String artistName, Integer page, Integer pageSize);

    
    void deleteById(Long id) throws ServiceException, DataIntegrityViolationException;

   
    CalendarDto update(CalendarDto dto) throws ServiceException;

    
    CalendarDto add(CalendarDto dto) throws ServiceException;

}
