package at.ac.tuwien.sepm.groupphase.backend.endpoint;

import javax.validation.Valid;
import javax.validation.constraints.Positive;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import at.ac.tuwien.sepm.groupphase.backend.endpoint.dto.CalendarDto;
import at.ac.tuwien.sepm.groupphase.backend.exception.NotFoundException;
import at.ac.tuwien.sepm.groupphase.backend.exception.ServiceException;
import at.ac.tuwien.sepm.groupphase.backend.service.CalendarService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Authorization;


@CrossOrigin
@RestController
public class CalendarEndpoint {

	@Autowired
    private  CalendarService service;
	private final Logger LOGGER = LoggerFactory.getLogger(getClass());

	    public CalendarEndpoint(CalendarService service) {
	        this.service = service;
	    }


	    @GetMapping(value="/get/calendar")
//	    @ApiOperation(value = "Get calendar with 'Name' as part of their name", authorizations = {@Authorization(value = "apiKey")})
	    public Page<CalendarDto> findByName(@RequestParam(value = "name") String name,
	                                             @RequestParam(value = "page",defaultValue = "0") Integer page,
	                                             @RequestParam(value = "pageSize",defaultValue = "10") @Positive Integer pageSize) {
	        LOGGER.info("CalendarEndpoint: findByName");
	        return service.findByName(name, page, pageSize);
	    }

	    @PostMapping(value="/save/calendar")
	    @PreAuthorize("hasRole('ADMIN')")
	    @ApiOperation(value = "Add an appointment by id", authorizations = {@Authorization(value = "apiKey")})
	    public CalendarDto add(@Valid @RequestBody CalendarDto dto) {
	        LOGGER.info("CalendarEndpoint: Add an appointment " + dto.toString());
	        try {
	            return service.add(dto);
	        } catch (ServiceException e) {
	            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Error during adding a appointment: " + e.getMessage(), e);
	        } catch (NotFoundException e) {
	            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Error when reading appointment: " + e.getMessage(), e);
	        }
	    }

	    @PutMapping(value = "/update/calendar/{id}")
	    @PreAuthorize("hasRole('ADMIN')")
	    @ApiOperation(value = "Update an appointment by id", authorizations = {@Authorization(value = "apiKey")})
	    public CalendarDto update(@Valid @RequestBody CalendarDto dto, @PathVariable("id") Long id) {
	        LOGGER.info("CalendarEndpoint: update");
	        dto.setId(id);
	        try {
	            return service.update(dto);
	        } catch (ServiceException e) {
	            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Error during adding a appointment: " + e.getMessage(), e);
	        } catch (NotFoundException e) {
	            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Error when reading appointment: " + e.getMessage(), e);
	        }
	    }

	    @DeleteMapping(value = "/delete/calendar/{id}")
	    @PreAuthorize("hasRole('ADMIN')")
	    @ApiOperation(value = "Delete an appointment by id", authorizations = {@Authorization(value = "apiKey")})
	    public void deleteById(@PathVariable Long id) {
	        LOGGER.info("CalendarEndpoint: deleteById " + id);
	        try {
	            service.deleteById(id);
	        } catch (ServiceException e) {
	            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
	        }
	    }

}
