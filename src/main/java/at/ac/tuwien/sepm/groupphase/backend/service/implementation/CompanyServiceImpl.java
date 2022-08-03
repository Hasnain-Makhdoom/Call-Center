package at.ac.tuwien.sepm.groupphase.backend.service.implementation;

import javax.persistence.PersistenceException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import at.ac.tuwien.sepm.groupphase.backend.endpoint.dto.company.CompanyDto;
import at.ac.tuwien.sepm.groupphase.backend.entity.CompanyEntity;
import at.ac.tuwien.sepm.groupphase.backend.entity.mapper.CalendarMapper;
import at.ac.tuwien.sepm.groupphase.backend.entity.mapper.CompanyMapper;
import at.ac.tuwien.sepm.groupphase.backend.exception.NotFoundException;
import at.ac.tuwien.sepm.groupphase.backend.exception.ServiceException;
import at.ac.tuwien.sepm.groupphase.backend.repository.CalendarRepository;
import at.ac.tuwien.sepm.groupphase.backend.repository.CompanyRepository;
import at.ac.tuwien.sepm.groupphase.backend.repository.EventRepository;
import at.ac.tuwien.sepm.groupphase.backend.service.CompanyService;


@Service
public class CompanyServiceImpl implements CompanyService {

	
	@Autowired
    private  CompanyRepository repository;
	
	//@Autowired
   // private  EventRepository eventRepository;
	
	@Autowired(required=false)
    private  CompanyMapper mapper;
    private Logger LOGGER = LoggerFactory.getLogger(getClass());

    
   
//    public CompanyServiceImpl(CompanyRepository repository, CompanyMapper mapper, EventRepository eventRepository) {
//        this.repository = repository;
//        this.mapper = mapper;
//       // this.eventRepository = eventRepository;
//    }

    @Override
    public Page<CompanyDto> findByName(String name, Integer page, Integer pageSize) {
        LOGGER.info("CalendarServiceImpl: findByName");
      
        
        
        Pageable pageable = PageRequest.of(page, pageSize);
        Page<CompanyDto> result = repository.findByFirstNameContainingIgnoreCase(name, pageable).map(mapper::CompanyToCompanyDTO);
        if (!result.hasContent()) throw new NotFoundException("No company found");
        if (result.getContent().size() == 0) throw new NotFoundException("No company found");
        return result;
    }

    @Override
    public CompanyDto update(CompanyDto dto) throws ServiceException {
        LOGGER.info("CompanyService: updatet");
        try {
            return mapper.CompanyToCompanyDTO(repository.save(mapper.CompanyDTOToCompany(dto)));
        } catch (DataIntegrityViolationException e) {
            throw new ServiceException("comapany name already exists.");
        }
        catch (PersistenceException e) {
            throw new ServiceException(e.getMessage());
        }
    }

    @Override
    public CompanyDto add(CompanyDto dto) throws ServiceException {
        LOGGER.info("CompanyService: add");
        try {
            return mapper.CompanyToCompanyDTO(repository.save(mapper.CompanyDTOToCompany(dto)));
        } catch (DataIntegrityViolationException e) {
            throw new ServiceException("Company name already exists.");
        } catch (PersistenceException e) {
            throw new ServiceException(e.getMessage());
        }
    }

    @Override
    public void deleteById(Long id) throws ServiceException, DataIntegrityViolationException {
        LOGGER.info("CompanyService: deleteById " + id);
        try {
//            if (eventRepository.findAllByArtist_Id(id, PageRequest.of(0, 1)).hasContent())
//                throw new DataIntegrityViolationException("Entity is referenced by an event! Deleting it will violate the referential integrity constaint.");
            repository.deleteById(id);
        } catch (PersistenceException e) {
            throw new ServiceException(e.getMessage());
        }
    }
}
