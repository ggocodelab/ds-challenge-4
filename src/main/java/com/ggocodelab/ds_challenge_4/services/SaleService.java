package com.ggocodelab.ds_challenge_4.services;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ggocodelab.ds_challenge_4.dto.SaleDTO;
import com.ggocodelab.ds_challenge_4.dto.SellerTotalDTO;
import com.ggocodelab.ds_challenge_4.entities.Sale;
import com.ggocodelab.ds_challenge_4.repositories.SaleRepository;


@Service
public class SaleService {
	
	@Autowired
	private SaleRepository repository;
	
	@Transactional(readOnly = true)
	public Page<SaleDTO> report(
			String seller, 
			LocalDate minDate, 
			LocalDate maxDate, 
			Pageable pageable
	) {
		LocalDate today = LocalDate.now();
		
		if(minDate == null && maxDate == null) {			
			maxDate = today;
			minDate = today.minusMonths(12);			
		}	
		
		if (maxDate == null){
			maxDate = today;
		}
			
		if(minDate == null) {
			minDate = maxDate.minusYears(1);
		}
			
		Page<Sale> page = repository.report(seller, minDate, maxDate, pageable);
		return page.map(x -> new SaleDTO(x));
	}	

	@Transactional(readOnly = true)
	public SaleDTO findById(Long id) {
		Optional<Sale> result = repository.findById(id);
		Sale sale = result.get();
		SaleDTO dto = new SaleDTO(sale);
		return dto;
	}	
		
	@Transactional(readOnly = true)
	public Page<SellerTotalDTO> summary( 
			LocalDate minDate, 
			LocalDate maxDate,
			Pageable pageable
	) {
		if(minDate != null || maxDate != null) {
			LocalDate today = LocalDate.now();
			
			if(maxDate == null) {
				maxDate = today;
			}
			if(minDate == null) {
				minDate = maxDate.minusYears(1);
			}
		}		
		return repository.summary(minDate, maxDate, pageable);
	}	
}
