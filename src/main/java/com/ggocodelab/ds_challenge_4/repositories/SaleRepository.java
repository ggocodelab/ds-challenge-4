package com.ggocodelab.ds_challenge_4.repositories;

import java.time.LocalDate;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ggocodelab.ds_challenge_4.dto.SellerTotalDTO;
import com.ggocodelab.ds_challenge_4.entities.Sale;

public interface SaleRepository extends JpaRepository<Sale, Long>{
	
	@Query("SELECT s "
			+ "FROM Sale s "
			+ "JOIN FETCH s.seller "
			+ "WHERE UPPER(s.seller.name) LIKE UPPER(CONCAT('%', :seller, '%')) "
			+ "AND (:minDate IS NULL OR s.date >= :minDate) "
			+ "AND (:maxDate IS NULL OR s.date <= :maxDate)"
			)
	Page<Sale> report(
			@Param("seller") String seller, 
			@Param("minDate") LocalDate minDate, 
			@Param("maxDate") LocalDate maxDate, 
			Pageable pageable
	);

	
	@Query(value = """
			SELECT new com.ggocodelab.ds_challenge_4.dto.SellerTotalDTO(
			s.seller.id,
			s.seller.name,
			COALESCE(SUM(s.amount), 0.0)
			)
			FROM Sale s
			JOIN s.seller
			WHERE s.date BETWEEN COALESCE(:minDate, s.date) 
			                 AND COALESCE(:maxDate, s.date)
			GROUP BY s.seller.id, s.seller.name
			""",
	countQuery = """
			SELECT COUNT(DISTINCT s.seller.id)
			FROM Sale s
			WHERE s.date BETWEEN COALESCE(:minDate, s.date) 
			                 AND COALESCE(:maxDate, s.date)
			""")
	Page<SellerTotalDTO> summary(
			@Param("minDate") LocalDate minDate,
			@Param("maxDate") LocalDate maxDate,
			Pageable pageable
    );
}
