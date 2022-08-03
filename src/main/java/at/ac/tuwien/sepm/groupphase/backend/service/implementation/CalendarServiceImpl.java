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

import at.ac.tuwien.sepm.groupphase.backend.endpoint.dto.CalendarDto;
import at.ac.tuwien.sepm.groupphase.backend.entity.mapper.CalendarMapper;
import at.ac.tuwien.sepm.groupphase.backend.exception.NotFoundException;
import at.ac.tuwien.sepm.groupphase.backend.exception.ServiceException;
import at.ac.tuwien.sepm.groupphase.backend.repository.CalendarRepository;
import at.ac.tuwien.sepm.groupphase.backend.repository.EventRepository;
import at.ac.tuwien.sepm.groupphase.backend.service.CalendarService;

@Service
public class CalendarServiceImpl implements CalendarService {

		@Autowired
	    private  CalendarRepository repository;
		@Autowired
	    private  EventRepository eventRepository;
		@Autowired(required=false)
	    private  CalendarMapper mapper;
	    private Logger LOGGER = LoggerFactory.getLogger(getClass());

	    
	   
//	    public CalendarServiceImpl(CalendarRepository repository, CalendarMapper mapper, EventRepository eventRepository) {
//	        this.repository = repository;
//	        this.mapper = mapper;
//	        this.eventRepository = eventRepository;
//	    }

	    @Override
	    public Page<CalendarDto> findByName(String name, Integer page, Integer pageSize) {
	        LOGGER.info("CalendarServiceImpl: findByName");
//	        if(pageSize == null) {
//	            //default size
//	            pageSize = 10;
//	        }
//	        if (page < 0) {
//	            throw new IllegalArgumentException("Not a valid page.");
//	        }
//	        Pageable pageable;
//	        if (name.equals("-1")) {
//	        	name = "";
//	            pageable = Pageable.unpaged();
//	        } else
	        
	        Pageable pageable = PageRequest.of(page, pageSize);
	        Page<CalendarDto> result = repository.findByNameContainingIgnoreCase(name, pageable).map(mapper::calendarToCalendarDTO);
	        if (!result.hasContent()) throw new NotFoundException("No calendar found");
	        if (result.getContent().size() == 0) throw new NotFoundException("No calendar found");
	        return result;
	    }

	    @Override
	    public CalendarDto update(CalendarDto dto) throws ServiceException {
	        LOGGER.info("CalendarServiceImpl: update");
	        try {
	            return mapper.calendarToCalendarDTO(repository.save(mapper.calendarDTOToCalendar(dto)));
	        } catch (DataIntegrityViolationException e) {
	            throw new ServiceException("Calendar name already exists.");
	        }
	        catch (PersistenceException e) {
	            throw new ServiceException(e.getMessage());
	        }
	    }

	    @Override
	    public CalendarDto add(CalendarDto dto) throws ServiceException {
	        LOGGER.info("CalendarServiceImpl: add");
	        try {
	            return mapper.calendarToCalendarDTO(repository.save(mapper.calendarDTOToCalendar(dto)));
	        } catch (DataIntegrityViolationException e) {
	            throw new ServiceException("Artist name already exists.");
	        } catch (PersistenceException e) {
	            throw new ServiceException(e.getMessage());
	        }
	    }

	    @Override
	    public void deleteById(Long id) throws ServiceException, DataIntegrityViolationException {
	        LOGGER.info("CalendarServiceImpl: deleteById " + id);
	        try {
//	            if (eventRepository.findAllByArtist_Id(id, PageRequest.of(0, 1)).hasContent())
//	                throw new DataIntegrityViolationException("Entity is referenced by an event! Deleting it will violate the referential integrity constaint.");
	            repository.deleteById(id);
	        } catch (PersistenceException e) {
	            throw new ServiceException(e.getMessage());
	        }
	    }
	
}
