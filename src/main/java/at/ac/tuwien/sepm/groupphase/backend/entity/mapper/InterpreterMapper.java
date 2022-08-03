package at.ac.tuwien.sepm.groupphase.backend.entity.mapper;

import org.mapstruct.Mapper;

import at.ac.tuwien.sepm.groupphase.backend.endpoint.dto.interpreter.InterpreterDto;
import at.ac.tuwien.sepm.groupphase.backend.entity.InterpreterEntity;

@Mapper(componentModel = "spring")
public interface InterpreterMapper {

	
	InterpreterEntity InterpreterDTOToInterpreter(InterpreterDto dto);

	 
	InterpreterDto InterpreterToInterpreterDTO(InterpreterEntity entity);
}
