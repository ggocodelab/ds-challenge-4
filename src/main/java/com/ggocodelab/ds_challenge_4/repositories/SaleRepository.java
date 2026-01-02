package com.ggocodelab.ds_challenge_4.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ggocodelab.ds_challenge_4.entities.Sale;

public interface SaleRepository extends JpaRepository<Sale, Long>{
	
	@Query("SELECT s "
			+ "FROM Sale s "
			+ "JOIN FETCH s.seller "
			+ "WHERE UPPER(s.seller.name) "
			+ "LIKE UPPER(CONCAT('%', :seller, '%'))")
	Page<Sale> report(String seller, Pageable pageable);
}
