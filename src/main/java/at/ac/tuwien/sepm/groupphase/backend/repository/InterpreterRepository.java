package at.ac.tuwien.sepm.groupphase.backend.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import at.ac.tuwien.sepm.groupphase.backend.entity.InterpreterEntity;

@Repository
public interface InterpreterRepository extends PagingAndSortingRepository<InterpreterEntity,Long>{
	
	
	Page<InterpreterEntity> findByFirstNameContainingIgnoreCase(String name, Pageable pageable);

    
	 InterpreterEntity findByfirstName(String name);

	
	 void deleteById(Long id);

	 List<InterpreterEntity> findAllByFirstName(String name);
	
}
