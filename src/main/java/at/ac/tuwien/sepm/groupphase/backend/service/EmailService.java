package at.ac.tuwien.sepm.groupphase.backend.service;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;

import at.ac.tuwien.sepm.groupphase.backend.endpoint.dto.EmailDto;
import at.ac.tuwien.sepm.groupphase.backend.exception.ServiceException;

public interface EmailService {

	
Page<EmailDto> findByName(String name, Integer page, Integer pageSize);

    
    void deleteById(Long id) throws ServiceException, DataIntegrityViolationException;

   
    EmailDto update(EmailDto dto) throws ServiceException;

    
    EmailDto add(EmailDto dto) throws ServiceException;

}
