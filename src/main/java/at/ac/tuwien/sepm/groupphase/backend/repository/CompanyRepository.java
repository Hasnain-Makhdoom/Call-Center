package at.ac.tuwien.sepm.groupphase.backend.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import at.ac.tuwien.sepm.groupphase.backend.entity.CompanyEntity;


@Repository
public interface CompanyRepository extends PagingAndSortingRepository<CompanyEntity,Long>  {

	 Page<CompanyEntity> findByFirstNameContainingIgnoreCase(String name, Pageable pageable);

	    
	 CompanyEntity findByFirstName(String name);

	
	    void deleteById(Long id);

	    List<CompanyEntity> findAllByFirstName(String name);
	
}
