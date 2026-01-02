package com.ggocodelab.ds_challenge_4.repositories;

import java.time.LocalDate;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ggocodelab.ds_challenge_4.entities.Sale;

public interface SaleRepository extends JpaRepository<Sale, Long>{
	
	@Query("SELECT s "
			+ "FROM Sale s "
			+ "JOIN FETCH s.seller "
			+ "WHERE UPPER(s.seller.name) "
			+ "LIKE UPPER(CONCAT('%', :seller, '%')) "
			+ "AND (:startDate IS NULL OR s.date >= :startDate )"
			+ "AND (:endDate IS NULL OR s.date <= :endDate)")
	Page<Sale> report(@Param("seller")String seller, 
			@Param("startDate") LocalDate startDate, 
			@Param("endDate") LocalDate endDate, 
			Pageable pageable);
}
