package com.ggocodelab.ds_challenge_4.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ggocodelab.ds_challenge_4.dto.SaleDTO;
import com.ggocodelab.ds_challenge_4.entities.Sale;
import com.ggocodelab.ds_challenge_4.repositories.SaleRepository;


@Service
public class SaleService {
	
	@Autowired
	private SaleRepository repository;
	
	@Transactional(readOnly = true)
	public List<SaleDTO> findAll() {
		List<Sale> result = repository.findAll();
		return result.stream().map(x -> new SaleDTO(x)).toList();
	}

}
