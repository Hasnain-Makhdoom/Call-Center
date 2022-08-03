package at.ac.tuwien.sepm.groupphase.backend.service;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;

import at.ac.tuwien.sepm.groupphase.backend.endpoint.dto.interpreter.InterpreterDto;
import at.ac.tuwien.sepm.groupphase.backend.exception.ServiceException;

public interface InterpreterService {

	
Page<InterpreterDto> findByName(String artistName, Integer page, Integer pageSize);

    
    void deleteById(Long id) throws ServiceException, DataIntegrityViolationException;

   
    InterpreterDto update(InterpreterDto dto) throws ServiceException;

    
    InterpreterDto add(InterpreterDto dto) throws ServiceException;
}
