package com.proyect.management.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.proyect.management.entity.InfoAdnEntity;

/**
 * Info Adn Dao.
 * @author HABUR
 *
 */
@Repository
public interface InfoAdnDao extends  CrudRepository<InfoAdnEntity,Long> {
	
	public List<InfoAdnEntity> findAll();
	
	@Query(value = "SELECT sum(countDna) FROM InfoAdnEntity")
	public Double findAllSumDnaStatistics();
	
	@Query(value = "SELECT count(1) FROM InfoAdnEntity")
	public Double findAllCountDnaStatistics();

}
