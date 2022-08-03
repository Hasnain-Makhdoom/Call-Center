package at.ac.tuwien.sepm.groupphase.backend.service;



import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;

import at.ac.tuwien.sepm.groupphase.backend.endpoint.dto.company.CompanyDto;
import at.ac.tuwien.sepm.groupphase.backend.exception.ServiceException;

public interface CompanyService {

	
	
	 Page<CompanyDto> findByName(String name, Integer page, Integer pageSize);

	    
	    void deleteById(Long id) throws ServiceException, DataIntegrityViolationException;

	   
	    CompanyDto update(CompanyDto dto) throws ServiceException;

	    
	    CompanyDto add(CompanyDto dto) throws ServiceException;
}
