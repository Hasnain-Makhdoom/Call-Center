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

import at.ac.tuwien.sepm.groupphase.backend.endpoint.dto.interpreter.InterpreterDto;
import at.ac.tuwien.sepm.groupphase.backend.entity.mapper.InterpreterMapper;
import at.ac.tuwien.sepm.groupphase.backend.exception.NotFoundException;
import at.ac.tuwien.sepm.groupphase.backend.exception.ServiceException;
import at.ac.tuwien.sepm.groupphase.backend.repository.InterpreterRepository;
import at.ac.tuwien.sepm.groupphase.backend.repository.EventRepository;
import at.ac.tuwien.sepm.groupphase.backend.service.InterpreterService;

@Service
public class InterpreterServiceImpl implements InterpreterService {

	@Autowired
    private  InterpreterRepository repository;
	
	
  
	@Autowired(required=false)
    private  InterpreterMapper mapper;
    private Logger LOGGER = LoggerFactory.getLogger(getClass());

    
   
//    public InterpreterServiceImpl(InterpreterRepository repository, InterpreterMapper mapper, EventRepository eventRepository) {
//        this.repository = repository;
//        this.mapper = mapper;
//       // this.eventRepository = eventRepository;
//    }

    @Override
    public Page<InterpreterDto> findByName(String name, Integer page, Integer pageSize) {
        LOGGER.info("InterpreterServiceImpl: findByName");
//        if(pageSize == null) {
//            //default size
//            pageSize = 10;
//        }
//        if (page < 0) {
//            throw new IllegalArgumentException("Not a valid page.");
//        }
//        Pageable pageable;
//        if (name.equals("-1")) {
//        	name = "";
//            pageable = Pageable.unpaged();
//        } else
        
        Pageable pageable = PageRequest.of(page, pageSize);
        Page<InterpreterDto> result = repository.findByFirstNameContainingIgnoreCase(name, pageable).map(mapper::InterpreterToInterpreterDTO);
        if (!result.hasContent()) throw new NotFoundException("No interpreter found");
        if (result.getContent().size() == 0) throw new NotFoundException("No interpreter found");
        return result;
    }

    @Override
    public InterpreterDto update(InterpreterDto dto) throws ServiceException {
        LOGGER.info("InterpreterService: updatet");
        try {
            return mapper.InterpreterToInterpreterDTO(repository.save(mapper.InterpreterDTOToInterpreter(dto)));
        } catch (DataIntegrityViolationException e) {
            throw new ServiceException("interpreter name already exists.");
        }
        catch (PersistenceException e) {
            throw new ServiceException(e.getMessage());
        }
    }

    @Override
    public InterpreterDto add(InterpreterDto dto) throws ServiceException {
        LOGGER.info("InterpreterService: add");
        try {
            return mapper.InterpreterToInterpreterDTO(repository.save(mapper.InterpreterDTOToInterpreter(dto)));
        } catch (DataIntegrityViolationException e) {
            throw new ServiceException("Interpreter name already exists.");
        } catch (PersistenceException e) {
            throw new ServiceException(e.getMessage());
        }
    }

    @Override
    public void deleteById(Long id) throws ServiceException, DataIntegrityViolationException {
        LOGGER.info("InterpreterService: deleteById " + id);
        try {
//            if (eventRepository.findAllByArtist_Id(id, PageRequest.of(0, 1)).hasContent())
//                throw new DataIntegrityViolationException("Entity is referenced by an event! Deleting it will violate the referential integrity constaint.");
            repository.deleteById(id);
        } catch (PersistenceException e) {
            throw new ServiceException(e.getMessage());
        }
    }
	
}
