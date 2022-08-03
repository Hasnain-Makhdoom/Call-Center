package at.ac.tuwien.sepm.groupphase.backend.service;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;

import at.ac.tuwien.sepm.groupphase.backend.endpoint.dto.TimeSheetDto;
import at.ac.tuwien.sepm.groupphase.backend.exception.ServiceException;

public interface TimesheetService {

	
Page<TimeSheetDto> findByName(String name, Integer page, Integer pageSize);

    
    void deleteById(Long id) throws ServiceException, DataIntegrityViolationException;

   
    TimeSheetDto update(TimeSheetDto dto) throws ServiceException;

    
    TimeSheetDto add(TimeSheetDto dto) throws ServiceException;
}
